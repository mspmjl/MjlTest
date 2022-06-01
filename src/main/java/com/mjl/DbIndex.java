package com.mjl;

import org.springframework.util.StringUtils;

import java.io.*;

/**
 * @author MJL
 * @date 2021/12/8.
 */
public class DbIndex {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\DELL\\Desktop\\阿里云数据库index";
        String targetPath = "C:\\Users\\DELL\\Desktop\\数据库索引2";
        File sqlPath = new File(path);
        File[] files = sqlPath.listFiles();
        for (File f : files) {
            String fileName = f.getName();
            System.out.println(fileName);
            String targetFileName = fileName.split("\\.")[0] + ".sql";
            File file = new File(path + "\\" + fileName);
            File targetFile = new File(targetPath + "\\" + targetFileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));

            String s;
            String table = null;
            while ((s = reader.readLine()) != null) {
                s = s.trim();
                if (s.contains("CREATE TABLE")) {
                    // 获取表名
                    table = s.split("`")[1];
                }
                boolean isIndex = s.startsWith("INDEX") || s.startsWith("KEY") || s.startsWith("UNIQUE INDEX") || s.startsWith("UNIQUE KEY");
                if (!isIndex) {
                    continue;
                }
                // 排除分表和copy表
                String alterSql = null;
                if (table != null && !(table.contains("20") || table.contains("copy"))) {
                    String columns = s.split("\\(")[1].split("\\)")[0];
                    if ( s.startsWith("UNIQUE INDEX") || s.startsWith("UNIQUE KEY")) {
                        alterSql = getAlterString(table, "UNIQUE INDEX", columns);
                    } else {
                        alterSql = getAlterString(table, "INDEX", columns);
                    }
                }
                if (!StringUtils.isEmpty(alterSql)) {
                    System.out.println(alterSql);
                    writer.write(alterSql);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
        }
    }

    static String getAlterString(String table, String index, String column) {
        String[] split = column.split(",");
        String idxName = "idx";
        for (String s : split) {
            s = s.replace(" ", "");
            idxName += "_" + s.replace("`", "");
        }
        return "ALTER TABLE `" + table + "` ADD " + index + " `" + idxName + "` (" + column + ");";
    }
}
