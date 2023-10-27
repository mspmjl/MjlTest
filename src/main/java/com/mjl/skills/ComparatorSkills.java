package com.mjl.skills;

import com.mjl.model.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author MJL
 * @date 2023/4/19.
 */
public class ComparatorSkills {
    public static void main(String[] args) {
        List<Person> personList = Person.getPersonList();
        Collections.sort(personList, (o1, o2) -> 0);

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getName().equals(o2.getName())){
                    return o1.getAge() - o2.getAge();
                }else {
                    return o1.getName().compareTo(o2.getName());

                }
            }
        });
        personList.sort((o1, o2) -> 0);

    }

}
