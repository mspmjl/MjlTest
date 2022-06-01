package com.mjl;

import java.io.*;
import java.util.*;

/**
 * @author MJL
 * @date 2022/3/8.
 */
public class YongJia {
    public static void main(String[] args) throws Exception {
        BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\yongjia\\dibang.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\yongjia\\device.txt"));
        BufferedReader reader3 = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\yongjia\\ss.txt"));
        String s1, s2, s3, carCode = null, originalCode = null;
        double latitudeDone = 0, longitudeDone = 0;
        Set<String> carCodeSet = new HashSet<>();
        Map<String, String> map = new HashMap<>(200);
        List<Facility> list = new ArrayList<>();
        while ((s1 = reader1.readLine()) != null) {
            s1 = s1.trim();
            if (s1.startsWith("\"carCode\"")) {
                carCodeSet.add(s1.split("\"")[3]);
            }
        }
        while ((s2 = reader2.readLine()) != null) {
            s2 = s2.trim();
            if (s2.startsWith("\"carCode\"")) {
                carCode = s2.split("\"")[3];
            }
            if (s2.startsWith("\"originalCode\"")) {
                originalCode = s2.split("\"")[3];
            }
            map.put(carCode, originalCode);
        }
        while ((s3 = reader3.readLine()) != null) {
            s3 = s3.trim();
            if (s3.startsWith("\"latitudeDone\"")) {
                latitudeDone = Double.valueOf(s3.substring(s3.indexOf(": ") + 2, s3.length() - 1));
            }
            if (s3.startsWith("\"longitudeDone\"")) {
                longitudeDone = Double.valueOf(s3.substring(s3.indexOf(": ") + 2, s3.length() - 1));
                Facility facility = new Facility(latitudeDone, longitudeDone);
                list.add(facility);
            }
        }
        for (String key : carCodeSet) {
            if (map.containsKey(key)) {
                System.out.println(key + " " + map.get(key));
            }
        }

        System.out.println("==============");

    }

}

