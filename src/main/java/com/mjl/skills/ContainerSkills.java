package com.mjl.skills;

import com.mjl.model.Person;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

/**
 * @author MJL
 * @date 2022/9/6.
 */
public class ContainerSkills {
    public static void main(String[] args) {
        Triple<Integer, String, Person> triple = testTriple();
        System.out.println(triple.getLeft());
        System.out.println(triple.getMiddle());
        System.out.println(triple.getRight());
    }

    static Triple<Integer, String, Person> testTriple() {
        Person p = new Person();
        p.setName("name");
        p.setAge(2);
        return Triple.of(p.getAge(), p.getName(), p);
    }

    static Pair<String, Person> testPair(){
        Person p = new Person();
        p.setName("name");
        p.setAge(2);
        return Pair.of(p.getName(), p);
    }
}

