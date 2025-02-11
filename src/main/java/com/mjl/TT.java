package com.mjl;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author MJL
 * @date 2021/12/8.
 */
@Transactional(rollbackFor = Exception.class)
public class TT {
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.valueOf("01"));

    }


}
