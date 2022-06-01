package com.mjl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author MJL
 * @date 2021/8/11.
 */
public class LocalDateTest {
    public static void main(String[] args) {

        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
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
//
//
//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.DATE, 23);
//        long quot = 0;
//
//        Date date1 = new Date();
//
//        quot = date1.getTime() - calendar.getTime().getTime();
//        quot = quot / 1000 / 60 / 60 / 24;
//
//        System.out.println(Math.abs(quot));

//        List<String> monthList = new ArrayList<>();
//
//        LocalDateTime startDate = LocalDateTime.now();
//        startDate =startDate.withDayOfMonth(1).withMonth(1);
//        LocalDateTime endDate = LocalDateTime.now();
//        Assert.isTrue(startDate.getYear() == endDate.getYear(), "不可跨年");
//        do {
//            System.out.println(startDate.getMonthValue() + " " + endDate.getMonthValue());
//            monthList.add(startDate.toString());
//            startDate = startDate.plusMonths(1);
//        } while (startDate.getMonthValue() <= endDate.getMonthValue());
    }
}
