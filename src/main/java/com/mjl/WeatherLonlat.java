package com.mjl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author MJL
 * @date 2021/12/8.
 */
@Transactional(rollbackFor = Exception.class)
public class WeatherLonlat {
    public static void main(String[] args) throws Exception {
        Double lonStart = 104.0;
        Double lonEnd = 112.0;
        Double latStart = 27.0;
        Double latEnd = 33.0;

        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        int x = 0;
//        for (Double lon = lonStart; lon <= lonEnd; lon += 0.01) {
//            int y = 0;
//            for (Double lat = latStart; lat <= latEnd; lat += 0.01) {
//                Map<String, Integer> mapSub = new LinkedHashMap<>();
//                mapSub.put("x", x);
//                mapSub.put("y", y);
//                map.put(CalUtil.round(lon, 2) + "," + CalUtil.round(lat, 2), mapSub);
//                y++;
//            }
//            x++;
//        }
        for (Double lon = lonStart; lon <= 104.2; lon += 0.01) {
            int y = 0;
            for (Double lat = latStart; lat <= 27.2; lat += 0.01) {
                Map<String, Integer> mapSub = new LinkedHashMap<>();
                mapSub.put("x", x);
                mapSub.put("y", y);
                map.put(CalUtil.round(lon, 2) + "," + CalUtil.round(lat, 2), mapSub);
                y++;
            }
            x++;
        }
        File txt = new File("C:\\Users\\DELL\\Desktop\\vortexdto\\lonlat.txt");
        FileWriter writer = new FileWriter(txt);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(JSONObject.toJSONString(map));
        System.out.println(JSONObject.toJSONString(map));
    }
}
