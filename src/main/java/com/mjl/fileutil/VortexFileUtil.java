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
//        String chineseName = "处置追踪-来源";
//        String modelName = "DisposalTrackSource";
//        String tableName = "disposal_track_source";
//        List<VortexColumnDTO> columnDTOS = new ArrayList<>();
//        columnDTOS.add(new VortexColumnDTO("disposalTrackingId", ColumnTypeEnum.String.getKey(), "处置追踪id", null, false));
//        columnDTOS.add(new VortexColumnDTO("sourceId", ColumnTypeEnum.String.getKey(), "来源编号 枚举:DisposalTrackingSourceEnum", null, false));
//        columnDTOS.add(new VortexColumnDTO("source", ColumnTypeEnum.String.getKey(), "来源 枚举:DisposalTrackingSourceEnum", null, false));
//        String modelName = "DisposalTrackCoordination";
//        String tableName = "disposal_track_coordination";
//        List<VortexColumnDTO> columnDTOS = new ArrayList<>();
//        columnDTOS.add(new VortexColumnDTO("disposalTrackingId", ColumnTypeEnum.String.getKey(), "处置追踪id", null, false));
//        columnDTOS.add(new VortexColumnDTO("coordinationDesc", ColumnTypeEnum.String.getKey(), "协同说明", 500, false));
//        columnDTOS.add(new VortexColumnDTO("coordinationPhoto", ColumnTypeEnum.String.getKey(), "协同照片", 500, false));


