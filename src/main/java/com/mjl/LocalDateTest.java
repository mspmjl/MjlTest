package com.mjl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author MJL
 * @date 2021/8/11.
 */
public class LocalDateTest {
    public static void main(String[] args) {

        System.out.println(LocalDate.now().getMonthValue());
        System.out.println(LocalDate.now().getYear());
        System.out.println(DateUtil.daysBetween(DateUtil.parseDate("2023-01-01"),DateUtil.parseDate("2023-01-10")));
//        ZoneId zone = ZoneId.systemDefault();
//        Date changeDate = Date.from(localDate.atStartOfDay().atZone(zone).toInstant());

//        Date start = Date.from(LocalDate.parse("2022-02-29", DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        Date end = Date.from(LocalDate.parse("2022-02-29", DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        LocalDate start = LocalDate.parse("2023-01-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate end = LocalDate.parse("2023-02-23", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        for (long l = start.toEpochDay(); l <= end.toEpochDay(); l++) {
//            LocalDate localDate = LocalDate.ofEpochDay(l);
//            System.out.println(localDate);
//        }


        LocalDate start = LocalDate.parse("2023-02" + "-01", DateTimeFormatter.ofPattern(DateUtil.DATE_FORMAT));
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
        System.out.println(end);
        System.out.println(end.plusYears(-1));
        System.out.println(end.plusMonths(-1));
//        CharSequence text;
//        DateTimeFormatter formatter;
//        LocalDate localDate1 = LocalDate.parse("2022-12-24", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate localDate2= LocalDate.parse("2021-10-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate localDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        System.out.println(localDate1.compareTo(LocalDate.now()));
//        System.out.println(localDate1.toEpochDay()-localDate2.toEpochDay());
//        LocalDate localDate = LocalDate.now();
//        LocalDate localDate2 = localDate.withYear(2400).withMonth(2);
//        System.out.println(localDate2.lengthOfMonth());
//        LocalDate yesterday = LocalDate.now().plusDays(-1);
//        System.out.println(yesterday);
//        System.out.println(yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        LocalDate yesterdayLocalDate = LocalDate.parse("2022-01-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDate = yesterdayLocalDate.withDayOfMonth(yesterdayLocalDate.lengthOfMonth());
        System.out.println(localDate);
        LocalDate localDate2 = yesterdayLocalDate.withDayOfMonth(1);
        System.out.println(localDate2);
        System.out.println(localDate2.plusDays(-1));

    }
}
