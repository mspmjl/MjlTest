package com.mjl.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mjl
 * @date 2025/9/19.
 * https://swsyb.cloudhw.cn:8446/cloud/device/realtime/monitor/data/realtimeFactorValueList?collectFrequency=realtime
 */
public class EasyExcelDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\武汉关谷ai\\realtime.txt"));
        String s;
        StringBuffer sb = new StringBuffer();
        while ((s = reader.readLine()) != null) {
            s = s.trim();
            sb.append(s);
        }
        List<ExcelReadDTO> excelReadDTOS = JSON.parseArray(sb.toString(), ExcelReadDTO.class);
        List<List<String>> headers = new LinkedList<>();
        headers.add(Lists.newArrayList("设备编号"));
        headers.add(Lists.newArrayList("设备名称"));
        headers.add(Lists.newArrayList("监测项目"));
        headers.add(Lists.newArrayList("监测因子名称"));
        headers.add(Lists.newArrayList("统计类型"));
        headers.add(Lists.newArrayList("统计周期"));
        headers.add(Lists.newArrayList("单位"));
        headers.add(Lists.newArrayList("当前值"));
        headers.add(Lists.newArrayList("数据更新时间"));
        List<List<Object>> data = new LinkedList<>();

        for (ExcelReadDTO excelReadDTO : excelReadDTOS) {
            data.add(Lists.newArrayList(excelReadDTO.getDeviceId(), excelReadDTO.getDeviceName(), excelReadDTO.getMonitorItemName(), excelReadDTO.getFactorName(),
                    excelReadDTO.getCollectTypeName(), excelReadDTO.getCollectFrequencyName(), excelReadDTO.getUnit(), excelReadDTO.getFormatValue(), excelReadDTO.getTimeDesc()));
        }
        EasyExcel.write(new File("C:\\Users\\DELL\\Desktop\\武汉关谷ai\\实时.xlsx"))
                .head(headers)
                .sheet("安全费用汇总")
                .doWrite(data);
    }
}
