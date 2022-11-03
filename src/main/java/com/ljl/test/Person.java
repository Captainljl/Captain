package com.ljl.test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author liujialei
 */
public class Person {

    public School getMySchool () throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(10);
        School school = new School();
        school.getPersonSchool(this);
        return school;
    }

    private String name;

    public static void main(String[] args) {
        Person person = new Person();




        person.test();
    }

    public void test() {
        fallback(this::getName);
    }

    private String getName(Integer integer) {
        return name + integer;
    }


    private String fallback(Function<Integer, String> function) {

        return function.apply(1);
    }

}
