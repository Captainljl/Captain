package com.ljl.test;

import java.util.concurrent.TimeUnit;

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

}
