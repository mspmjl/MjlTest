package com.mjl.skills;

import java.util.*;

/**
 * @author MJL
 * @date 2022/9/6.
 */
public class MapSkills {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
//        map.put("1", Arrays.asList("5"));
        map.computeIfAbsent("1", key -> new ArrayList<>()).add("3");
        map.computeIfAbsent("1", key -> new ArrayList<>()).add("4");
        System.out.println(map);
        String s = "68.86%";

        System.out.println(  s.substring(0, s.length() - 1));
    }

}
