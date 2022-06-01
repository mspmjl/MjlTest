package com.mjl.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MJL
 * @date 2022/6/1.
 */
public class ExcelUtil<T> {


    Class<T> clazz;

    public ExcelUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    public static void main(String[] args) throws IOException {
        ExcelUtil util = new ExcelUtil(YhtDTO.class);
        List<YhtDTO> list = util.importExcel(new File("C:\\Users\\DELL\\Desktop\\副本玉禾田需要删除的角色清单.xlsx"), YhtDTO.class, "", 2);
        for (YhtDTO yhtDTO : list) {

        }
    }

    public <T> List<T> importExcel(File file, Class<T> clazz, String sheetName, Integer skipRow) throws IOException {
        List<T> list;
        InputStream is = new FileInputStream(file);
        String filename = file.getName();
        if (!StringUtils.isEmpty(filename) && filename.endsWith(".xlsx")) {
            ExcelUtil<T> util = new ExcelUtil<>(clazz);
            list = util.importExcel(sheetName, skipRow, is);
        } else {
            ExcelUtil<T> util = new ExcelUtil<>(clazz);
            list = util.importExcel(sheetName, skipRow, is);
        }
        if (is != null) {
            is.close();
        }
        return list;
    }

    public List<T> importExcel(String sheetName, int skipRow, InputStream input) {
        int maxCol = 0;
        List<T> list = new ArrayList<T>();
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(input);
            XSSFSheet sheet = null;
            if (!StringUtils.isEmpty(sheetName)) {
                sheet = workbook.getSheet(sheetName);
            }
            if (sheet == null) {
                sheet = workbook.getSheetAt(0);
            }
            int rows = sheet.getPhysicalNumberOfRows();

            if (rows > 0) {
                List<Field> allFields = getMappedFiled(clazz, null);

                Map<Integer, Field> fieldsMap = new HashMap<Integer, Field>();
                for (Field field : allFields) {
                    if (field.isAnnotationPresent(ExcelAttribute.class)) {
                        ExcelAttribute attr = field.getAnnotation(ExcelAttribute.class);
                        int col = getExcelCol(attr.column());
                        maxCol = Math.max(col, maxCol);
                        field.setAccessible(true);
                        fieldsMap.put(col, field);
                    }
                }
                for (int i = skipRow; i < rows; i++) {
                    XSSFRow row = sheet.getRow(i);
                    // int cellNum = row.getPhysicalNumberOfCells();
                    // int cellNum = row.getLastCellNum();
                    int cellNum = maxCol;
                    T entity = null;
                    for (int j = 0; j <= cellNum; j++) {
                        XSSFCell cell = row.getCell(j);
                        if (cell == null) {
                            continue;
                        }
                        int cellType = cell.getCellType();
                        String c = "";
                        if (cellType != XSSFCell.CELL_TYPE_STRING) {
                            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                        }
                        c = cell.getStringCellValue();
                        if (c == null || c.equals("")) {
                            continue;
                        }
                        entity = entity == null ? clazz.newInstance() : entity;
                        Field field = (Field) fieldsMap.get(j);
                        if (field == null) {
                            continue;
                        }
                        Class<?> fieldType = field.getType();
                        if (String.class == fieldType) {
                            field.set(entity, String.valueOf(c));
                        } else if (Integer.TYPE == fieldType || Integer.class == fieldType) {
                            field.set(entity, Integer.parseInt(c));
                        } else if (Long.TYPE == fieldType || Long.class == fieldType) {
                            field.set(entity, Long.valueOf(c));
                        } else if (Float.TYPE == fieldType || Float.class == fieldType) {
                            field.set(entity, Float.valueOf(c));
                        } else if (Short.TYPE == fieldType || Short.class == fieldType) {
                            field.set(entity, Short.valueOf(c));
                        } else if (Double.TYPE == fieldType || Double.class == fieldType) {
                            field.set(entity, Double.valueOf(c));
                        } else if (Character.TYPE == fieldType) {
                            if (c != null && c.length() > 0) {
                                field.set(entity, Character.valueOf(c.charAt(0)));
                            }
                        }

                    }
                    if (entity != null) {
                        list.add(entity);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static int getExcelCol(String col) {
        col = col.toUpperCase();
        int count = -1;
        char[] cs = col.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
        }
        return count;
    }

    private List<Field> getMappedFiled(Class clazz, List<Field> fields) {
        if (fields == null) {
            fields = new ArrayList<Field>();
        }
        Field[] allFields = clazz.getDeclaredFields();
        for (Field field : allFields) {
            if (field.isAnnotationPresent(ExcelAttribute.class)) {
                fields.add(field);
            }
        }
        if (clazz.getSuperclass() != null && !clazz.getSuperclass().equals(Object.class)) {
            getMappedFiled(clazz.getSuperclass(), fields);
        }

        return fields;
    }
}
