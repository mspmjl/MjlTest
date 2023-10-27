package com.mjl;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * @author MJL
 * @date 2021/12/8.
 */
@Transactional(rollbackFor = Exception.class)
public class TT {
    public static void main(String[] args) throws Exception {
        LocalDate now = LocalDate.now();
        LocalDate end = now.withDayOfMonth(now.lengthOfMonth());
        LocalDate start = end.plusMonths(-11).withDayOfMonth(1);
        System.out.println(start);
        System.out.println(end);
        LocalDate localDate = end.plusMonths(-11);
        do {
            System.out.println(localDate);
            localDate = localDate.plusMonths(1);
        } while (localDate.toEpochDay() <= end.toEpochDay());
    }
}
