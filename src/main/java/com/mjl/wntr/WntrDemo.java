package com.mjl.wntr;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author mjl
 * @date 2025/3/25.
 */
public class WntrDemo {
    public static void main(String[] args) throws IOException {
//        ProcessBuilder processBuilder = new ProcessBuilder(pythonPath, inpPath);
//
//        processBuilder.redirectErrorStream(true);
//
//        // 启动进程
//        Process process = processBuilder.start();
//
//        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
//
//        BufferedReader reader = new BufferedReader(inputStreamReader);
//        StringBuilder nodeInfo = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            nodeInfo.append(line);
//        }
//        nodeInfo.setLength(0);


        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\wntr\\node_pressure.json"));

        StringBuilder nodeInfo = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            nodeInfo.append(line);
        }
        String str = nodeInfo.toString().replaceAll("\\\\n", "");
        List<PressuresResultDTO> pressures = JSONArray.parseArray(str, PressuresResultDTO.class);

        for (PressuresResultDTO pressure : pressures) {
            String pressureStr = pressure.getChildren();
            List<PressuresDTO> pressureList = JSONArray.parseArray(pressureStr, PressuresDTO.class);
            if (CollectionUtil.isNotEmpty(pressureList)) {

            }
        }
        System.out.println();
    }
}
