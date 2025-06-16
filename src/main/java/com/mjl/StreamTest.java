package com.mjl;

import com.alibaba.fastjson.JSON;
import com.mjl.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author MJL
 * @date 2021/7/15.
 */
public class StreamTest {
    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        var personList = Person.getPersonList();
        List<Person> nullTest = new ArrayList<>();
        long count = nullTest.stream().filter(a -> a.getAge() > 10).count();
        System.out.println(count);

        Map<String, Person> collect = personList.stream().filter(o -> "123321".equals(o.getName())).collect(Collectors.toMap(Person::getName, Function.identity()));
        System.out.println(JSON.toJSONString(collect));
        Person person = null;
        int sum = Optional.ofNullable(person).map(Person::getAge).stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        Integer integer = Optional.ofNullable(person).map(Person::getAge).get();
        System.out.println(integer);

//        personList = personList.stream().filter(p -> p.getAge() != null).collect(Collectors.toList());
//        personList.sort((p1, p2) -> -p1.getAge().compareTo(p2.getAge()));
//        System.out.println(personList);
//        Map<Date, List<Person>> collect = personList.stream().filter(p -> p.getDate() != null).collect(Collectors.groupingBy(Person::getDate));
//        Set<String> collect1 = personList.stream().filter(p -> p.getAge() > 100).map(Person::getName).collect(Collectors.toSet());
//        Person person = personList.stream().filter(s -> s.getAge() > 100).sorted(Comparator.comparing(Person::getAge)).findFirst().orElse(null);
//        System.out.println(person);
//        System.out.println(personList.stream().anyMatch(a->"Tom111".equals(a.getName())));
//        personList.addAll(new ArrayList<>());
//        System.out.println(personList);
//        personList.sort(Comparator.comparing(Person::getAge));
//        System.out.println(personList);
//        personList.sort(Comparator.comparing(Person::getAge).reversed());
//        System.out.println(personList);
//        personList.sort((o1, o2) -> o2.getAge() - o1.getAge());

//        personList.forEach(person -> System.out.println(person));
        // group by
//        Map<Integer, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        // map
//        List<Integer> collect1 = personList.stream().map(Person::getAge).collect(Collectors.toList());
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


}
