package com.mjl;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author MJL
 * @date 2021/9/26.
 */
public class Excel {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        XSSFWorkbook xb = new XSSFWorkbook();
        XSSFSheet sheetAt = xb.getSheetAt(0);
        XSSFWorkbook excel = new XSSFWorkbook();
        excel.createSheet("mjl");
        XSSFSheet newS = excel.getSheetAt(0);
        String ip = null;
        int index = 0;
        for (int i = 2; i < 76; i++) {
            XSSFRow row = sheetAt.getRow(i);
            ip = StringUtils.isEmpty(row.getCell(2).getStringCellValue()) ? ip : row.getCell(2).getStringCellValue().substring(5);
            String path = row.getCell(5).getStringCellValue();
            String port = (row.getCell(4).getNumericCellValue() + "");
            port = port.substring(0, port.length() - 2);
            XSSFRow createRow = newS.createRow(index);
            // 标题
            createRow.createCell(0).setCellValue(row.getCell(3).getStringCellValue());
            // 具体信息
            index++;
            XSSFRow createRow1 = newS.createRow(index);
            createRow1.createCell(0).setCellValue("部署服务器IP");
            createRow1.createCell(1).setCellValue(ip);
            index++;
            XSSFRow createRow2 = newS.createRow(index);
            createRow2.createCell(0).setCellValue("业务端口");
            createRow2.createCell(1).setCellValue(port);
            index++;
            XSSFRow createRow3 = newS.createRow(index);
            createRow3.createCell(0).setCellValue("部署目录");
            createRow3.createCell(1).setCellValue(path);
            index++;
            XSSFRow createRow4 = newS.createRow(index);
            createRow4.createCell(0).setCellValue("配置文件");
            createRow4.createCell(1).setCellValue(path + "/application-prod.yml");
            index++;
            XSSFRow createRow5 = newS.createRow(index);
            createRow5.createCell(0).setCellValue("启动脚本");
            createRow5.createCell(1).setCellValue(path + "/manage.sh");
            index++;
            XSSFRow createRow6 = newS.createRow(index);
            createRow6.createCell(0).setCellValue("程序文件");
            createRow6.createCell(1).setCellValue(path + "/");
            index++;
            XSSFRow createRow7 = newS.createRow(index);
            createRow7.createCell(0).setCellValue("日志目录");
            createRow7.createCell(1).setCellValue(path + "/logs");
            index++;

        }
        excel.write(new FileOutputStream("C:\\Users\\DELL\\Desktop\\mjl.xlsx"));
    }
}