//        String modelName = "DisposalTrackCoordinationDept";
//        String tableName = "disposal_track_coordination_dept";
//        List<VortexColumnDTO> columnDTOS = new ArrayList<>();
//        columnDTOS.add(new VortexColumnDTO("disposalTrackingId", ColumnTypeEnum.String.getKey(), "处置追踪id", null, false));
//        columnDTOS.add(new VortexColumnDTO("disposalTrackingCoordinationId", ColumnTypeEnum.String.getKey(), "处置追踪协同id", null, false));
//        columnDTOS.add(new VortexColumnDTO("deptId", ColumnTypeEnum.String.getKey(), "部门id", null, false));
//        columnDTOS.add(new VortexColumnDTO("deptName", ColumnTypeEnum.String.getKey(), "部门名称", null, false));
//        columnDTOS.add(new VortexColumnDTO("handleDesc", ColumnTypeEnum.String.getKey(), "处置说明", 500, false));
//        columnDTOS.add(new VortexColumnDTO("handlePhoto", ColumnTypeEnum.String.getKey(), "处置照片", 500, false));

        String chineseName = "渝快政id对照关系";
        String modelName = "YkzIdBinding";
        String tableName = "ykz_id_binding";
        List<VortexColumnDTO> columnDTOS = new ArrayList<>();
        columnDTOS.add(new VortexColumnDTO("ykzId", ColumnTypeEnum.String.getKey(), "渝快政id", null, false));
        columnDTOS.add(new VortexColumnDTO("umsId", ColumnTypeEnum.String.getKey(), "umsId", null, false));

        writeModel(modelName, tableName, columnDTOS, chineseName);
        writeDTO(modelName, columnDTOS);
        writeVO(modelName, columnDTOS);
        writeMapper(modelName);
        writeService(modelName);
        writeServiceImpl(modelName);
        writeCriteria(modelName);
        writeController(modelName, chineseName);
    }

    private static void writeColumnInfo(VortexColumnDTO dto, BufferedWriter bufferedWriter, boolean writeDb, boolean valid) throws IOException {
        if (writeDb) {
            String type = dto.getType();
            String dbColumn = null;
            if (ColumnTypeEnum.Double.getKey().equals(type)) {
                dbColumn = "double";
            } else if (ColumnTypeEnum.String.getKey().equals(type)) {
                Integer length = dto.getLength() == null ? 50 : dto.getLength();
                dbColumn = "varchar(" + length + ")";
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
                "        return RestResultDTO.newSuccess(service.list(queryDto));\n" +
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
                "    @Operation(summary = \"根据id查询\")\n" +
                "    @RequestMapping(value = \"/getById\", method = {RequestMethod.GET, RequestMethod.POST})\n" +
                "    public RestResultDto<" + modelName + "VO> getById(@Parameter(description = \"租户ID\") @RequestHeader String tenantId,\n" +
                "                                                     @Parameter(description = \"用户ID\") @RequestHeader(required = false) String userId,\n" +
                "                                                     @RequestBody " + modelName + "SearchDTO queryDto) {\n" +
                "        Assert.hasText(queryDto.getId(), \"id不能为空\");\n" +
                "        List<" + modelName + "VO> list = service.list(queryDto);\n" +
                "        Assert.notNull(list, \"未找到记录\");\n" +
                "        return RestResultDto.newSuccess(list.get(0), Constants.MSG_SUCCESS_ZH);\n" +
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
        bufferedWriter.write("import org.hibernate.annotations.Table;");
        bufferedWriter.newLine();
        bufferedWriter.write("import javax.persistence.Column;");
        bufferedWriter.newLine();
        bufferedWriter.write("import javax.persistence.Entity;");
        bufferedWriter.newLine();
        bufferedWriter.write("@Data");
        bufferedWriter.newLine();
        bufferedWriter.write("@EqualsAndHashCode(of = \"id\")");
        bufferedWriter.newLine();
        bufferedWriter.write("@Entity(name = " + modelName + ".TABLE_NAME)");
        bufferedWriter.newLine();
        bufferedWriter.write("@Table(appliesTo = " + modelName + ".TABLE_NAME, comment = \"" + chineseName + "\")");
        bufferedWriter.newLine();
        bufferedWriter.write("@TableName(value = " + modelName + ".TABLE_NAME)");
        bufferedWriter.newLine();
        bufferedWriter.write("public class  " + modelName + "  extends AbstractBaseDeleteModel {");
        bufferedWriter.newLine();
        bufferedWriter.write(" public static final String TABLE_NAME = Constants.TABLE_PREFIX + \"" + tableName + "\";");
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
                "import javax.validation.constraints.NotNull;");
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

        bufferedWriter.write("public interface  I" + modelName + "Service  {");
        bufferedWriter.newLine();
        bufferedWriter.write("    /**\n" +
                "     * @param searchDTO\n" +
                "     * @return\n" +
                "     */\n" +
                "    DataStoreDTO<" + modelName + "VO> page(" + modelName + "SearchDTO " + "searchDTO);\n" +
                "\n" +
                "    /**\n" +
                "     * @param searchDTO\n" +
                "     * @return\n" +
                "     */\n" +
                "    List<" + modelName + "VO> list(" + modelName + "SearchDTO " + "searchDTO);\n" +
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
                "    void delete(List<String> idList);");
        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    public static void writeServiceImpl(String modelName) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\" + modelName + "ServiceImpl.java");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("import org.springframework.transaction.annotation.Transactional;");
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
        bufferedWriter.write("public class  " + modelName + "ServiceImpl    implements I" + modelName + "Service {");
        bufferedWriter.newLine();

        bufferedWriter.write("@Resource");
        bufferedWriter.newLine();
        bufferedWriter.write("private " + modelName + "Mapper mapper;");
        bufferedWriter.newLine();

        bufferedWriter.write("    private QueryWrapper<" + modelName + "> buildQuery(" + modelName + "SearchDTO queryDto) {\n" +
                "        QueryWrapper<" + modelName + "> queryWrapper = new QueryWrapper<>();\n" +
                "        if (StringUtils.isNotBlank(queryDto.getTenantId())) {\n" +
                "            queryWrapper.lambda().eq(" + modelName + "::getTenantId, queryDto.getTenantId());\n" +
                "        }\n" +
                "        if (CollectionUtils.isNotEmpty(queryDto.getIdList())) {\n" +
                "            queryWrapper.lambda().in(" + modelName + "::getId, queryDto.getIdList());\n" +
                "        }\n" +
                "        if (StringUtils.isNotBlank(queryDto.getId())) {\n" +
                "            queryWrapper.lambda().eq(" + modelName + "::getId, queryDto.getId());\n" +
                "        }\n" +
                "        if (StringUtils.isNotBlank(queryDto.getIdNe())) {\n" +
                "            queryWrapper.lambda().ne(" + modelName + "::getId, queryDto.getIdNe());\n" +
                "        }\n" +
                "        return queryWrapper;\n" +
                "    }");
        bufferedWriter.newLine();
        bufferedWriter.write("    private " + modelName + " transEntity(" + modelName + "DTO dto) {\n" +
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
                "    }");
        bufferedWriter.newLine();
        bufferedWriter.write("    @Override\n" +
                "    public DataStoreDTO<" + modelName + "VO> page(" + modelName + "SearchDTO searchDTO) {\n" +
                "        QueryWrapper<" + modelName + "> queryWrapper = buildQuery(searchDTO);\n" +
                "        Pageable pageable = PageUtil.getPageable(searchDTO);\n" +
                "        Page<" + modelName + "> page = PageUtils.transferPage(pageable);\n" +
                "        Page<" + modelName + "> pageContent = mapper.selectPage(page, queryWrapper);\n" +
                "        return new DataStoreDTO<>(pageContent.getTotal(), transVos(pageContent.getRecords()));\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public List<" + modelName + "VO> list(" + modelName + "SearchDTO searchDTO) {\n" +
                "        QueryWrapper<" + modelName + "> queryWrapper = buildQuery(searchDTO);\n" +
                "        Sort sort = PageUtil.getSort(searchDTO);\n" +
                "        PageUtils.transferSort(queryWrapper, sort);\n" +
                "        return transVos(mapper.selectList(queryWrapper));\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void insert(" + modelName + "DTO dto) {\n" +
                "        " + modelName + " model = transEntity(dto);\n" +
                "        mapper.insert(model);\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void update(" + modelName + "DTO dto) {\n" +
                "        String id = dto.getId();\n" +
                "        Assert.hasText(id, \"id不能为空\");\n" +
                "        " + modelName + " modelInDb = mapper.selectById(id);\n" +
                "        Assert.notNull(modelInDb, \"根据id未找到数据\");\n" +
                "        " + modelName + " model = transEntity(dto);\n" +
                "        model.setId(id);\n" +
                "        mapper.updateById(model);\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void delete(List<String> idList) {\n" +
                "        if (CollectionUtils.isNotEmpty(idList)) {\n" +
                "            mapper.deleteBatchIds(idList);\n" +
                "        }\n" +
                "    }");

        bufferedWriter.newLine();
        bufferedWriter.write("}");
        bufferedWriter.flush();
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
