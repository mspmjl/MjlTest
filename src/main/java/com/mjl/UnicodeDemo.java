package com.mjl;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author MJL
 * @date 2021/12/8.
 */
@Transactional(rollbackFor = Exception.class)
public class UnicodeDemo {
    public static void main(String[] args) throws Exception {
        String s = "{" +
                "  \"id\": \"1650849013258579458\"," +
                "  \"tenantId\": \"c8351ccc8f8047e08c4428557c458df5\"," +
                "  \"code\": \"pump_station\"," +
                "  \"name\": \"u6cf5u7ad9\"," +
                "  \"orderIndex\": 1," +
                "  \"unit\": \"u5ea7\"," +
                "  \"geometryTypeCode\": \"point\"," +
                "  \"showInReport\": false," +
                "  \"showInGis\": false," +
                "  \"showKanBan\": false," +
                "  \"hasVideo\": false," +
                "  \"filterDivisionCountZero\": false," +
                "  \"closeCount\": false," +
                "  \"gisIcon\": {}," +
                "  \"housingEstate\": false," +
                "  \"cdAppShow\": false," +
                "  \"kanBanClass\": \"CLEANING_OPERATION\"," +
                "  \"operationTypes\": []," +
                "  \"collectPoint\": false," +
                "  \"showQrCode\": false," +
                "  \"beenWorkObject\": false," +
                "  \"statusRecord\": false," +
                "  \"statusData\": []," +
                "  \"fieldsValue\": []," +
                "  \"kanBanClassName\": \"u4fddu6d01u5bf9u8c61\"," +
                "  \"needChangeRecord\": false," +
                "  \"needChangeStatusRecord\": false," +
                "  \"showModal\": true," +
                "  \"divisionLevel\": \"2,3\"," +
                "  \"approvalNodes\": []," +
                "  \"fieldJson\": [" +
                "    {" +
                "      \"key\": \"code\"," +
                "      \"name\": \"u7f16u7801\"," +
                "      \"showName\": \"u6cf5u7ad9u7f16u7801\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"code\"," +
                "      \"orderIndex\": 1," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"INPUT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": 32," +
                "              \"name\": \"STRING_MAX\"" +
                "            }," +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REQUIRE\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": true," +
                "      \"tableShow\": true," +
                "      \"queryShow\": true," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 1," +
                "      \"queryOrder\": 1," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": true" +
                "    }," +
                "    {" +
                "      \"key\": \"name\"," +
                "      \"name\": \"u540du79f0\"," +
                "      \"showName\": \"u6cf5u7ad9u540du79f0\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"name\"," +
                "      \"orderIndex\": 2," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"INPUT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": 32," +
                "              \"name\": \"STRING_MAX\"" +
                "            }," +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REQUIRE\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": true," +
                "      \"tableShow\": true," +
                "      \"queryShow\": true," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 2," +
                "      \"queryOrder\": 2," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": true" +
                "    }," +
                "    {" +
                "      \"key\": \"divisionId\"," +
                "      \"name\": \"u884cu653fu533au5212\"," +
                "      \"showName\": \"u884cu653fu533au5212\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"divisionName\"," +
                "      \"orderIndex\": 4," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"DIVISION\"," +
                "        \"parameter\": {" +
                "          \"validators\": []," +
                "          \"operator\": \"IN\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": true," +
                "      \"queryShow\": true," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 4," +
                "      \"queryOrder\": 4," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"facilityClassId\"," +
                "      \"name\": \"u8bbeu65bdu7c7bu578b\"," +
                "      \"showName\": \"u8bbeu65bdu7c7bu578b\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"facilityClassName\"," +
                "      \"orderIndex\": 4," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_CODE\"," +
                "        \"parameter\": {" +
                "          \"code\": \"class\"," +
                "          \"data\": [" +
                "            {" +
                "              \"id\": \"1730072588132196353\"," +
                "              \"key\": \"1\"," +
                "              \"value\": \"u96e8u6c34\"," +
                "              \"orderIndex\": 1," +
                "              \"gisIcon\": \"\"," +
                "              \"kanbanIcon\": \"\"" +
                "            }," +
                "            {" +
                "              \"id\": \"1730072588153167874\"," +
                "              \"key\": \"2\"," +
                "              \"value\": \"u6c61u6c34\"," +
                "              \"orderIndex\": 2," +
                "              \"gisIcon\": \"\"," +
                "              \"kanbanIcon\": \"\"" +
                "            }" +
                "          ]," +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REQUIRE\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"," +
                "          \"typeCode\": \"pump_station\"" +
                "        }" +
                "      }," +
                "      \"required\": true," +
                "      \"tableShow\": true," +
                "      \"queryShow\": true," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 5," +
                "      \"queryOrder\": 7," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": true" +
                "    }," +
                "    {" +
                "      \"key\": \"manageUnitId\"," +
                "      \"name\": \"u7ba1u7406u5355u4f4d\"," +
                "      \"showName\": \"u7ba1u7406u5355u4f4d\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"manageUnitName\"," +
                "      \"orderIndex\": 8," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"DEPARTMENT\"," +
                "        \"parameter\": {" +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": true," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 8," +
                "      \"queryOrder\": 8," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": true" +
                "    }," +
                "    {" +
                "      \"key\": \"geometryInfo\"," +
                "      \"name\": \"u8bbeu65bdu4f4du7f6e\"," +
                "      \"showName\": \"u8bbeu65bdu4f4du7f6e\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"geometryInfo\"," +
                "      \"orderIndex\": 11," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"MAP\"," +
                "        \"parameter\": {" +
                "          \"validators\": []," +
                "          \"relatedKey\": \"address\"," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 14," +
                "      \"queryOrder\": 14," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"orderIndex\"," +
                "      \"name\": \"u6392u5e8fu53f7\"," +
                "      \"showName\": \"u6392u5e8fu53f7\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"orderIndex\"," +
                "      \"orderIndex\": 11," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u53eau5141u8bb8u6b63u6574u6570\"," +
                "              \"parameter\": \"NUM_INTEGER_GE_ZERO\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 11," +
                "      \"queryOrder\": 11," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": true" +
                "    }," +
                "    {" +
                "      \"key\": \"address\"," +
                "      \"name\": \"u5730u5740\"," +
                "      \"showName\": \"u5730u5740\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"address\"," +
                "      \"orderIndex\": 12," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 12," +
                "      \"queryOrder\": 12," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"photoIds\"," +
                "      \"name\": \"u7167u7247\"," +
                "      \"showName\": \"u7167u7247\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"photoIds\"," +
                "      \"orderIndex\": 15," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"IMAGE\"," +
                "        \"parameter\": {" +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 15," +
                "      \"queryOrder\": 15," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": true" +
                "    }," +
                "    {" +
                "      \"key\": \"buildDate\"," +
                "      \"name\": \"u5efau8bbeu65e5u671f\"," +
                "      \"showName\": \"u5efau8bbeu65e5u671f\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"buildDate\"," +
                "      \"orderIndex\": 3," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"DATE\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": \"yyyy-MM-dd\"," +
                "              \"name\": \"DATE_FORMAT\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"BETWEEN\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 3," +
                "      \"queryOrder\": 3," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"parentId\"," +
                "      \"name\": \"u7236u7ea7ID\"," +
                "      \"showName\": \"u7236u7ea7u540du79f0\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"parentName\"," +
                "      \"orderIndex\": 4," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_OTHER\"," +
                "        \"parameter\": {" +
                "          \"typeCodes\": \"\"," +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REQUIRE\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"in\"" +
                "        }" +
                "      }," +
                "      \"required\": true," +
                "      \"tableShow\": true," +
                "      \"queryShow\": true," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 6," +
                "      \"queryOrder\": 5," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"enabled\"," +
                "      \"name\": \"u662fu5426u542fu7528\"," +
                "      \"showName\": \"u662fu5426u542fu7528\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"enabledName\"," +
                "      \"orderIndex\": 5," +
                "      \"type\": \"boolean\"," +
                "      \"component\": {" +
                "        \"type\": \"SWITCH\"," +
                "        \"defaultValue\": true," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u8bf7u8f93u5165u662f,u5426\"," +
                "              \"parameter\": [" +
                "                \"u662f\"," +
                "                \"u5426\"" +
                "              ]," +
                "              \"name\": \"BOOLEAN\"" +
                "            }" +
                "          ]," +
                "          \"value\": [" +
                "            \"u662f\"," +
                "            \"u5426\"" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 5," +
                "      \"queryOrder\": 5," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"enableTime\"," +
                "      \"name\": \"u542fu7528u65e5u671f\"," +
                "      \"showName\": \"u542fu7528u65e5u671f\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"enableTime\"," +
                "      \"orderIndex\": 6," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"DATE\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": \"yyyy-MM-dd\"," +
                "              \"name\": \"DATE_FORMAT\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"BETWEEN\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 6," +
                "      \"queryOrder\": 6," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"facilityGradeId\"," +
                "      \"name\": \"u8bbeu65bdu7b49u7ea7\"," +
                "      \"showName\": \"u8bbeu65bdu7b49u7ea7\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"facilityGradeName\"," +
                "      \"orderIndex\": 6," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_CODE\"," +
                "        \"parameter\": {" +
                "          \"code\": \"facilityGrade\"," +
                "          \"data\": []," +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"typeCode\": \"pump_station\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 16," +
                "      \"queryOrder\": 16," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"facilityStatusId\"," +
                "      \"name\": \"u8bbeu65bdu72b6u6001\"," +
                "      \"showName\": \"u8bbeu65bdu72b6u6001\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"facilityStatusName\"," +
                "      \"orderIndex\": 7," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_CODE\"," +
                "        \"parameter\": {" +
                "          \"code\": \"status\"," +
                "          \"data\": []," +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"typeCode\": \"pump_station\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 7," +
                "      \"queryOrder\": 7," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"accUnitId\"," +
                "      \"name\": \"u8d23u4efbu5355u4f4d\"," +
                "      \"showName\": \"u8d23u4efbu5355u4f4d\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"accUnitName\"," +
                "      \"orderIndex\": 9," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"DEPARTMENT\"," +
                "        \"parameter\": {" +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 9," +
                "      \"queryOrder\": 9," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"manageStaffId\"," +
                "      \"name\": \"u8d23u4efbu4eba\"," +
                "      \"showName\": \"u8d23u4efbu4eba\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"manageStaffName\"," +
                "      \"orderIndex\": 10," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"STAFF\"," +
                "        \"parameter\": {" +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 10," +
                "      \"queryOrder\": 10," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"description\"," +
                "      \"name\": \"u63cfu8ff0\"," +
                "      \"showName\": \"u63cfu8ff0\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"description\"," +
                "      \"orderIndex\": 13," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 13," +
                "      \"queryOrder\": 13," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"tenderId\"," +
                "      \"name\": \"u6807u6bb5\"," +
                "      \"showName\": \"u6807u6bb5\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"tenderName\"," +
                "      \"orderIndex\": 16," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TENDER\"," +
                "        \"parameter\": {" +
                "          \"validators\": []," +
                "          \"operator\": \"IN\"," +
                "          \"multiSelect\": true" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 16," +
                "      \"queryOrder\": 16," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"workTypeId\"," +
                "      \"name\": \"u4f5cu4e1au7c7bu578b\"," +
                "      \"showName\": \"u4f5cu4e1au7c7bu578b\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"workTypeName\"," +
                "      \"orderIndex\": 20," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"CODE\"," +
                "        \"parameter\": {" +
                "          \"code\": \"param_jcss_work_type\"," +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": true" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 5," +
                "      \"queryOrder\": 5," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"panoramaLinkAddress\"," +
                "      \"name\": \"u5168u666fu94feu63a5u5730u5740\"," +
                "      \"showName\": \"u5168u666fu94feu63a5u5730u5740\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"panoramaLinkAddress\"," +
                "      \"orderIndex\": 21," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": 3000," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": true," +
                "      \"tableOrder\": 21," +
                "      \"queryOrder\": 21," +
                "      \"fieldType\": \"BASE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"controlModelId\"," +
                "      \"name\": \"u6cf5u623fu63a7u5236u6a21u5f0f\"," +
                "      \"showName\": \"u6cf5u623fu63a7u5236u6a21u5f0f\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"controlModelName\"," +
                "      \"orderIndex\": 22," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"CODE\"," +
                "        \"parameter\": {" +
                "          \"code\": \"controlModel\"," +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 41," +
                "      \"queryOrder\": 41," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"specification\"," +
                "      \"name\": \"u6cf5u7ad9u89c4u683c\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u6cf5u7ad9u89c4u683c\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"specification\"," +
                "      \"orderIndex\": 23," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 7," +
                "      \"queryOrder\": 7," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"gateTypeId\"," +
                "      \"name\": \"u95f8u95e8u7c7bu578b\"," +
                "      \"showName\": \"u95f8u95e8u7c7bu578b\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"gateTypeName\"," +
                "      \"orderIndex\": 24," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"CODE\"," +
                "        \"parameter\": {" +
                "          \"code\": \"param_pump_station_gate_type\"," +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 16," +
                "      \"queryOrder\": 16," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"gateWidth\"," +
                "      \"name\": \"u95f8u95e8u5bbdu5ea6uff08muff09\"," +
                "      \"showName\": \"u95f8u95e8u5bbdu5ea6uff08muff09\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"u95f8u95e8u5bbdu5ea6\"," +
                "      \"orderIndex\": 25," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 10," +
                "      \"queryOrder\": 10," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"gateTopElevation\"," +
                "      \"name\": \"u95f8u9876u9ad8u7a0buff08muff09\"," +
                "      \"showName\": \"u95f8u9876u9ad8u7a0buff08muff09\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"u95f8u9876u9ad8u7a0b\"," +
                "      \"orderIndex\": 26," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 11," +
                "      \"queryOrder\": 11," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"gateBottomElevation\"," +
                "      \"name\": \"u95f8u5e95u9ad8u7a0buff08muff09\"," +
                "      \"showName\": \"u95f8u5e95u9ad8u7a0buff08muff09\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"u95f8u5e95u9ad8u7a0b\"," +
                "      \"orderIndex\": 27," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": \"NUM_POSITIVE_TWO_DECIMAL_PLACES\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 12," +
                "      \"queryOrder\": 12," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"gateHeight\"," +
                "      \"name\": \"u95f8u95e8u9ad8u5ea6uff08muff09\"," +
                "      \"showName\": \"u95f8u95e8u9ad8u5ea6uff08muff09\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"u95f8u95e8u9ad8u5ea6\"," +
                "      \"orderIndex\": 28," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 13," +
                "      \"queryOrder\": 13," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"floorArea\"," +
                "      \"name\": \"u5360u5730u9762u79efuff08u33a1uff09\"," +
                "      \"showName\": \"u5360u5730u9762u79efuff08u33a1uff09\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"u5360u5730u9762u79ef\"," +
                "      \"orderIndex\": 29," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 14," +
                "      \"queryOrder\": 14," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"serviceArea\"," +
                "      \"name\": \"u670du52a1u9762u79efuff08u33a1uff09\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u670du52a1u9762u79efuff08u33a1uff09\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"serviceArea\"," +
                "      \"orderIndex\": 30," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 19," +
                "      \"queryOrder\": 19," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"serviceScope\"," +
                "      \"name\": \"u670du52a1u8303u56f4\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u670du52a1u8303u56f4\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"u670du52a1u8303u56f4\"," +
                "      \"orderIndex\": 31," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 15," +
                "      \"queryOrder\": 15," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"bigTypeId\"," +
                "      \"name\": \"u6cf5u7ad9u7c7bu578b\"," +
                "      \"showName\": \"u6cf5u7ad9u7c7bu578b\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"bigTypeName\"," +
                "      \"orderIndex\": 32," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"CODE\"," +
                "        \"parameter\": {" +
                "          \"code\": \"param_pump_station_big_type\"," +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REQUIRE\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": true," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 4," +
                "      \"queryOrder\": 4," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"smallTypeId\"," +
                "      \"name\": \"u6cf5u7ad9u7c7bu522b\"," +
                "      \"showName\": \"u6cf5u7ad9u7c7bu522b\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"smallTypeName\"," +
                "      \"orderIndex\": 33," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"CODE\"," +
                "        \"parameter\": {" +
                "          \"code\": \"param_pump_station_small_type\"," +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REQUIRE\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": true," +
                "      \"tableShow\": true," +
                "      \"queryShow\": true," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 5," +
                "      \"queryOrder\": 5," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"ownershipUnit\"," +
                "      \"name\": \"u6743u5c5eu5355u4f4d\"," +
                "      \"maxLength\": 20," +
                "      \"showName\": \"u6743u5c5eu5355u4f4d\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"ownershipUnit\"," +
                "      \"orderIndex\": 34," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": true," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 6," +
                "      \"queryOrder\": 6," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"levelId\"," +
                "      \"name\": \"u6cf5u7ad9u7b49u7ea7\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u6cf5u7ad9u7b49u7ea7\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"levelId\"," +
                "      \"orderIndex\": 35," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 25," +
                "      \"queryOrder\": 25," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"areaName\"," +
                "      \"name\": \"u5206u533au540du79f0\"," +
                "      \"maxLength\": 20," +
                "      \"showName\": \"u5206u533au540du79f0\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"areaName\"," +
                "      \"orderIndex\": 36," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"INPUT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": 32," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 34," +
                "      \"queryOrder\": 34," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"upPumpStationsId\"," +
                "      \"name\": \"u4e0au6e38u6cf5u7ad9\"," +
                "      \"showName\": \"u4e0au6e38u6cf5u7ad9\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"upPumpStationsName\"," +
                "      \"orderIndex\": 37," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_OTHER\"," +
                "        \"parameter\": {" +
                "          \"typeList\": [" +
                "            {" +
                "              \"classIds\": \"1730072588132196353,1730072588153167874,1730072588165750786\"," +
                "              \"bringAddress\": false," +
                "              \"repeatBind\": true," +
                "              \"key\": \"pump_station\"" +
                "            }," +
                "            {" +
                "              \"classIds\": \"\"," +
                "              \"bringAddress\": false," +
                "              \"repeatBind\": true," +
                "              \"key\": \"river_pump_station\"" +
                "            }" +
                "          ]," +
                "          \"typeCodes\": \"pump_station,river_pump_station\"," +
                "          \"validators\": []," +
                "          \"selectByMap\": false," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": true" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 35," +
                "      \"queryOrder\": 35," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"downPumpStationsId\"," +
                "      \"name\": \"u4e0bu6e38u6cf5u7ad9\"," +
                "      \"showName\": \"u4e0bu6e38u6cf5u7ad9\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"downPumpStationsName\"," +
                "      \"orderIndex\": 38," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_OTHER\"," +
                "        \"parameter\": {" +
                "          \"typeList\": [" +
                "            {" +
                "              \"classIds\": \"1730072588132196353,1730072588153167874,1730072588165750786\"," +
                "              \"bringAddress\": false," +
                "              \"repeatBind\": true," +
                "              \"key\": \"pump_station\"" +
                "            }," +
                "            {" +
                "              \"classIds\": \"\"," +
                "              \"bringAddress\": false," +
                "              \"repeatBind\": true," +
                "              \"key\": \"river_pump_station\"" +
                "            }" +
                "          ]," +
                "          \"typeCodes\": \"pump_station,river_pump_station\"," +
                "          \"validators\": []," +
                "          \"selectByMap\": false," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": true" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 36," +
                "      \"queryOrder\": 36," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"downSewagePlantId\"," +
                "      \"name\": \"u4e0bu6e38u6c61u6c34u5382\"," +
                "      \"showName\": \"u4e0bu6e38u6c61u6c34u5382\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"downSewagePlantName\"," +
                "      \"orderIndex\": 39," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_OTHER\"," +
                "        \"parameter\": {" +
                "          \"typeList\": [" +
                "            {" +
                "              \"classIds\": \"\"," +
                "              \"bringAddress\": false," +
                "              \"repeatBind\": false," +
                "              \"key\": \"sewage_plant\"" +
                "            }" +
                "          ]," +
                "          \"typeCodes\": \"sewage_plant\"," +
                "          \"validators\": []," +
                "          \"selectByMap\": false," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 37," +
                "      \"queryOrder\": 37," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"groundElevation\"," +
                "      \"name\": \"u5730u9762u9ad8u7a0buff08muff09\"," +
                "      \"showName\": \"u5730u9762u9ad8u7a0buff08muff09\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"groundElevation\"," +
                "      \"orderIndex\": 40," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 38," +
                "      \"queryOrder\": 38," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"regionTypeValue\"," +
                "      \"name\": \"u6240u5c5eu9053u8defu6cb3u9053u7c7bu578b\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u6240u5c5eu9053u8defu6cb3u9053u7c7bu578b\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"regionTypeValue\"," +
                "      \"orderIndex\": 41," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 39," +
                "      \"queryOrder\": 39," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"regionObjectId\"," +
                "      \"name\": \"u6240u5c5eu9053u8defu6cb3u9053u540du79f0\"," +
                "      \"showName\": \"u6240u5c5eu9053u8defu6cb3u9053u540du79f0\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"regionObjectName\"," +
                "      \"orderIndex\": 42," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_OTHER\"," +
                "        \"parameter\": {" +
                "          \"typeList\": [" +
                "            {" +
                "              \"classIds\": \"\"," +
                "              \"bringAddress\": false," +
                "              \"repeatBind\": true," +
                "              \"key\": \"road\"" +
                "            }," +
                "            {" +
                "              \"classIds\": \"\"," +
                "              \"bringAddress\": false," +
                "              \"repeatBind\": true," +
                "              \"key\": \"river\"" +
                "            }" +
                "          ]," +
                "          \"typeCodes\": \"road,river\"," +
                "          \"validators\": []," +
                "          \"selectByMap\": false," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 40," +
                "      \"queryOrder\": 40," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"remark\"," +
                "      \"name\": \"u5907u6ce8\"," +
                "      \"maxLength\": 255," +
                "      \"showName\": \"u5907u6ce8\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"remark\"," +
                "      \"orderIndex\": 43," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 4," +
                "      \"queryOrder\": 4," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"dutyUserName\"," +
                "      \"name\": \"u8d23u4efbu4eba\"," +
                "      \"maxLength\": 300," +
                "      \"showName\": \"u8d23u4efbu4eba\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"dutyUserName\"," +
                "      \"orderIndex\": 44," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 23," +
                "      \"queryOrder\": 23," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"stationTypeId\"," +
                "      \"name\": \"u6cf5u7ad9u5206u7c7b\"," +
                "      \"showName\": \"u6cf5u7ad9u5206u7c7b\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"stationTypeName\"," +
                "      \"orderIndex\": 45," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"CODE\"," +
                "        \"parameter\": {" +
                "          \"code\": \"param_pump_station_type\"," +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": true" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 42," +
                "      \"queryOrder\": 42," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"manageStaffPhone\"," +
                "      \"name\": \"u8d23u4efbu4ebau8054u7cfbu65b9u5f0f\"," +
                "      \"maxLength\": 15," +
                "      \"showName\": \"u8d23u4efbu4ebau8054u7cfbu65b9u5f0f\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"manageStaffPhone\"," +
                "      \"orderIndex\": 46," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"INPUT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": 32," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 43," +
                "      \"queryOrder\": 43," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"districtId\"," +
                "      \"name\": \"u6240u5c5eu7247u533a\"," +
                "      \"showName\": \"u6240u5c5eu7247u533a\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"districtName\"," +
                "      \"orderIndex\": 47," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_OTHER\"," +
                "        \"parameter\": {" +
                "          \"typeList\": [" +
                "            {" +
                "              \"classIds\": \"1670015381667958785,1670015381688930305\"," +
                "              \"bringAddress\": false," +
                "              \"repeatBind\": true," +
                "              \"key\": \"district\"" +
                "            }" +
                "          ]," +
                "          \"typeCodes\": \"district\"," +
                "          \"validators\": []," +
                "          \"selectByMap\": false," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": true," +
                "      \"queryShow\": true," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 20," +
                "      \"queryOrder\": 20," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"2\"," +
                "      \"groupName\": \"u5176u4ed6u4fe1u606f\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"totalRatedFlow\"," +
                "      \"name\": \"u6cf5u7ad9u989du5b9au6d41u91cfuff08mxb3/suff09\"," +
                "      \"showName\": \"u6cf5u7ad9u989du5b9au6d41u91cfuff08mxb3/suff09\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"totalRatedFlow\"," +
                "      \"orderIndex\": 48," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": true," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 43," +
                "      \"queryOrder\": 43," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"hasGateName\"," +
                "      \"name\": \"u6709u65e0u95f8u95e8\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u6709u65e0u95f8u95e8\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"hasGateName\"," +
                "      \"orderIndex\": 49," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"INPUT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": 32," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 44," +
                "      \"queryOrder\": 44," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": true," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"belongFacilityId\"," +
                "      \"name\": \"u6240u5c5eu8bbeu65bd\"," +
                "      \"showName\": \"u6240u5c5eu8bbeu65bd\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"belongFacilityName\"," +
                "      \"orderIndex\": 50," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_OTHER\"," +
                "        \"parameter\": {" +
                "          \"typeCodes\": \"water_company\"," +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 19," +
                "      \"queryOrder\": 19," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"pumpFacilityId\"," +
                "      \"name\": \"u6cf5u7ad9u57fau7840u8bbeu65bd\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u6cf5u7ad9u57fau7840u8bbeu65bd\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"pumpFacilityId\"," +
                "      \"orderIndex\": 51," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 26," +
                "      \"queryOrder\": 26," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"sewageFacilityId\"," +
                "      \"name\": \"u6c61u6c34u5382u57fau7840u8bbeu65bd\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u6c61u6c34u5382u57fau7840u8bbeu65bd\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"sewageFacilityId\"," +
                "      \"orderIndex\": 52," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 27," +
                "      \"queryOrder\": 27," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"areaId\"," +
                "      \"name\": \"u5206u533aID\"," +
                "      \"maxLength\": 20," +
                "      \"showName\": \"u5206u533aID\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"areaId\"," +
                "      \"orderIndex\": 53," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"INPUT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": 32," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 33," +
                "      \"queryOrder\": 33," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"pointId\"," +
                "      \"name\": \"u540cu6b65u7684u7ba1u70b9\"," +
                "      \"showName\": \"u540cu6b65u7684u7ba1u70b9\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"pointName\"," +
                "      \"orderIndex\": 54," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"FACILITY_OTHER\"," +
                "        \"parameter\": {" +
                "          \"typeCodes\": \"point\"," +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 43," +
                "      \"queryOrder\": 43," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"dutyUserId\"," +
                "      \"name\": \"u8d1fu8d23u4eba\"," +
                "      \"showName\": \"u8d1fu8d23u4eba\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"dutyUserName\"," +
                "      \"orderIndex\": 55," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"STAFF\"," +
                "        \"parameter\": {" +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 19," +
                "      \"queryOrder\": 19," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"orgId\"," +
                "      \"name\": \"u7ba1u7406u5355u4f4d\"," +
                "      \"showName\": \"u7ba1u7406u5355u4f4d\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"orgName\"," +
                "      \"orderIndex\": 56," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"DEPARTMENT\"," +
                "        \"parameter\": {" +
                "          \"validators\": []," +
                "          \"operator\": \"EQ\"," +
                "          \"multiSelect\": false" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 18," +
                "      \"queryOrder\": 18," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"facilityLength\"," +
                "      \"name\": \"u8bbeu65bdu957fu5ea6\"," +
                "      \"showName\": \"u8bbeu65bdu957fu5ea6\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"facilityLength\"," +
                "      \"orderIndex\": 57," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": \"NUM_POSITIVE_TWO_DECIMAL_PLACES\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 8," +
                "      \"queryOrder\": 8," +
                "      \"fieldType\": \"TEMPLATE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"facilityWidth\"," +
                "      \"name\": \"u8bbeu65bdu5bbdu5ea6\"," +
                "      \"showName\": \"u8bbeu65bdu5bbdu5ea6\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"facilityWidth\"," +
                "      \"orderIndex\": 58," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": \"NUM_POSITIVE_TWO_DECIMAL_PLACES\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 8," +
                "      \"queryOrder\": 8," +
                "      \"fieldType\": \"TEMPLATE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"facilityArea\"," +
                "      \"name\": \"u8bbeu65bdu9762u79ef\"," +
                "      \"showName\": \"u8bbeu65bdu9762u79ef\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"facilityArea\"," +
                "      \"orderIndex\": 59," +
                "      \"type\": \"number\"," +
                "      \"component\": {" +
                "        \"type\": \"NUMBER\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u9a8cu8bc1u4e0du901au8fc7\"," +
                "              \"parameter\": \"NUM_POSITIVE_TWO_DECIMAL_PLACES\"," +
                "              \"name\": \"REGEX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"EQ\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 9," +
                "      \"queryOrder\": 9," +
                "      \"fieldType\": \"TEMPLATE\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"1\"," +
                "      \"groupName\": \"u8be6u7ec6u53c2u6570\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"riverId\"," +
                "      \"name\": \"u6240u5c5eu6cb3u9053\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u6240u5c5eu6cb3u9053\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"riverId\"," +
                "      \"orderIndex\": 60," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 6," +
                "      \"queryOrder\": 6," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"relationFacilityTypeId\"," +
                "      \"name\": \"u5173u8054u57fau7840u8bbeu65bdu7c7bu578b\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u5173u8054u57fau7840u8bbeu65bdu7c7bu578b\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"relationFacilityTypeId\"," +
                "      \"orderIndex\": 61," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 28," +
                "      \"queryOrder\": 28," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"relationFacilityId\"," +
                "      \"name\": \"u5173u8054u57fau7840u8bbeu65bd\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u5173u8054u57fau7840u8bbeu65bd\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"relationFacilityId\"," +
                "      \"orderIndex\": 62," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 29," +
                "      \"queryOrder\": 29," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"roadId\"," +
                "      \"name\": \"u6240u5c5eu9053u8def\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u6240u5c5eu9053u8def\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"roadId\"," +
                "      \"orderIndex\": 63," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 31," +
                "      \"queryOrder\": 31," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }," +
                "    {" +
                "      \"key\": \"phone\"," +
                "      \"name\": \"u8054u7cfbu65b9u5f0f\"," +
                "      \"maxLength\": 50," +
                "      \"showName\": \"u8054u7cfbu65b9u5f0f\"," +
                "      \"importSampleData\": \"\"," +
                "      \"showKey\": \"phone\"," +
                "      \"orderIndex\": 64," +
                "      \"type\": \"string\"," +
                "      \"component\": {" +
                "        \"type\": \"TEXT\"," +
                "        \"parameter\": {" +
                "          \"validators\": [" +
                "            {" +
                "              \"msg\": \"u5b57u6570u9650u5236300\"," +
                "              \"parameter\": 300," +
                "              \"name\": \"STRING_MAX\"" +
                "            }" +
                "          ]," +
                "          \"operator\": \"LIKE\"" +
                "        }" +
                "      }," +
                "      \"required\": false," +
                "      \"tableShow\": false," +
                "      \"queryShow\": false," +
                "      \"appShow\": false," +
                "      \"tableOrder\": 24," +
                "      \"queryOrder\": 24," +
                "      \"fieldType\": \"CUSTOM\"," +
                "      \"enabled\": false," +
                "      \"disabled\": false," +
                "      \"groupCode\": \"detail\"," +
                "      \"linkedDisplay\": false," +
                "      \"linkedKey\": \"\"," +
                "      \"linkedValues\": []," +
                "      \"defaultValue\": \"\"," +
                "      \"desensitization\": false," +
                "      \"checkRepeat\": false" +
                "    }" +
                "  ]," +
                "  \"mergeDivision\": true," +
                "  \"divisionSearchSwitch\": true," +
                "  \"divisionLevelShowJson\": [" +
                "    {" +
                "      \"name\": \"u884cu653fu533au5212\"," +
                "      \"showName\": \"u884cu653fu533au5212\"," +
                "      \"showList\": true" +
                "    }" +
                "  ]" +
                "}";

        String[] split = s.replaceAll(" ", "").split(":");
        String result = "";
        for (String s1 : split) {
            result += ":";
            if (s1.startsWith("\"u")) {
                // TODO: 2024/12/11 这里还要用,分隔，只有第一个替换
                String replace = s1.replaceAll("u", "mjlu");
                result += replace;

            } else {
                result += s1;
            }

        }
        System.out.println(result);
    }


}
