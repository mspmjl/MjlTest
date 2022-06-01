package com.mjl;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author MJL
 * @date 2021/9/24.
 */
public class TypeList {
    private List<TypeDTO> list;

    public List<TypeDTO> getList() {
        return list;
    }

    public void setList(List<TypeDTO> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        TypeList typeList = JSON.parseObject("" +
                "{\"list\":[{\"id\":\"b6f34c6590664c5d9e23a13e5bd0b3e4\",\"status\":0,\"createTime\":1617241686000,\"lastChangeTime\":1617241856000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"2\",\"parmName\":\"0.5吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":2,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"4f5d4f983dee484089d4dc2d4b42419c\",\"status\":0,\"createTime\":1617241697000,\"lastChangeTime\":1617241863000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"3\",\"parmName\":\"0.8吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":3,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"e88324f3880c490e898507f3b5e39606\",\"status\":0,\"createTime\":1589268004000,\"lastChangeTime\":1617241872000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"4\",\"parmName\":\"1吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":4,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"b973526b44f24043b12d1df5607aa110\",\"status\":0,\"createTime\":1617241677000,\"lastChangeTime\":1617241883000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"5\",\"parmName\":\"1.5吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":5,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"4b8ee4c2ee3d498290277a179434b239\",\"status\":0,\"createTime\":1617241662000,\"lastChangeTime\":1617241662000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"10\",\"parmName\":\"2吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":10,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"11e24ac029e141afa6ee0239c0f57271\",\"status\":0,\"createTime\":1589268015000,\"lastChangeTime\":1617241845000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"12\",\"parmName\":\"3吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":12,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"3f147ac5ec994c4c9eb17b3ef91b5815\",\"status\":0,\"createTime\":1589268023000,\"lastChangeTime\":1617241835000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"13\",\"parmName\":\"5吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":13,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"bc5a057aced84b37930ed6ba7c11e570\",\"status\":0,\"createTime\":1589268049000,\"lastChangeTime\":1617241830000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"14\",\"parmName\":\"8吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":14,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"80f6252f316444f48de147d0014c25b7\",\"status\":0,\"createTime\":1589268058000,\"lastChangeTime\":1617241822000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"15\",\"parmName\":\"10吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":15,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"a7de8e6ba0a84280a8949bd814114502\",\"status\":0,\"createTime\":1589268067000,\"lastChangeTime\":1617241817000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"16\",\"parmName\":\"12吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":16,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"334cba89a4ba45eab289c95667136659\",\"status\":0,\"createTime\":1586329400000,\"lastChangeTime\":1617241812000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"17\",\"parmName\":\"16吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":17,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"7702913e765849cfa218f399a3acd19b\",\"status\":0,\"createTime\":1589268088000,\"lastChangeTime\":1617241805000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"18\",\"parmName\":\"18吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":18,\"typeCode\":\"param_tonnage_type\"},{\"id\":\"bcdbbfd360ec49cf91682b2b7b460938\",\"status\":0,\"createTime\":1589268103000,\"lastChangeTime\":1617241800000,\"beenDeleted\":0,\"deletedTime\":null,\"tenantId\":\"e54eef276e3c44a9835a96f5daeff232\",\"parmCode\":\"19\",\"parmName\":\"25吨\",\"typeId\":\"d57e230687c640619c3f5d8a37422f28\",\"orderIndex\":19,\"typeCode\":\"param_tonnage_type\"}]}"
                +"", TypeList.class);
        typeList.getList().forEach(t -> {
            System.out.println(t.getParmName());
        });
        System.out.println(~2);
    }
}
