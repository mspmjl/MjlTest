package com.mjl.skills;

import java.util.*;

/**
 * @author MJL
 * @date 2022/9/6.
 */
public class MapSkills {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1", Arrays.asList("1"));
        // 返回的是value
        map.computeIfAbsent("1", key -> new ArrayList<>()).add("2");
        System.out.println(map);
    }

}
