package com.mjl;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author MJL
 * @date 2022/2/25.
 */
public class ZhjSlowSql {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File("E:\\下载\\slowlog.202203090005")));
        String s;
        String sql = "";
        String queryTime = null;
        Integer rowsSent = null;
        Integer rowsExamined = null;
        String db = null;
        LinkedHashMap<String, SqlDTO> map = new LinkedHashMap<>();
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
            if (s.startsWith("# Time")) {
                if (!StringUtils.isEmpty(sql)) {

                    int where = sql.indexOf("where");
                    int WHERE = sql.indexOf("WHERE");
                    if (!(where == -1 && WHERE == -1)) {
                        String key = sql.substring(0, where == -1 ? WHERE : where);
                        SqlDTO sqlDTO = map.get(key);
                        if (sqlDTO == null) {
                            SqlDTO dto = new SqlDTO();
                            dto.setDb(db);
                            dto.setSql(sql);
                            dto.setQueryTime(new BigDecimal(queryTime));
                            dto.setTotal(1);
                            dto.setRowsExamined(rowsExamined);
                            dto.setRowsSent(rowsSent);
                            map.put(key, dto);
                        } else {
                            int total = sqlDTO.getTotal();
                            BigDecimal queryTime1 = sqlDTO.getQueryTime();
                            sqlDTO.setQueryTime(queryTime1.add(new BigDecimal(queryTime)));
                            total++;
                            sqlDTO.setTotal(total);
                            Integer rowsSent1 = sqlDTO.getRowsSent();
                            Integer rowsExamined1 = sqlDTO.getRowsExamined();
                            sqlDTO.setRowsSent(rowsSent1 + rowsSent);
                            sqlDTO.setRowsExamined(rowsExamined1 + rowsExamined);
                        }
                    }
                    sql = "";
                }
                continue;
            }
            if (s.startsWith("# User@Host") || s.startsWith("SET timestam")) {
                continue;
            }
            if (s.startsWith("# Query_time")) {
                queryTime = s.substring(14, 22);
                int rows_sent = s.indexOf("Rows_sent");
                int rows_examined = s.indexOf("Rows_examined");
                String substring = s.substring(rows_sent + 11, rows_examined);
                String substring2 = s.substring(rows_examined + 15);
                rowsSent = Integer.parseInt(substring.trim());
                rowsExamined = Integer.parseInt(substring2.trim());
            } else if (s.startsWith("use")) {
                db = s.replace("use ", "").replace(";", "");
            } else {
                sql += s;
            }
        }
        XSSFWorkbook excel = new XSSFWorkbook();
        excel.createSheet("mjl");
        XSSFSheet newS = excel.getSheetAt(0);
        int index = 0;
        for (Entry<String, SqlDTO> entry : map.entrySet()) {
            SqlDTO value = entry.getValue();
            String key = entry.getKey();
            XSSFRow createRow = newS.createRow(index);
            createRow.createCell(0).setCellValue(value.getDb());
            if (key.length() >= 32767) {
                createRow.createCell(1).setCellValue(key.substring(0, 32766));
            } else {
                createRow.createCell(1).setCellValue(key);
            }
            String sql1 = value.getSql();
            if (sql1.length() >= 32767) {
                createRow.createCell(2).setCellValue(sql1.substring(0, 32766));
            } else {
                createRow.createCell(2).setCellValue(value.getSql());
            }
            BigDecimal divide = value.getQueryTime().divide(new BigDecimal(value.getTotal()), 2);
            createRow.createCell(3).setCellValue(divide.doubleValue());
            createRow.createCell(4).setCellValue(value.getTotal());
            Integer rowsSent1 = value.getRowsSent();
            createRow.createCell(5).setCellValue(new BigDecimal(rowsSent1).divide(new BigDecimal(value.getTotal()), 2).doubleValue());
            new BigDecimal(rowsSent1).divide(new BigDecimal(value.getTotal()), 2);
            Integer rowsExamined1 = value.getRowsExamined();
            createRow.createCell(6).setCellValue(new BigDecimal(rowsExamined1).divide(new BigDecimal(value.getTotal()), 2).doubleValue());
            index++;
        }
        excel.write(new FileOutputStream("C:\\Users\\DELL\\Desktop\\showSql6.xlsx"));
    }

    public static Entry<String, SqlDTO> getTailByReflection(LinkedHashMap<String, SqlDTO> map) throws Exception {
        Field tail = map.getClass().getDeclaredField("tail");
        tail.setAccessible(true);
        return (Entry<String, SqlDTO>) tail.get(map);
    }
}

class SqlDTO {
    private String sql;
    private BigDecimal queryTime = BigDecimal.ZERO;
    private String db;
    private int total;
    private Integer rowsSent;
    private Integer rowsExamined;


    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public BigDecimal getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(BigDecimal queryTime) {
        this.queryTime = queryTime;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Integer getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(Integer rowsSent) {
        this.rowsSent = rowsSent;
    }

    public Integer getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Integer rowsExamined) {
        this.rowsExamined = rowsExamined;
    }
}

