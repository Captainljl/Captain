package com.ljl.test;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author liujialei
 */
public class ConsumeTest {

    public static void main(String[] args) {
        ConsumeTest consumeTest = new ConsumeTest();
        consumeTest.test(s -> System.out.println("s = " + s));
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
    }

    public void test(Consumer<String> consumer) {
        consumer.accept("hello world!");
    }


}
