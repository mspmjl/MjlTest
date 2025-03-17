package com.mjl.geo;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mjl.DistanceUtil;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author mjl
 * @date 2025/2/11.
 */
public class QgisGeoFromJsonUtil {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\DELL\\Desktop\\清江浦区图层2\\geojson";
        Path directory = Paths.get(path);

        List<String> fileNames = new ArrayList<>();
        // 递归遍历所有子目录和文件
        Files.walk(directory)
                .filter(Files::isRegularFile)
                .forEach(p -> fileNames.add(p.getFileName().toString()));

        Set<String> set = fileNames.stream().map(s -> s.split("-")[0]).collect(Collectors.toSet());

        File txt = new File("C:\\Users\\DELL\\Desktop\\清江浦区图层2\\qjpq_check_line.sql");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

//        for (String fileName : set) {
//            handle(path, fileName, "YS", bufferedWriter);
//            handle(path, fileName, "WS", bufferedWriter);
//        }

        handle(path, "新天地花苑", "YS", bufferedWriter);
        bufferedWriter.flush();
    }

    /**
     * 有些线有两个图层
     *
     * @param path
     * @param fileName
     * @param type
     * @return
     */
    private static List<QgisGeoDTO> getLineList(String path, String fileName, String type) {
        List<QgisGeoDTO> result = new ArrayList<>();
        List<QgisGeoDTO> lines1 = readTextFile(path + "\\" + fileName + "-" + type + "LINE.geojson");
        List<QgisGeoDTO> lines2 = readTextFile(path + "\\" + fileName + "-" + type + "LINE2.geojson");
        if (CollectionUtil.isNotEmpty(lines1)) {
            result.addAll(lines1);
        }
        if (CollectionUtil.isNotEmpty(lines2)) {
            result.addAll(lines2);
        }
        return result;
    }

    public static void generateSql(String path, String fileName, String type, BufferedWriter bufferedWriter) throws IOException {
        List<QgisGeoDTO> lines = getLineList(path, fileName, type);
        if (CollectionUtil.isEmpty(lines)) {
            return;
        }
        for (QgisGeoDTO line : lines) {
            QgisGeometry geometry = line.getGeometry();
            List<List<Double>> lineCoordinates = geometry.getLineCoordinates();
            if (lineCoordinates == null) {
                lineCoordinates = JSON.parseObject(geometry.getCoordinates(), new TypeReference<>() {
                });
                geometry.setLineCoordinates(lineCoordinates);
            }
            if (lineCoordinates.get(0).get(0) > 180 || lineCoordinates.get(1).get(0) > 180) {
                System.out.println(fileName);
                return;
            }
            String sql = "INSERT INTO qjpq_check_line ( `id`,`name`, `type`,`location`) VALUES ( UUID(),'" + fileName + "', '" + type + "',ST_GeomFromText('LINESTRING(" + lineCoordinates.get(0).get(0) + " " + lineCoordinates.get(0).get(1)
                    + ", " + lineCoordinates.get(1).get(0) + " " + lineCoordinates.get(1).get(1) + ")'));";
            bufferedWriter.write(sql);
            bufferedWriter.newLine();
        }
    }

    public static void handle(String path, String fileName, String type, BufferedWriter bufferedWriter) throws IOException {
        List<QgisGeoDTO> lines = getLineList(path, fileName, type);
        if (CollectionUtil.isEmpty(lines)) {
            return;
        }
        List<QgisGeoDTO> marks = readTextFile(path + "\\" + fileName + "-" + type + "MARK.geojson");
        List<QgisGeoDTO> texts = readTextFile(path + "\\" + fileName + "-" + type + "TEXT.geojson");

        for (QgisGeoDTO line : lines) {
            findMark(line, marks);
            findText(line, texts);

            List<List<Double>> lineCoordinates = line.getGeometry().getLineCoordinates();

            String sql = "INSERT INTO qjpq_check_line ( `id`,`name`, `type`,`location`,`text`,`startCode`,`endCode`) VALUES ( UUID(),'" + fileName + "', '" + type + "',ST_GeomFromText('LINESTRING(" + lineCoordinates.get(0).get(0) + " " + lineCoordinates.get(0).get(1)
                    + ", " + lineCoordinates.get(1).get(0) + " " + lineCoordinates.get(1).get(1) + ")')," + getSqlStr(line.getText()) + "," + getSqlStr(line.getStartCode()) + "," + getSqlStr(line.getEndCode()) + ");";
            bufferedWriter.write(sql);
            bufferedWriter.newLine();
        }
    }

    private static String getSqlStr(String s) {
        return s == null ? "null" : "'" + s + "'";
    }

    private static void findMark(QgisGeoDTO line, List<QgisGeoDTO> marks) {
        if (CollectionUtil.isEmpty(marks)) {
            return;
        }
        QgisGeometry geometry = line.getGeometry();
        List<List<Double>> lineCoordinates = geometry.getLineCoordinates();
        if (lineCoordinates == null) {
            lineCoordinates = JSON.parseObject(geometry.getCoordinates(), new TypeReference<>() {
            });
            geometry.setLineCoordinates(lineCoordinates);
        }
        for (QgisGeoDTO geoDTO : marks) {
            QgisGeometry innerGeometry = geoDTO.getGeometry();
            List<Double> pointCoordinates = innerGeometry.getPointCoordinates();
            if (pointCoordinates == null) {
                pointCoordinates = JSON.parseObject(innerGeometry.getCoordinates(), new TypeReference<>() {
                });
                innerGeometry.setPointCoordinates(pointCoordinates);
            }
            boolean perpendicularOnSegment = isPerpendicularOnSegment(pointCoordinates.get(0), pointCoordinates.get(1), lineCoordinates.get(0).get(0), lineCoordinates.get(0).get(1), lineCoordinates.get(1).get(0), lineCoordinates.get(1).get(1));
            if (!perpendicularOnSegment) {
                geoDTO.setDistance(100000000d);
                continue;
            }
            double distance = pointToLineSegmentDistance(pointCoordinates.get(0), pointCoordinates.get(1), lineCoordinates.get(0).get(0), lineCoordinates.get(0).get(1), lineCoordinates.get(1).get(0), lineCoordinates.get(1).get(1));
            geoDTO.setDistance(distance);
        }
        QgisGeoDTO match = marks.stream().filter(inner -> inner.getDistance() > 0.45 && inner.getDistance() < 0.55).findFirst().orElse(null);
        if (match != null) {
            String text = match.getProperties().getText();
            line.setText(text);
        }
    }


    private static void findText(QgisGeoDTO line, List<QgisGeoDTO> texts) {
        if (CollectionUtil.isEmpty(texts)) {
            return;
        }
        QgisGeometry geometry = line.getGeometry();
        List<List<Double>> lineCoordinates = geometry.getLineCoordinates();
        if (lineCoordinates == null) {
            lineCoordinates = JSON.parseObject(geometry.getCoordinates(), new TypeReference<>() {
            });
            geometry.setLineCoordinates(lineCoordinates);
        }
        for (QgisGeoDTO geoDTO : texts) {
            QgisGeometry innerGeometry = geoDTO.getGeometry();
            List<Double> pointCoordinates = innerGeometry.getPointCoordinates();
            if (pointCoordinates == null) {
                pointCoordinates = JSON.parseObject(innerGeometry.getCoordinates(), new TypeReference<>() {
                });
                innerGeometry.setPointCoordinates(pointCoordinates);
            }
            double startDistance = DistanceUtil.getDistance(pointCoordinates.get(0), pointCoordinates.get(1), lineCoordinates.get(0).get(0), lineCoordinates.get(0).get(1));
            double endDistance = DistanceUtil.getDistance(pointCoordinates.get(0), pointCoordinates.get(1), lineCoordinates.get(1).get(0), lineCoordinates.get(1).get(1));
            geoDTO.setStartDistance(startDistance);
            geoDTO.setEndDistance(endDistance);
        }
        QgisGeoDTO start = texts.stream().filter(inner -> (inner.getProperties().getText().startsWith("YS") || inner.getProperties().getText().startsWith("WS")) && inner.getStartDistance() > 0.145 && inner.getStartDistance() < 0.155).findFirst().orElse(null);
        QgisGeoDTO end = texts.stream().filter(inner -> (inner.getProperties().getText().startsWith("YS") || inner.getProperties().getText().startsWith("WS")) && inner.getEndDistance() > 0.145 && inner.getEndDistance() < 0.155).findFirst().orElse(null);
        if (start != null) {
            line.setStartCode(start.getProperties().getText());
        }
        if (end != null) {
            line.setEndCode(end.getProperties().getText());
        }
    }

    private static List<QgisGeoDTO> readTextFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            // 逐行读取文件内容
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }
        if (StringUtils.isEmpty(content.toString())) {
            return null;
        }
        String features = JSON.parseObject(content.toString()).getString("features");

        List<QgisGeoDTO> list = JSON.parseObject(features, new TypeReference<>() {
        });

        return list;
    }


    /**
     * 判断点到线段的垂直线是否在线段上
     *
     * @param x  点的经度
     * @param y  点的纬度
     * @param x1 线段起点的经度
     * @param y1 线段起点的纬度
     * @param x2 线段终点的经度
     * @param y2 线段终点的纬度
     * @return
     */
    private static boolean isPerpendicularOnSegment(double x, double y, double x1, double y1, double x2, double y2) {
        // 计算线段向量
        double dx = x2 - x1;
        double dy = y2 - y1;
        // 如果线段是一个点，不存在垂直线在线段上的情况
        if (dx == 0 && dy == 0) {
            return false;
        }
        // 计算点 p 到线段起点 p1 的向量
        double px = x - x1;
        double py = y - y1;
        // 计算投影比例
        double dotProduct = px * dx + py * dy;
        double lengthSquared = dx * dx + dy * dy;
        double projectionRatio = dotProduct / lengthSquared;
        // 判断垂足是否在线段上
        return projectionRatio >= 0 && projectionRatio <= 1;
    }

    private static final double EARTH_RADIUS = 6371000; // 地球半径，单位：米

    // 将经纬度转换为三维向量
    private static Vector3D toVector(double lat, double lon) {
        double radLat = Math.toRadians(lat);
        double radLon = Math.toRadians(lon);
        double x = Math.cos(radLat) * Math.cos(radLon);
        double y = Math.cos(radLat) * Math.sin(radLon);
        double z = Math.sin(radLat);
        return new Vector3D(x, y, z);
    }

    // 使用 Haversine 公式计算两点间的球面距离
    private static double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }

    // 计算点到线段的垂直距离
    public static double pointToLineSegmentDistance(double pointLon, double pointLat,
                                                    double startLon, double startLat,
                                                    double endLon, double endLat) {
        Vector3D point = toVector(pointLat, pointLon);
        Vector3D start = toVector(startLat, startLon);
        Vector3D end = toVector(endLat, endLon);
        Vector3D lineVector = end.subtract(start);
        Vector3D pointVector = point.subtract(start);
        // 计算投影比例
        double dotProduct = pointVector.dotProduct(lineVector);
        double lineLengthSquared = lineVector.getNormSq();
        double projectionRatio = dotProduct / lineLengthSquared;
        if (projectionRatio < 0) {
            return haversineDistance(pointLat, pointLon, startLat, startLon);
        } else if (projectionRatio > 1) {
            return haversineDistance(pointLat, pointLon, endLat, endLon);
        } else {
            // 计算垂足向量
            Vector3D projectionVector = start.add(lineVector.scalarMultiply(projectionRatio));
            // 计算垂足的经纬度
            double projectionLat = Math.toDegrees(Math.asin(projectionVector.getZ()));
            double projectionLon = Math.toDegrees(Math.atan2(projectionVector.getY(), projectionVector.getX()));
            return haversineDistance(pointLat, pointLon, projectionLat, projectionLon);
        }
    }
}