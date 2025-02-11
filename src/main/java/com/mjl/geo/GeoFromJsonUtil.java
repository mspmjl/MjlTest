package com.mjl.geo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mjl.DistanceUtil;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
public class GeoFromJsonUtil {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\DELL\\Desktop\\清江浦区图层2\\geojson";
        Path directory = Paths.get(path);

        List<String> fileNames = new ArrayList<>();
        // 递归遍历所有子目录和文件
        Files.walk(directory)
                .filter(Files::isRegularFile)
                .forEach(p -> fileNames.add(p.getFileName().toString()));

        Set<String> set = fileNames.stream().map(s -> s.split("-")[0]).collect(Collectors.toSet());

        for (String fileName : set) {
            handle(path, fileName, "YS");
        }
    }

    public static void handle(String path, String fileName, String type) throws IOException {
        List<GeoDTO> lines = readTextFile(path + "\\" + fileName + "-" + type + "LINE.geojson");
        List<GeoDTO> marks = readTextFile(path + "\\" + fileName + "-" + type + "MARK.geojson");
        List<GeoDTO> texts = readTextFile(path + "\\" + fileName + "-" + type + "TEXT.geojson");

        for (GeoDTO line : lines) {
            findMark(line, marks);
            findText(line, texts);
        }
    }

    private static void findMark(GeoDTO line, List<GeoDTO> marks) {
        Geometry geometry = line.getGeometry();
        List<List<Double>> lineCoordinates = geometry.getLineCoordinates();
        if (lineCoordinates == null) {
            lineCoordinates = JSON.parseObject(geometry.getCoordinates(), new TypeReference<>() {
            });
            geometry.setLineCoordinates(lineCoordinates);
        }
        for (GeoDTO geoDTO : marks) {
            Geometry innerGeometry = geoDTO.getGeometry();
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
        GeoDTO match = marks.stream().filter(inner -> inner.getDistance() > 0.45 && inner.getStartDistance() < 0.55).findFirst().orElse(null);
        if (match != null) {
            String text = match.getProperties().getText();

        }
    }

    private static void findText(GeoDTO line, List<GeoDTO> texts) {
        Geometry geometry = line.getGeometry();
        List<List<Double>> lineCoordinates = geometry.getLineCoordinates();
        if (lineCoordinates == null) {
            lineCoordinates = JSON.parseObject(geometry.getCoordinates(), new TypeReference<>() {
            });
            geometry.setLineCoordinates(lineCoordinates);
        }
        for (GeoDTO geoDTO : texts) {
            Geometry innerGeometry = geoDTO.getGeometry();
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
        GeoDTO start = texts.stream().filter(inner -> inner.getStartDistance() > 0.145 && inner.getStartDistance() < 0.155).findFirst().orElse(null);
        GeoDTO end = texts.stream().filter(inner -> inner.getEndDistance() > 0.145 && inner.getEndDistance() < 0.155).findFirst().orElse(null);
        if (start != null) {
            line.setStartCode(start.getProperties().getText());
        }
        if (end != null) {
            line.setEndCode(end.getProperties().getText());
        }
    }

    private static List<GeoDTO> readTextFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 逐行读取文件内容
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (StringUtils.isEmpty(content.toString())) {
            return null;
        }
        String features = JSON.parseObject(content.toString()).getString("features");

        List<GeoDTO> list = JSON.parseObject(features, new TypeReference<>() {
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