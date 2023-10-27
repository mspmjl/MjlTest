package com.mjl;

import com.mjl.model.Person;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author MJL
 * @date 2023/2/13.
 */
public class ClassDemo {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person();
        person.setAge(1);
        Field[] allFields = Person.class.getDeclaredFields();
        Person c = Person.class.newInstance();
        for (Field field : allFields){
            String attributeName = field.getName();
            Method m = person.getClass().getMethod("get" + firstUpperCase(attributeName));
            System.out.println( m.invoke(person));
        }
    }

    public static String firstUpperCase(String str) {
        return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }
}
