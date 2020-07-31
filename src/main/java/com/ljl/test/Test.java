package com.ljl.test;

public class Test {

    public static void main(String[] args) {
        BuildStage stage = BuildStage.parseByKey("START");
        System.out.println(BuildStage.START.equals(stage));
    }

}
