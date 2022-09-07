package com.mjl;

import java.io.IOException;

/**
 * @author MJL
 * @date 2021/12/8.
 */
public class TT {
    public static void main(String[] args) throws IOException {
        System.out.println(getOneFromZeroOrNull(0));
        System.out.println(getOneFromZeroOrNull(null));
        System.out.println(getOneFromZeroOrNull(3));
    }

    public static Integer getOneFromZeroOrNull(Integer integer) {
        return (integer == null || integer.compareTo(0) == 0) ? Integer.valueOf(1) : integer;
    }
}
