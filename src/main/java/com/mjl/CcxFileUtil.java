package com.mjl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author MJL
 * @date 2023/8/14.
 */
public class CcxFileUtil {
    public static void main(String[] args) throws IOException {
        String modalName = "KbFillData";
        String tableName = "yxhw_kb_fill_data";
        boolean splitTable = false;
        boolean longId = true;
        writeModal(splitTable, longId, modalName, tableName);
        writeDTO(splitTable, longId, modalName);
        writeMapper(modalName);
        writeService(splitTable, longId, modalName);
        writeServiceImpl(splitTable, longId, modalName);
        writeCriteria(modalName, longId);
    }

    public static void writeModal(boolean splitTable, boolean longId, String modalName, String tableName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\ccxdto\\" + modalName + ".java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("import javax.persistence.Table;");
        bufferedWriter.newLine();
        bufferedWriter.write("@NameStyle(Style.normal)");
        bufferedWriter.newLine();
        bufferedWriter.write("@Table(name = \"" + tableName + "\",indexes = {})");
        bufferedWriter.newLine();
        String ext = "";
        if (splitTable) {
            ext = "BaseTenantSubTableModel";
        } else if (longId) {
            ext = "BaseTenantLongKeyModel";
        } else {
            ext = "BaseTenantModel";
        }
        bufferedWriter.write("public class  " + modalName + "  extends " + ext + " {");
        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeDTO(boolean splitTable, boolean longId, String modalName) throws IOException {
        String ext = "";
        if (splitTable) {
            ext = "BaseSubDTO<String>";
        } else if (longId) {
            ext = "BaseDTO<Long>";
        } else {
            ext = "BaseDTO<String>";
        }
        File txt = new File("C:\\Users\\DELL\\Desktop\\ccxdto\\" + modalName + "DTO.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("public class  " + modalName + "DTO  extends " + ext + " {");
        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeMapper(String modalName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\ccxdto\\" + modalName + "Mapper.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("public interface  " + modalName + "Mapper  extends TkBaseMapper<" + modalName + ">{");
        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeService(boolean splitTable, boolean longId, String modalName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\ccxdto\\I" + modalName + "Service.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String ext = "";
        if (splitTable) {
            ext = "ITkBaseSubService";
        } else {
            ext = "ITkBaseService";
        }
        String type = longId ? "Long" : "String";

        bufferedWriter.write("public interface  I" + modalName + "Service  extends " + ext + "<" + modalName + ", " + modalName + "DTO, " + type + "> {");
        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeServiceImpl(boolean splitTable, boolean longId, String modalName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\ccxdto\\" + modalName + "ServiceImpl.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String ext = "";
        if (splitTable) {
            ext = "AbstractTkBaseSubServiceImpl";
        } else {
            ext = "AbstractTkBaseServiceImpl";
        }
        String type = longId ? "Long" : "String";
        bufferedWriter.write("import org.springframework.transaction.annotation.Transactional;");
        bufferedWriter.newLine();
        bufferedWriter.write("@Service");
        bufferedWriter.newLine();
        bufferedWriter.write("@Transactional(rollbackFor = Exception.class)");
        bufferedWriter.newLine();
        bufferedWriter.write("public class  " + modalName + "ServiceImpl  extends " + ext + "<" + modalName + "Mapper, " + modalName + ", " + modalName + "DTO, " + type + "> implements I" + modalName + "Service {");
        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeCriteria(String modalName, boolean longId) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\ccxdto\\" + modalName + "Criteria.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String type = longId ? "Long" : "String";

        bufferedWriter.write("public class  " + modalName + "Criteria  extends BaseCriteria<" + type + ">{");
        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }
}
