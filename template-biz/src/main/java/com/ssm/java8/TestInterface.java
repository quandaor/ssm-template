package com.ssm.java8;

import java.util.Optional;

/**
 * @author quandaoran
 * @date 2019-09-02
 * @description
 */
public interface TestInterface {
    /**
     * 默认方法
     */
    default void test() {
        System.out.println("默认方法");
    }

    public String name = "1";

    /**
     * 静态方法
     */
    static void testStatic() {
        Optional<String> name = Optional.ofNullable(TestInterface.name);
        String s = name.orElse("123");
        System.out.println(s);
    }

    public static void main(String[] args) {
        TestInterface.testStatic();
    }
}
