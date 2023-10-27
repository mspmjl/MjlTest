package com.mjl.model;

import com.mjl.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MJL
 * @date 2021/7/15.
 */
public class Person {
    private String name;
    private Integer age;
    private String gender;
    private Date date;

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, Integer age, String gender, Date date) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.date = date;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static List<Person> getPersonList() {
        return Stream.of(new Person("Tom1", 12, "M"), new Person("Tom2", 21, "M"), new Person("Tom3", 31, "M")
                , new Person("Jack2", 12, "M"), new Person("Jack2", 13, "M"), new Person("Jack1", 14, "M")
                , new Person("Lucy1", 14, "F"), new Person("Lucy2", 24, "F"), new Person("Lucy3", 44, "F")
                , new Person("James1", 44, "M", DateUtil.parse("2022-07-18", DateUtil.DATE_FORMAT)), new Person("James2", 33, "M", DateUtil.parse("2022-07-18", DateUtil.DATE_FORMAT)), new Person("James3", 22, "M", DateUtil.parse("2022-07-19", DateUtil.DATE_FORMAT)))
                .collect(Collectors.toList());
    }
}
