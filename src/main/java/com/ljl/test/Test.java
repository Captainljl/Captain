package com.ljl.test;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("userName", "liujialei");

        System.out.println(hashMap.getClass());
        System.out.println(new Gson().toJson(hashMap));
        System.out.println(JSON.toJSONString(hashMap));
    }


    public void test(Person person) throws InterruptedException {
        System.out.println("这边是测试方法，可以看到");
        person.getMySchool();
    }

}
