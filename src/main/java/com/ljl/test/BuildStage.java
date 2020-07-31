package com.ljl.test;

/**
 * 打包阶段
 * Create by lipengxiang1<lipengxiang1@xiaomi.com>
 **/
public enum BuildStage {
    START(0), // 开始
    NORMAL(1),
    ROOT(2),
    CTS(3),
    TEST(4),
    STS(5),
    FINAL(9); // 结束

    private Integer value;

    BuildStage(Integer v) {
        this.value = v;
    }

    public Integer value() {
        return value;
    }


    public static BuildStage parseByKey(String key) {
        for (BuildStage p : BuildStage.values()) {
            if (p.name().equalsIgnoreCase(key)) {
                return p;
            }
        }
        return null;
    }
}
