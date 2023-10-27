package com.mjl;

import com.mjl.model.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author MJL
 * @date 2021/11/3.
 */
public class ReflectDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person p = new Person();
        Class<? extends Person> aClass = p.getClass();
        Method setName = aClass.getMethod("setName", String.class);
        setName.invoke(p, "jiale");
        System.out.println(p);
        Method getName = aClass.getMethod("getName");
        String invoke = (String) getName.invoke(p);
        System.out.println(invoke);

    }
}
