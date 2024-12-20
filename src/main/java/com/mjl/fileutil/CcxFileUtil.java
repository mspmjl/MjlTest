package com.mjl.fileutil;

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
        String modalName = "CoreReport";
        String chineseName = "收运核心指标一张表";
        String tableName = "ljsy_core_report";
        boolean splitTable = false;
        boolean longId = true;
        writeModal(splitTable, longId, modalName, tableName);
        writeDTO(splitTable, longId, modalName);
        writeMapper(modalName);
        writeService(splitTable, longId, modalName);
        writeServiceImpl(splitTable, longId, modalName);
        writeCriteria(modalName, longId);

        writeController(modalName, chineseName);
    }

    public static void writeController(String modalName, String chineseName) throws IOException {

        File txt = new File("C:\\Users\\DELL\\Desktop\\ccxdto\\" + modalName + "Controller.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("import org.springframework.util.Assert;");
        bufferedWriter.newLine();
        bufferedWriter.write("import com.vortex.cloud.ccx.util.CollectionUtil;");
        bufferedWriter.newLine();
        bufferedWriter.write("import org.springframework.beans.BeanUtils;");
        bufferedWriter.newLine();
        bufferedWriter.write("import java.net.URLEncoder;");
        bufferedWriter.newLine();
        bufferedWriter.write("import com.vortex.cloud.ccx.util.StringUtil;");
        bufferedWriter.newLine();

        char firstChar = modalName.charAt(0);
        char updatedFirstChar = Character.toLowerCase(firstChar);
        String remainder = modalName.substring(1);
        String tag = updatedFirstChar + remainder;

        bufferedWriter.write("@Api(value = \"" + chineseName + "\", tags = \"" + chineseName + "\")\n" +
                "@CcxRestController(value = Constants.WEB_URL_PRE + \"/" + tag + "\")\n" +
                "public class " + modalName + "Controller {\n" +
                "\n" +
                "    @Resource\n" +
                "    private I" + modalName + "Service service;\n" +
                "    @Resource\n" +
                "    private IFileService fileService;\n" +
                "\n" +
                "    @ApiOperation(\"分页查询\")\n" +
                "    @RequestMapping(\"page\")\n" +
                "    public RestResultDto<DataStore<" + modalName + "DTO>> page(@RequestBody " + modalName + "Criteria criteria) {\n" +
                "        return RestResultDto.newSuccess(service.page(criteria));\n" +
                "    }\n" +
                "\n" +
                "    @ApiOperation(\"列表\")\n" +
                "    @RequestMapping(\"list\")\n" +
                "    public RestResultDto<List<" + modalName + "DTO>> list(@RequestBody " + modalName + "Criteria criteria) {\n" +
                "        return RestResultDto.newSuccess(service.list(criteria));\n" +
                "    }\n" +
                "    @ApiOperation(\"新增\")\n" +
                "    @RequestMapping(\"insert\")\n" +
                "    public RestResultDto create(@RequestBody @Valid " + modalName + "DTO dto) {\n" +
                "        service.insert(dto);\n" +
                "        return RestResultDto.newSuccess();\n" +
                "    }\n" +
                "\n" + "    @ApiOperation(\"修改\")\n" +
                "    @RequestMapping(\"update\")\n" +
                "    public RestResultDto update(@RequestBody @Valid " + modalName + "DTO dto) {\n" +
                "        service.update(dto);\n" +
                "        return RestResultDto.newSuccess();\n" +
                "    }\n" +
                "    @ApiOperation(\"删除\")\n" +
                "    @RequestMapping(\"delete\")\n" +
                "    public RestResultDto delete(@RequestBody " + modalName + "Criteria criteria) {\n" +
                "        Assert.notEmpty(criteria.getIdList(), \"idList不能为空\");\n" +
                "        service.deleteLogical(criteria);\n" +
                "        return RestResultDto.newSuccess();\n" +
                "    }\n" +
                "\n" +
                "    @ApiOperation(\"根据id获取\")\n" +
                "    @RequestMapping(\"getById\")\n" +
                "    public RestResultDto<" + modalName + "DTO> getById(@RequestBody " + modalName + "Criteria criteria) {\n" +
                "        Assert.notNull(criteria.getId(), \"id不能为空\");\n" +
                "        " + modalName + "DTO dto = new " + modalName + "DTO();\n" +
                "        " + modalName + " " + modalName + " = service.selectById(criteria.getId());\n" +
                "        Assert.notNull(" + modalName + ", \"根据id获取记录不存在\");\n" +
                "        BeanUtils.copyProperties(" + modalName + ", dto);\n" +
                "        return RestResultDto.newSuccess(dto);\n" +
                "    }\n" +
                "\n" +
                "    @ApiOperation(value = \"导出\", notes = \"导出\")\n" +
                "    @RequestMapping(value = \"/export\")\n" +
                "    public void export(@Valid @RequestBody " + modalName + "Criteria criteria, HttpServletResponse response) throws UnsupportedEncodingException {\n" +
                "        if (CollectionUtil.isNotEmpty(criteria.getIdList())) {\n" +
                "            criteria.setPage(null);\n" +
                "            criteria.setRows(null);\n" +
                "        }\n" +
                "        fileService.exportExcel(service.list(criteria), " + modalName + "DTO.class, URLEncoder.encode(\"" + chineseName + "\", \"UTF-8\"), \"" + chineseName + "\", response);\n" +
                "    }\n" + "    @ApiOperation(value = \"导入\", notes = \"导入\")\n" +
                "    @ApiImplicitParams({@ApiImplicitParam(name = \"file\", value = \"文件流\")})\n" +
                "    @RequestMapping(value = \"/import\")\n" +
                "    public RestResultDto<List<ImportExceptionDTO>> importItem(@RequestParam(value = \"file\") MultipartFile file) throws Exception {\n" +
                "        Assert.isTrue(StringUtil.isNotBlank(file.getOriginalFilename()) && ExcelUtil.isExcelExt(file.getOriginalFilename()), \"请上传Excel格式的文件\");\n" +
                "        Integer skipRow = 1;\n" +
                "        List<" + modalName + "ImportDTO> records = fileService.importExcel(file, " + modalName + "ImportDTO.class, \"\", skipRow);\n" +
                "        if (CollectionUtil.isEmpty(records)) {\n" +
                "            throw new CcxException(\"数据解析错误,请查看数据格式\");\n" +
                "        } else {\n" +
                "            List<ImportExceptionDTO> importExceptionDtoList = service.importItem(records);\n" +
                "            if (CollectionUtil.isEmpty(importExceptionDtoList)) {\n" +
                "                return RestResultDto.newSuccess(null, \"成功导入\" + records.size() + \"条数据\");\n" +
                "            } else {\n" +
                "                return RestResultDto.newFail(importExceptionDtoList, \"导入失败\");\n" +
                "            }\n" +
                "        }\n" +
                "    }" +
                "}\n");
        bufferedWriter.flush();
    }

    public static void writeModal(boolean splitTable, boolean longId, String modalName, String tableName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\ccxdto\\" + modalName + ".java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("import javax.persistence.Table;");
        bufferedWriter.newLine();
        bufferedWriter.write("@NameStyle(Style.normal)");
        bufferedWriter.newLine();
        bufferedWriter.write("@Table(name =" + modalName + ".TABLE_NAME,indexes = {})");
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
        bufferedWriter.write("    public static final String TABLE_NAME = Constants.TABLE_PRE + \"" + tableName + "\";\n");
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
        bufferedWriter.write("import org.springframework.transaction.annotation.Transactional;\n");
        bufferedWriter.write("import com.vortex.cloud.ccx.util.StringUtil;\n");
        bufferedWriter.write("import org.apache.commons.collections.CollectionUtils;");
        bufferedWriter.newLine();
        bufferedWriter.write("@Service");
        bufferedWriter.newLine();
        bufferedWriter.write("@Transactional(rollbackFor = Exception.class)");
        bufferedWriter.newLine();
        bufferedWriter.write("public class  " + modalName + "ServiceImpl  extends " + ext + "<" + modalName + "Mapper, " + modalName + ", " + modalName + "DTO, " + type + "> implements I" + modalName + "Service {");
        bufferedWriter.newLine();

        String criteriaToExample = "    @Override\n" +
                "    protected void criteriaToExample(Criteria criteria, Example example) {\n" +
                "        " + modalName + "Criteria entityCriteria = (" + modalName + "Criteria) criteria;\n" +
                "        Example.Criteria exampleCriteria = example.createCriteria();\n" +
                "        if (StringUtil.isNotBlank(entityCriteria.getTenantId())) {\n" +
                "            exampleCriteria.andEqualTo(\"tenantId\", entityCriteria.getTenantId());\n" +
                "        }\n" +
                "        if (CollectionUtils.isNotEmpty(entityCriteria.getIdList())) {\n" +
                "            exampleCriteria.andIn(\"id\", entityCriteria.getIdList());\n" +
                "        }\n";
        if (longId) {
            criteriaToExample += "        if (entityCriteria.getId() != null) {\n" +
                    "            exampleCriteria.andEqualTo(\"id\", entityCriteria.getId());\n" +
                    "        }\n" +
                    "        if (entityCriteria.getIdNe() != null) {\n" +
                    "            exampleCriteria.andNotEqualTo(\"id\", entityCriteria.getIdNe());\n" +
                    "        }\n";
        } else {
            criteriaToExample += "        if (StringUtils.isNotBlank(entityCriteria.getId())) {\n" +
                    "            exampleCriteria.andEqualTo(\"id\", entityCriteria.getId());\n" +
                    "        }\n" +
                    "        if (StringUtils.isNotBlank(entityCriteria.getIdNe())) {\n" +
                    "            exampleCriteria.andNotEqualTo(\"id\", entityCriteria.getIdNe());\n" +
                    "        }\n";
        }

        criteriaToExample += "    }";
        bufferedWriter.write(criteriaToExample);
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
