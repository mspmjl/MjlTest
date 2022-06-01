package com.mjl;

import java.math.BigDecimal;

/**
 * @author MJL
 * @date 2021/10/20.
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        System.out.println(BigDecimal.ZERO.compareTo(new BigDecimal("100")));
        System.out.println(BigDecimal.ZERO.compareTo(new BigDecimal("-100")));
    }
}
