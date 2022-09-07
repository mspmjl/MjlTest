package com.mjl.skills;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MJL
 * @date 2022/9/6.
 */
public class SetSkills {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        System.out.println(set.add("1"));
    }
}
