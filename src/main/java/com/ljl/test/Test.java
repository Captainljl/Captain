package com.ljl.test;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        int start = 1000000;
        while (start -- > 0) {
            TimeUnit.MILLISECONDS.sleep(10);
            test.test(new Person());
        }
    }


    public void test(Person person) throws InterruptedException {
        System.out.println("这边是测试方法，可以看到");
        person.getMySchool();
    }

}
