package com.ssm.leetcode.thread;

/**
 * @author quandaoran
 * @date 2019-10-29
 * @description
 */
public class Test {


    public void test1() {

    }

    public void test2() {

    }

    public static void main(String[] args) {
        retry:
        for (; ; ) {
            System.out.println("11");
            for (int i = 0; i < 10; i++) {
                System.out.println("22");
                if (i == 9)
                    break retry;
            }
            System.out.println("33");
        }
    }
}
