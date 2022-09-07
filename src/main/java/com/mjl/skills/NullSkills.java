package com.mjl.skills;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author MJL
 * @date 2022/9/6.
 */
public class NullSkills {
    public static void main(String[] ags) {
        System.out.println(testNullAble(null));
        System.out.println(testNullAble2(new BigDecimal(222)));
    }

    static BigDecimal testNullAble(BigDecimal bigDecimal) {
        return Optional.ofNullable(bigDecimal).orElse(BigDecimal.ZERO);
    }

    static BigDecimal testNullAble2(BigDecimal bigDecimal) {
        return Optional.ofNullable(bigDecimal).filter(b -> b.compareTo(new BigDecimal(1000)) <= 0).orElse(BigDecimal.ZERO);
    }
}
