package com.mjl.word;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordUtil {


    public static void main(String[] args) throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("projectName", "20251119");
        data.put("year", "2025");
        data.put("month", "11");
        data.put("photo1", "C:\\Users\\DELL\\Desktop\\word占位模板\\1.jpeg");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\DELL\\Desktop\\word占位模板\\巡检记录台账统计.docx");
        exportWithPOI(data, "巡检记录台账统计模板.docx", fileOutputStream);
        fileOutputStream.close();
        System.out.println("生成成功");
    }

    public static void exportWithPOI(Map<String, Object> data, String templatePath, OutputStream outputStream)
            throws Exception {

        ClassPathResource resource = new ClassPathResource(templatePath);
        Assert.isTrue(resource.exists(), "模版不存在");
        InputStream fis = resource.getInputStream();
        XWPFDocument doc = new XWPFDocument(fis);
        // 1. 处理文档主体内容
        processParagraphs(doc.getParagraphs(), data);

        // 2. 处理表格内容
        for (XWPFTable table : doc.getTables()) {
            processTable(table, data);
        }

        // 3. 处理页眉
        for (XWPFHeader header : doc.getHeaderList()) {
            processParagraphs(header.getParagraphs(), data);
        }

        // 4. 处理页脚
        for (XWPFFooter footer : doc.getFooterList()) {
            processParagraphs(footer.getParagraphs(), data);
        }

        doc.write(outputStream);
        outputStream.flush();
    }

    /**
     * 处理段落中的占位符
     */
    private static void processParagraphs(List<XWPFParagraph> paragraphs, Map<String, Object> data) throws Exception {
        for (XWPFParagraph paragraph : paragraphs) {
            replaceTextInParagraph(paragraph, data);
        }
    }

    /**
     * 处理表格中的占位符
     */
    private static void processTable(XWPFTable table, Map<String, Object> data) throws Exception {
        for (XWPFTableRow row : table.getRows()) {
            for (XWPFTableCell cell : row.getTableCells()) {
                for (XWPFParagraph paragraph : cell.getParagraphs()) {
                    replaceTextInParagraph(paragraph, data);
                }
            }
        }
    }

    /**
     * 替换段落中的占位符
     */
    private static void replaceTextInParagraph(XWPFParagraph paragraph, Map<String, Object> data) throws Exception {
        // 获取整个段落的文本
        String paragraphText = getParagraphText(paragraph);

        // 使用正则表达式查找所有占位符
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(paragraphText);

        // 如果段落中没有占位符，直接返回
        if (!matcher.find()) return;

        // 重置匹配器
        matcher.reset();

        // 创建一个新的文本替换器
        TextReplacer replacer = new TextReplacer(paragraph);

        // 遍历所有匹配的占位符
        while (matcher.find()) {
            String placeholder = matcher.group(0);  // 完整占位符 ${key}
            String key = matcher.group(1);          // 占位符中的键 key

            if (!key.startsWith("photo")) {
                // 获取值（如果不存在则使用空字符串）
                String value = data.containsKey(key) ? (data.get(key) == null ? "" : data.get(key).toString()) : "";
                // 替换占位符
                replacer.replaceText(placeholder, value);
            } else {
                // 处理图片占位符
                String photoPath = (String) data.get(key);
                replacer.replaceText(placeholder, "");

                if (photoPath != null) {
                    XWPFRun run = paragraph.createRun();
                    run.addPicture(new FileInputStream(photoPath), XWPFDocument.PICTURE_TYPE_PNG, photoPath, Units.toEMU(100), Units.toEMU(100));
                }
            }
        }

        // 应用所有替换
        replacer.applyReplacements();
    }

    /**
     * 获取段落的完整文本
     */
    private static String getParagraphText(XWPFParagraph paragraph) {
        StringBuilder text = new StringBuilder();
        for (XWPFRun run : paragraph.getRuns()) {
            String runText = run.getText(0);
            if (runText != null) {
                text.append(runText);
            }
        }
        return text.toString();
    }

    /**
     * 内部类：用于处理文本替换并保留格式
     */
    private static class TextReplacer {
        private final XWPFParagraph paragraph;
        private String currentText;
        private int position = 0;

        public TextReplacer(XWPFParagraph paragraph) {
            this.paragraph = paragraph;
            this.currentText = getParagraphText(paragraph);
        }

        /**
         * 替换文本（在内存中操作，不立即应用到文档）
         */
        public void replaceText(String target, String replacement) {
            int start = currentText.indexOf(target, position);
            if (start == -1) return;

            int end = start + target.length();
            currentText = currentText.substring(0, start) + replacement + currentText.substring(end);

            // 更新位置
            position = start + replacement.length();
        }

        /**
         * 应用所有替换到文档
         */
        public void applyReplacements() {
            // 清空原有内容
            for (XWPFRun run : paragraph.getRuns()) {
                run.setText("", 0);
            }

            // 添加新内容（保留第一个run的格式）
            if (!paragraph.getRuns().isEmpty()) {
                XWPFRun firstRun = paragraph.getRuns().get(0);
                firstRun.setText(currentText, 0);
            } else {
                // 如果段落中没有run，创建一个新的
                XWPFRun newRun = paragraph.createRun();
                newRun.setText(currentText);
            }
        }
    }

}
