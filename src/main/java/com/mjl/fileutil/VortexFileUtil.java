package com.mjl.fileutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MJL
 * @date 2023/8/14.
 */

// columnDTOS.add(new VortexColumnDTO("divisionId",ColumnTypeEnum.String.getKey(),"行政区划id",null,true));
// columnDTOS.add(new VortexColumnDTO("divisionCode",ColumnTypeEnum.String.getKey(),"行政区划编号",null,true));
// columnDTOS.add(new VortexColumnDTO("division",ColumnTypeEnum.String.getKey(),"行政区划",null,true));
// columnDTOS.add(new VortexColumnDTO("facilityId",ColumnTypeEnum.String.getKey(),"基础设施id",null,true));
// columnDTOS.add(new VortexColumnDTO("facilityName",ColumnTypeEnum.String.getKey(),"基础设施",null,true));
// columnDTOS.add(new VortexColumnDTO("position",ColumnTypeEnum.String.getKey(),"位置",500,true));
// columnDTOS.add(new VortexColumnDTO("threshold",ColumnTypeEnum.BigDecimal.getKey(),"点位内涝阈值",null,true));
// columnDTOS.add(new VortexColumnDTO("deptId",ColumnTypeEnum.String.getKey(),"责任部门id",null,true));
// columnDTOS.add(new VortexColumnDTO("deptIdName",ColumnTypeEnum.String.getKey(),"责任部门id",null,true));

public class VortexFileUtil {
    public static void main(String[] args) throws IOException {


        String chineseName = "会议管理";
        String modelName = "MeetingManage";
        String tableName = "Constants.TABLE_PREFIX + " + "\"meeting_manage";
        List<VortexColumnDTO> columnDTOS = new ArrayList<>();
        columnDTOS.add(new VortexColumnDTO("waterUtilityId", ColumnTypeEnum.String.getKey(), "公司id(水司)", null, true));
        columnDTOS.add(new VortexColumnDTO("waterUtilityName", ColumnTypeEnum.String.getKey(), "公司(水司)", null, true));
        columnDTOS.add(new VortexColumnDTO("waterPlantId", ColumnTypeEnum.String.getKey(), "关联水厂id", null, false));
        columnDTOS.add(new VortexColumnDTO("waterPlantName", ColumnTypeEnum.String.getKey(), "关联水厂", null, false));
        columnDTOS.add(new VortexColumnDTO("name", ColumnTypeEnum.String.getKey(), "会议名称", 30, true));
        columnDTOS.add(new VortexColumnDTO("time", ColumnTypeEnum.Date.getKey(), "时间", null, true));
        columnDTOS.add(new VortexColumnDTO("host", ColumnTypeEnum.String.getKey(), "主持人", 20, true));
        columnDTOS.add(new VortexColumnDTO("location", ColumnTypeEnum.String.getKey(), "会议地点", 30, true));
        columnDTOS.add(new VortexColumnDTO("content", ColumnTypeEnum.String.getKey(), "会议内容", 500, true));
        columnDTOS.add(new VortexColumnDTO("photo", ColumnTypeEnum.String.getKey(), "图片", 2500, false));
        columnDTOS.add(new VortexColumnDTO("file", ColumnTypeEnum.String.getKey(), "附件", 2500, true));
        columnDTOS.add(new VortexColumnDTO("remarks", ColumnTypeEnum.String.getKey(), "备注", 500, false));


//        String chineseName = "排污许可证管理";
//        String modelName = "PollutantDischargePermit";
//        String tableName = "Constants.TABLE_PREFIX + " + "\"pollutant_discharge_permit";
//        List<VortexColumnDTO> columnDTOS = new ArrayList<>();
//        columnDTOS.add(new VortexColumnDTO("waterUtilityId", ColumnTypeEnum.String.getKey(), "公司id(水司)", null, true));
//        columnDTOS.add(new VortexColumnDTO("waterUtilityName", ColumnTypeEnum.String.getKey(), "公司(水司)", null, true));
//        columnDTOS.add(new VortexColumnDTO("code", ColumnTypeEnum.String.getKey(), "许可证编号", 30, true));
//        columnDTOS.add(new VortexColumnDTO("controlType", ColumnTypeEnum.String.getKey(), "管控类型", 30, true));
//        columnDTOS.add(new VortexColumnDTO("EffectiveDateStart", ColumnTypeEnum.LocalDate.getKey(), "有效期限开始", null, true));
//        columnDTOS.add(new VortexColumnDTO("EffectiveDateEnd", ColumnTypeEnum.LocalDate.getKey(), "有效期限结束", null, true));
//        columnDTOS.add(new VortexColumnDTO("alarmDate", ColumnTypeEnum.LocalDate.getKey(), "预警日期", null, true));
//        columnDTOS.add(new VortexColumnDTO("statusCode", ColumnTypeEnum.String.getKey(), "状态 枚举PollutantDischargePermitStatusEnum", null, false));
//        columnDTOS.add(new VortexColumnDTO("file", ColumnTypeEnum.String.getKey(), "附件", 2500, false));
//        String chineseName = "项目运营合同管理";
//        String modelName = "ProjectOperationContract";
//        String tableName = "Constants.TABLE_PREFIX + " + "\"project_operation_contract";
//        List<VortexColumnDTO> columnDTOS = new ArrayList<>();
//        columnDTOS.add(new VortexColumnDTO("waterUtilityId", ColumnTypeEnum.String.getKey(), "项目公司id(水司)", null, true));
//        columnDTOS.add(new VortexColumnDTO("waterUtilityName", ColumnTypeEnum.String.getKey(), "项目公司(水司)", null, true));
//        columnDTOS.add(new VortexColumnDTO("partyA", ColumnTypeEnum.String.getKey(), "甲方", 30, true));
//        columnDTOS.add(new VortexColumnDTO("name", ColumnTypeEnum.String.getKey(), "合同名称", 30, true));
//        columnDTOS.add(new VortexColumnDTO("signingDate", ColumnTypeEnum.LocalDate.getKey(), "签订时间", null, true));
//        columnDTOS.add(new VortexColumnDTO("operationPeriod", ColumnTypeEnum.Integer.getKey(), "运营期限", null, true));
//        columnDTOS.add(new VortexColumnDTO("expirationDate", ColumnTypeEnum.LocalDate.getKey(), "到期时间", null, true));
//        columnDTOS.add(new VortexColumnDTO("statusCode", ColumnTypeEnum.String.getKey(), "合同状态编号 枚举ProjectOperationContractEnum", null, false));
//        columnDTOS.add(new VortexColumnDTO("file", ColumnTypeEnum.String.getKey(), "附件", 2500, false));


        writeModel(modelName, tableName, columnDTOS, chineseName);
        writeDTO(modelName, columnDTOS);
        writeVO(modelName, columnDTOS);
        writeMapper(modelName);
        writeService(modelName);
        writeServiceImpl(modelName);
        writeCriteria(modelName);
        writeController(modelName, chineseName);
    }

