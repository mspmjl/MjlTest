package com.mjl;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * @author MJL
 * @date 2021/8/30.
 */
public class PatternTest {
    private static final Pattern COMPILE = Pattern.compile("^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{1,2})?$");

    public static void main(String[] args) {
//        System.out.println(COMPILE.matcher("2222.222").matches());
//        System.out.println(Double.valueOf("2222.20").toString());
//        System.out.println(COMPILE.matcher(Double.valueOf("2222.20").toString()).matches());
//        System.out.println(new BigDecimal("4").scale());
        System.out.println(65.56*11);
    }
}
