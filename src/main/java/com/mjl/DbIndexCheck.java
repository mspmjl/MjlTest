package com.mjl;

import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;

/**
 * @author MJL
 * @date 2021/12/9.
 */
public class DbIndexCheck {
    public static void main(String[] args) throws Exception {
        // 模板数据库
        String path = "D:\\阿里云数据库index\\阿里云数据库索引";
        // 需要对比的数据库
        String comparePath = "D:\\惠泰数据库index\\惠泰数据库索引";
        String targetPath = "D:\\aaa-result.sql";
        File targetFile = new File(targetPath);
        // key 是 表名
        // value 是 一个KV集合
        // key : `deviceCode`,`batteryTime` value : ALTER TABLE `zyry_battery_history` ADD UNIQUE INDEX `idx_deviceCode_batteryTime` (`deviceCode`,`batteryTime`);
        Map<String, Map<String, String>> map = getIndexMap(path);
        Map<String, Map<String, String>> compareMap = getIndexMap(comparePath);
        List<String> sqls = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
            String table = entry.getKey();
            Map<String, String> value = entry.getValue();
            Map<String, String> compareValue = compareMap.get(table);
            if (CollectionUtils.isEmpty(compareValue)) {
                //  空的说明索引全部没有 或者没有表
                sqls.addAll(value.values());
                continue;
            }
            // 对比 两个集合 得到漏掉的索引sql
            for (Map.Entry<String, String> stringEntry : value.entrySet()) {
                String columns = stringEntry.getKey();
                if (compareValue.containsKey(columns)) {
                    // 包含说明已经存在索引了 去掉 最后剩下的就是漏了的
                    continue;
                }
                sqls.add(stringEntry.getValue());
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));
        for (String sql : sqls) {
            System.out.println(sql);
            writer.write(sql);
            writer.newLine();
        }
        writer.close();
    }

    static Map<String, Map<String, String>> getIndexMap(String path) throws Exception {
        Map<String, Map<String, String>> map = new LinkedHashMap<>();
        File sqlPath = new File(path);
        File[] files = sqlPath.listFiles();
        for (File f : files) {
            String fileName = f.getName();
            File file = new File(path + "\\" + fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s;
            while ((s = reader.readLine()) != null) {
                s = s.trim();
                String[] split = s.split("`");
                if (split == null || split.length < 2) {
                    continue;
                }
                String table = s.split("`")[1];
                String columns = s.split("\\(")[1].split("\\)")[0];
                Map<String, String> columnAndSql = map.get(table);
                if (CollectionUtils.isEmpty(columnAndSql)) {
                    columnAndSql = new HashMap<>();
                    map.put(table, columnAndSql);
                }
                columnAndSql.put(columns, s);
            }
            reader.close();
        }
        return map;
    }

    static Map<String, String> getDbMap(String path) throws Exception {
        Map<String, String> map = new HashMap<>();
        File sqlPath = new File(path);
        File[] files = sqlPath.listFiles();
        for (File f : files) {
            String fileName = f.getName();
            System.out.println(fileName);
            File file = new File(path + "\\" + fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s;
            while ((s = reader.readLine()) != null) {
                s = s.trim();
                String table = s.split("`")[1];
                map.put(table, fileName.split("\\.")[0]);
            }
        }
        return map;
    }
}