    public static void writeImort(String modelName, String tableName, List<VortexColumnDTO> columnDTOS, String chineseName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\" + modelName + ".java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("import com.baomidou.mybatisplus.annotation.TableName;");
        bufferedWriter.newLine();
        bufferedWriter.write("import com.vortex.cloud.vfs.lite.data.domain.AbstractBaseDeleteModel;");
        bufferedWriter.newLine();
        bufferedWriter.write("import lombok.Data;");
        bufferedWriter.newLine();
        bufferedWriter.write("@Data");
        bufferedWriter.newLine();
        bufferedWriter.write("public class  " + modelName + "ImportDTO  extends AbstractTemplateDTO {");
        bufferedWriter.newLine();
        for (VortexColumnDTO columnDTO : columnDTOS) {
            String importCheck = "@ImportCheck(";
            String type = columnDTO.getType();
            if (ColumnTypeEnum.Double.getKey().equals(type)) {
                importCheck += "isDouble";
            } else if (ColumnTypeEnum.String.getKey().equals(type)) {
                importCheck += "isString";
            } else if (ColumnTypeEnum.LocalDate.getKey().equals(type)) {
                importCheck += "isLocalDate";
            } else if (ColumnTypeEnum.Date.getKey().equals(type)) {
                importCheck += "isDate";
            } else if (ColumnTypeEnum.Integer.getKey().equals(type)) {
                importCheck += "isInteger";
            } else if (ColumnTypeEnum.Long.getKey().equals(type)) {
                importCheck += "isLong";
            } else if (ColumnTypeEnum.BigDecimal.getKey().equals(type)) {
                importCheck += "isBigDecimal";
            }
            importCheck += "= true,";
            if (Boolean.TRUE.equals(columnDTO.getNotNull())) {
                importCheck += " notNull = true,";
            }
            if (ColumnTypeEnum.String.getKey().equals(type)) {
                Integer length = columnDTO.getLength() == null ? 50 : columnDTO.getLength();
                importCheck += " length = " + length + ",";
            }
            importCheck += "msg = \"" + columnDTO.getComment() + "\"";
            importCheck += ")";
            bufferedWriter.write(importCheck);
            bufferedWriter.newLine();
            bufferedWriter.write(" private String " + columnDTO.getName() + ";");

        }
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    private static void writeColumnInfo(VortexColumnDTO dto, BufferedWriter bufferedWriter, boolean writeDb, boolean valid) throws IOException {
        if (writeDb) {
            String type = dto.getType();
            String dbColumn = null;
            if (ColumnTypeEnum.Double.getKey().equals(type)) {
                dbColumn = "double";
            } else if (ColumnTypeEnum.String.getKey().equals(type)) {
                Integer length = dto.getLength() == null ? 50 : dto.getLength();
                dbColumn = "varchar(" + length + ") default ''";
            } else if (ColumnTypeEnum.LocalDate.getKey().equals(type)) {
                dbColumn = "date";
            } else if (ColumnTypeEnum.Date.getKey().equals(type)) {
                dbColumn = "datetime";
            } else if (ColumnTypeEnum.Integer.getKey().equals(type)) {
                dbColumn = "int";
            } else if (ColumnTypeEnum.Long.getKey().equals(type)) {
                dbColumn = "bigint(20)";
            } else if (ColumnTypeEnum.BigDecimal.getKey().equals(type)) {
                dbColumn = "decimal(19,2)";
            } else if (ColumnTypeEnum.Boolean.getKey().equals(type)) {
                dbColumn = "bit(1)";
            }
            bufferedWriter.write(" @Column(columnDefinition = \"" + dbColumn + " comment '" + dto.getComment() + "'\")");
            if (Boolean.FALSE.equals(dto.getNotNull())) {
                bufferedWriter.write("  @TableField(updateStrategy = FieldStrategy.IGNORED)");
            }
            bufferedWriter.newLine();
        }
        if (valid && Boolean.TRUE.equals(dto.getNotNull())) {
            String type = dto.getType();
            String comment = dto.getComment();
            String validMsg = null;
            if (ColumnTypeEnum.String.getKey().equals(type)) {
                validMsg = "NotBlank";
            } else {
                validMsg = "NotNull";
            }
            bufferedWriter.write(" @" + validMsg + "(message = \"" + comment + "不能为空\")");
            bufferedWriter.newLine();
        }
        bufferedWriter.write(" @Schema(description = \"" + dto.getComment() + "\")");

        bufferedWriter.newLine();
        bufferedWriter.write(" private " + dto.getType() + " " + dto.getName() + ";");
        bufferedWriter.newLine();
    }

    public static void writeController(String modelName, String chineseName) throws IOException {


        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\" + modelName + "Controller.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("import java.util.List;");
        bufferedWriter.newLine();
        bufferedWriter.write("import org.springframework.beans.BeanUtils;");
        bufferedWriter.newLine();
        bufferedWriter.write("import io.swagger.v3.oas.annotations.tags.Tag;");
        bufferedWriter.newLine();
        bufferedWriter.write("import io.swagger.v3.oas.annotations.Parameter;");
        bufferedWriter.newLine();
        bufferedWriter.write("import org.springframework.web.bind.annotation.*;");
        bufferedWriter.newLine();

        char firstChar = modelName.charAt(0);
        char updatedFirstChar = Character.toLowerCase(firstChar);
        String remainder = modelName.substring(1);
        String tag = updatedFirstChar + remainder;

        bufferedWriter.write("@Tag(name = \"" + chineseName + "\")\n" +
                "@RestController\n" +
                "@RequestMapping(\"api/" + tag + "\")\n" +
                "public class " + modelName + "Controller extends ActionTicketBaseController{\n" +
                "    @Autowired\n" +
                "    private I" + modelName + "Service service;\n" +
                "\n" +
                "    @Operation(summary = \"分页查询\")\n" +
                "    @RequestMapping(value = \"pageList\", method = {RequestMethod.GET, RequestMethod.POST})\n" +
                "    public RestResultDTO<DataStoreDTO<" + modelName + "VO>> pageList(\n" +
                "            @Parameter(description = \"租户ID\") @RequestHeader String tenantId,\n" +
                "            @Parameter(description = \"用户ID\") @RequestHeader(required = false) String userId,\n" +
                "            @RequestBody " + modelName + "SearchDTO queryDto) {\n" +
                "        queryDto.setTenantId(tenantId);\n" +
                "        queryDto.setUserId(userId);\n" +
                "        return RestResultDTO.newSuccess(service.page(queryDto));\n" +
                "    }\n" +
                "\n" +
                "    @Operation(summary = \"列表\")\n" +
                "    @RequestMapping(value = \"list\", method = {RequestMethod.GET, RequestMethod.POST})\n" +
                "    public RestResultDTO<List<" + modelName + "VO>> list(@Parameter(description = \"租户ID\") @RequestHeader String tenantId,\n" +
                "                                                        @Parameter(description = \"用户ID\") @RequestHeader(required = false) String userId,\n" +
                "                                                        @RequestBody " + modelName + "SearchDTO queryDto) {\n" +
                "        queryDto.setTenantId(tenantId);\n" +
                "        queryDto.setUserId(userId);\n" +
                "        return RestResultDTO.newSuccess(service.listDto(queryDto));\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    @Operation(summary = \"新增\")\n" +
                "    @RequestMapping(value = \"save\", method = {RequestMethod.GET, RequestMethod.POST})\n" +
                "    @ActionTicketVerify\n" +
                "    public RestResultDTO<String> save(@Parameter(description = \"租户ID\") @RequestHeader String tenantId,\n" +
                "                                      @Parameter(description = \"用户ID\") @RequestHeader(required = false) String userId,\n" +
                "                                      @Valid @RequestBody " + modelName + "DTO dto) {\n" +
                "        dto.setTenantId(tenantId);\n" +
                "        service.insert(dto);\n" +
                "        return RestResultDTO.newSuccess();\n" +
                "    }\n" +
                "\n" +
                "    @Operation(summary = \"修改\")\n" +
                "    @RequestMapping(value = \"update\", method = {RequestMethod.GET, RequestMethod.POST})\n" +
                "    @ActionTicketVerify\n" +
                "    public RestResultDTO<String> update(@Parameter(description = \"租户ID\") @RequestHeader String tenantId,\n" +
                "                                        @Parameter(description = \"用户ID\") @RequestHeader(required = false) String userId,\n" +
                "                                        @Valid @RequestBody " + modelName + "DTO dto) {\n" +
                "        dto.setTenantId(tenantId);\n" +
                "        service.update(dto);\n" +
                "        return RestResultDTO.newSuccess();\n" +
                "    }\n" +
                "\n" +
                "    @Operation(summary = \"删除\")\n" +
                "    @RequestMapping(value = \"delete\", method = {RequestMethod.GET, RequestMethod.POST})\n" +
                "    public RestResultDTO<Void> delete(@Parameter(description = \"租户ID\") @RequestHeader String tenantId,\n" +
                "                                      @Parameter(description = \"用户ID\") @RequestHeader(required = false) String userId,\n" +
                "                                      @RequestBody " + modelName + "SearchDTO queryDto) {\n" +
                "        service.delete(queryDto.getIdList());\n" +
                "        return RestResultDTO.newSuccess();\n" +
                "    }\n" +
                "\n" +

                "       @Operation(summary = \"根据id查询\")\n" +
                "    @RequestMapping(value = \"/getById\", method = {RequestMethod.GET, RequestMethod.POST})\n" +
                "    public RestResultDto<" + modelName + "VO> getById(@Parameter(description = \"租户ID\") @RequestHeader String tenantId,\n" +
                "                                                    @Parameter(description = \"用户ID\") @RequestHeader(required = false) String userId,\n" +
                "                                                    @RequestParam String id) {\n" +
                "     Assert.hasText(id, \"id不能为空\");\n" +
                "        return RestResultDto.newSuccess(service.getById(id));\n" +
                "    }\n" +
                " @Operation(summary = \"导出\")\n" +
                "    @RequestMapping(value = \"export\", method = {RequestMethod.GET, RequestMethod.POST})\n" +
                "    public void dayExport(@Parameter(description = \"租户ID\") @RequestHeader String tenantId,\n" +
                "                          @Parameter(description = \"用户ID\") @RequestHeader String userId,\n" +
                "                          @RequestBody " + modelName + "SearchDTO queryDto,\n" +
                "                          HttpServletResponse response) {\n" +
                "        queryDto.setTenantId(tenantId);\n" +
                "        queryDto.setUserId(userId);\n" +
                "        List<" + modelName + "VO> list = service.listDto(queryDto);\n" +
                "        ExcelUtils.exportExcel(queryDto.getFileName(), queryDto.getExtension(), null, queryDto.getColumnJson(), list, response);\n" +
                "    }\n" +
                "}");
        bufferedWriter.flush();
    }

    public static void writeModel(String modelName, String tableName, List<VortexColumnDTO> columnDTOS, String chineseName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\" + modelName + ".java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("import com.baomidou.mybatisplus.annotation.TableName;");
        bufferedWriter.newLine();
        bufferedWriter.write("import com.vortex.cloud.vfs.lite.data.domain.AbstractBaseDeleteModel;");
        bufferedWriter.newLine();
        bufferedWriter.write("import lombok.Data;");
        bufferedWriter.newLine();
        bufferedWriter.write("import lombok.EqualsAndHashCode;");
        bufferedWriter.newLine();
        bufferedWriter.write("import javax.persistence.Column;");
        bufferedWriter.newLine();
        bufferedWriter.write("import javax.persistence.Entity;");
        bufferedWriter.newLine();
        bufferedWriter.write("import org.hibernate.annotations.Table;;");
        bufferedWriter.newLine();
        bufferedWriter.write("@Data");
        bufferedWriter.newLine();
        bufferedWriter.write("@EqualsAndHashCode(of = \"id\")");
        bufferedWriter.newLine();
        bufferedWriter.write("@Entity(name = " + modelName + ".TABLE_NAME)");
        bufferedWriter.newLine();
        bufferedWriter.write("@Table(appliesTo = " + modelName + ".TABLE_NAME,comment = \"" + chineseName + "\",indexes =    {})");
        bufferedWriter.newLine();
        bufferedWriter.write("@TableName(value = " + modelName + ".TABLE_NAME)");
        bufferedWriter.newLine();
        bufferedWriter.write("public class  " + modelName + "  extends AbstractBaseDeleteModel {");
        bufferedWriter.newLine();
        bufferedWriter.write(" public static final String TABLE_NAME =" + tableName + "\";");
        bufferedWriter.newLine();
        for (VortexColumnDTO columnDTO : columnDTOS) {
            writeColumnInfo(columnDTO, bufferedWriter, true, false);
        }
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeVO(String modelName, List<VortexColumnDTO> columnDTOS) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\" + modelName + "VO.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("import com.vortex.cloud.vfs.lite.base.dto.AbstractBaseTenantDTO;");
        bufferedWriter.newLine();
        bufferedWriter.write("@Data");
        bufferedWriter.newLine();
        bufferedWriter.write("public class  " + modelName + "VO  extends AbstractBaseTenantDTO {");
        bufferedWriter.newLine();
        for (VortexColumnDTO columnDTO : columnDTOS) {
            writeColumnInfo(columnDTO, bufferedWriter, false, false);
        }
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeDTO(String modelName, List<VortexColumnDTO> columnDTOS) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\" + modelName + "DTO.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("import javax.validation.constraints.NotBlank;\n" +
                "import javax.validation.constraints.NotNull;\n" + "import com.vortex.cloud.vfs.lite.base.dto.AbstractBaseTenantDTO;");
        bufferedWriter.newLine();
        bufferedWriter.write("@Data");
        bufferedWriter.newLine();
        bufferedWriter.write("public class  " + modelName + "DTO  extends AbstractBaseTenantDTO {");
        bufferedWriter.newLine();
        for (VortexColumnDTO columnDTO : columnDTOS) {
            writeColumnInfo(columnDTO, bufferedWriter, false, true);
        }
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeMapper(String modelName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\" + modelName + "Mapper.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("public interface  " + modelName + "Mapper  extends BaseMapper<" + modelName + ">{");
        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeService(String modelName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\I" + modelName + "Service.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("import java.util.List;");
        bufferedWriter.newLine();
        bufferedWriter.write("import org.springframework.beans.BeanUtils;");
        bufferedWriter.newLine();
        bufferedWriter.write("import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write("public interface  I" + modelName + "Service  extends IService<" + modelName + "> {\n" +
                "    /**\n" +
                "     * @param queryDto\n" +
                "     * @return\n" +
                "     */\n" +
                "    LambdaQueryChainWrapper<" + modelName + "> buildQuery(" + modelName + "SearchDTO queryDto);\n" +
                "\n" +
                "    /**\n" +
                "     * @param searchDTO\n" +
                "     * @return\n" +
                "     */\n" +
                "    DataStoreDTO<" + modelName + "VO> page(" + modelName + "SearchDTO searchDTO);\n" +
                "\n" +
                "    /**\n" +
                "     * @param searchDTO\n" +
                "     * @return\n" +
                "     */\n" +
                "    List<" + modelName + "VO> listDto(" + modelName + "SearchDTO searchDTO);\n" +
                "\n" +
                "\n" +
                "    /**\n" +
                "     * @param dto\n" +
                "     */\n" +
                "    void insert(" + modelName + "DTO dto);\n" +
                "\n" +
                "    /**\n" +
                "     * @param dto\n" +
                "     */\n" +
                "    void update(" + modelName + "DTO dto);\n" +
                "\n" +
                "    /**\n" +
                "     * @param idList\n" +
                "     */\n" +
                "    void delete(List<String> idList);\n" +
                "    /**\n" +
                "     * getById\n" +
                "     *\n" +
                "     * @param id\n" +
                "     * @return\n" +
                "     */\n" +
                "    " + modelName + "VO getById(String id);\n" +
                "}");
        bufferedWriter.flush();
    }

    public static void writeServiceImpl(String modelName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\" + modelName + "ServiceImpl.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("import org.springframework.transaction.annotation.Transactional;");
        bufferedWriter.newLine();
        bufferedWriter.write("import java.util.List;");
        bufferedWriter.newLine();
        bufferedWriter.write("import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;");
        bufferedWriter.newLine();
        bufferedWriter.write("import org.springframework.beans.BeanUtils;");
        bufferedWriter.newLine();
        bufferedWriter.write("import com.google.common.collect.Lists;");
        bufferedWriter.newLine();
        bufferedWriter.write("import org.apache.commons.lang3.StringUtils;");
        bufferedWriter.newLine();
        bufferedWriter.write("import org.apache.commons.collections4.CollectionUtils;");
        bufferedWriter.newLine();
        bufferedWriter.write("@Service");
        bufferedWriter.newLine();
        bufferedWriter.write("@Transactional(rollbackFor = Exception.class)");
        bufferedWriter.newLine();
        bufferedWriter.write(
                "public class " + modelName + "ServiceImpl extends ServiceImpl<" + modelName + "Mapper, " + modelName + "> implements I" + modelName + "Service {\n" +
                        "    @Override\n" +
                        "    public LambdaQueryChainWrapper<" + modelName + "> buildQuery(" + modelName + "SearchDTO queryDto) {\n" +
                        "        LambdaQueryChainWrapper<" + modelName + "> queryWrapper = lambdaQuery();\n" +
                        "        if (StringUtils.isNotBlank(queryDto.getTenantId())) {\n" +
                        "            queryWrapper.eq(" + modelName + "::getTenantId, queryDto.getTenantId());\n" +
                        "        }\n" +
                        "        if (CollectionUtils.isNotEmpty(queryDto.getIdList())) {\n" +
                        "            queryWrapper.in(" + modelName + "::getId, queryDto.getIdList());\n" +
                        "        }\n" +
                        "        if (StringUtils.isNotBlank(queryDto.getId())) {\n" +
                        "            queryWrapper.eq(" + modelName + "::getId, queryDto.getId());\n" +
                        "        }\n" +
                        "        if (StringUtils.isNotBlank(queryDto.getIdNe())) {\n" +
                        "            queryWrapper.ne(" + modelName + "::getId, queryDto.getIdNe());\n" +
                        "        }\n" +
                        "        return queryWrapper;\n" +
                        "    }\n" +
                        "\n" +
                        "    private " + modelName + " transEntity(" + modelName + "DTO dto) {\n" +
                        "        " + modelName + " entity = new " + modelName + "();\n" +
                        "        BeanUtils.copyProperties(dto, entity);\n" +
                        "        return entity;\n" +
                        "    }\n" +
                        "\n" +
                        "    private List<" + modelName + "VO> transVos(List<" + modelName + "> records) {\n" +
                        "        List<" + modelName + "VO> list = Lists.newArrayList();\n" +
                        "        if (CollectionUtils.isNotEmpty(records)) {\n" +
                        "            for (" + modelName + " record : records) {\n" +
                        "                list.add(transVo(record));\n" +
                        "            }\n" +
                        "        }\n" +
                        "        return list;\n" +
                        "    }\n" +
                        "\n" +
                        "    private " + modelName + "VO transVo(" + modelName + " record) {\n" +
                        "        " + modelName + "VO vo = new " + modelName + "VO();\n" +
                        "        BeanUtils.copyProperties(record, vo);\n" +
                        "        return vo;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public DataStoreDTO<" + modelName + "VO> page(" + modelName + "SearchDTO searchDTO) {\n" +
                        "        LambdaQueryChainWrapper<" + modelName + "> queryWrapper = buildQuery(searchDTO);\n" +
                        "        Page<" + modelName + "> page = PageUtil.transferPage(searchDTO);\n" +
                        "        Page<" + modelName + "> pageContent = queryWrapper.page(page);\n" +
                        "        return new DataStoreDTO<>(pageContent.getTotal(), transVos(pageContent.getRecords()));\n" +
                        "    }\n" +
                        "\n" +
                        "        @Override\n" +
                        "    public List<" + modelName + "VO> listDto(" + modelName + "SearchDTO searchDTO) {\n" +
                        "        LambdaQueryChainWrapper<" + modelName + "> queryWrapper = buildQuery(searchDTO);\n" +
                        "        PageUtil.formatListSort(queryWrapper, searchDTO, " + modelName + ".class);\n" +
                        "        List<" + modelName + "> list = queryWrapper.list();\n" +
                        "        return transVos(list);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void insert(" + modelName + "DTO dto) {\n" +
                        "        " + modelName + " model = transEntity(dto);\n" +
                        "        super.save(model);\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void update(" + modelName + "DTO dto) {\n" +
                        "        String id = dto.getId();\n" +
                        "        Assert.hasText(id, \"id不能为空\");\n" +
                        "        " + modelName + "Mapper mapper = getBaseMapper();\n" +
                        "        " + modelName + " modelInDb = mapper.selectById(id);\n" +
                        "        Assert.notNull(modelInDb, \"根据id未找到数据\");\n" +
                        "        " + modelName + " model = transEntity(dto);\n" +
                        "        model.setId(id);\n" +
                        "        super.updateById(model);\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void delete(List<String> idList) {\n" +
                        "        if (CollectionUtils.isNotEmpty(idList)) {\n" +
                        "            super.removeByIds(idList);\n" +
                        "        }\n" +
                        "    }\n" +
                        "    @Override\n" +
                        "    public " + modelName + "VO getById(String id) {\n" +
                        "        " + modelName + "SearchDTO searchDTO = new " + modelName + "SearchDTO();\n" +
                        "        searchDTO.setId(id);\n" +
                        "        List<" + modelName + "VO> " + lowerCaseFirstLetter(modelName) + "VOS = listDto(searchDTO);\n" +
                        "        Assert.notEmpty(" + lowerCaseFirstLetter(modelName) + "VOS, \"根据id未找到数据\");\n" +
                        "        return " + lowerCaseFirstLetter(modelName) + "VOS.get(0);\n" +
                        "    }\n");


        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static String lowerCaseFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    public static void writeCriteria(String modelName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\" + modelName + "SearchDTO.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("@Data");
        bufferedWriter.newLine();
        bufferedWriter.write("public class  " + modelName + "SearchDTO extends BaseSearchDTO{");
        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }
}
