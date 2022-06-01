package com.mjl;

import java.util.Locale;
import java.util.UUID;

/**
 * @author MJL
 * @date 2021/12/24.
 */
public class RandomCode {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().substring(0, 4).toUpperCase(Locale.ROOT) + System.currentTimeMillis());
    }
}
