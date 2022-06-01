package com.mjl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MJL
 * @date 2021/7/15.
 */
public class StreamTest {
    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        var personList = streamTest.getPersonList();
        // group by
        Map<Integer, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        // map
        List<Integer> collect1 = personList.stream().map(Person::getAge).collect(Collectors.toList());
//        String collect = deptFeignDTOS.stream().map(d -> d.getDepartmentId()).collect(Collectors.joining(","));
        // filter 过滤
//        personList.stream().filter(p -> p.getAge() > 30).forEach(System.out::println);
        // peek 将元素挑选出来，可以理解为提前消费
//        personList.stream().peek(p->p.setName(p.getName()+p.getAge())).forEach(System.out::println);
        // sorted
//        personList.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
        // count
//        System.out.println(personList.stream().filter(p -> p.getAge() > 40).count());
        // noneMatch(有的话返回false) AllMatch(所有满足返回true) anyMatch (有的话返回true)
//        System.out.println(personList.stream().allMatch(p -> p.getAge() > 1));
        // reduce
//        System.out.println(personList.stream().reduce((p1, p2) -> new Person("test", p1.getAge() + p2.getAge(), "test")).get());
//
//        personList.stream().collect(Collectors.toMap(Person::getAge, Person::getGender, (o1, o2) -> o1, HashMap::new));
//
//        System.out.println(personList.stream().reduce((a, b) -> a.getAge() > b.getAge() ? a : b).get());
//
//        new Thread(() -> {
//
//        }).start();

    }

    public List<Person> getPersonList() {
        return Stream.of(new Person("Tom1", 11, "M"), new Person("Tom2", 21, "M"), new Person("Tom3", 31, "M")
                , new Person("Jack2", 12, "M"), new Person("Jack2", 13, "M"), new Person("Jack1", 14, "M")
                , new Person("Lucy1", 14, "F"), new Person("Lucy2", 24, "F"), new Person("Lucy3", 44, "F")
                , new Person("James1", 44, "M"), new Person("James2", 33, "M"), new Person("James3", 22, "M"))
                .collect(Collectors.toList());
    }
}
