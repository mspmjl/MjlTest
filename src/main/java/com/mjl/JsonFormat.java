package com.mjl;

import com.fasterxml.jackson.databind.JavaType;
import com.mjl.util.JsonMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MJL
 * @date 2022/6/7.
 */
public class JsonFormat {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\staff.txt"));
        StringBuffer sb = new StringBuffer();
        String line="";
        while ((line=br.readLine()) != null) {
            sb.append(line);
        }
        JsonMapper mapper = new JsonMapper();
        JavaType javaType = mapper.contructCollectionType(ArrayList.class, StaffDTO.class);
        List<StaffDTO> list = mapper.fromJson(sb.toString(), javaType);
        String s = "";
        for (StaffDTO staffDTO : list) {
            s += "'" + staffDTO.getShiftObjId() + "',";
        }
        System.out.println(s);
        br.close();
    }
}
