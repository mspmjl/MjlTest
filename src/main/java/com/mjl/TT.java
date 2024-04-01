package com.mjl;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author MJL
 * @date 2021/12/8.
 */
@Transactional(rollbackFor = Exception.class)
public class TT {
    public static void main(String[] args) throws Exception {
        Date date1 = DateUtil.parse("2024-02-19 09:00:11", DateUtil.DATETIME_FORMAT);
        Date date2 = DateUtil.parse("2024-02-19 10:00:00", DateUtil.DATETIME_FORMAT);
        int i = (int) (date1.getTime() - date2.getTime()) / (1000 * 60);
        System.out.println(i);

    }
}
