package com.ssm.leetcode.l_0217;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author quandaoran
 * @date 2020-02-17
 * @description 1. 补充如下程序通过N个线程顺序循环打印从0至100，如给定N=3则输出：
 * thread0: 0
 * thread1: 1
 * thread2: 2
 * thread0: 3
 * thread1: 4 」
 */
public class AliCode {


    public void threadPrintNumber(int n) throws InterruptedException {


        Thread[] threads = new Thread[3];

        final Semaphore[] syncObjects = new Semaphore[n];

        for (int i = 0; i < n; i++) {
            syncObjects[i] = new Semaphore(1);

            if (i != n - 1) {
                syncObjects[i].acquire();
            }
        }

        for (int i = 0; i < n; i++) {

        }

        Semaphore semaphore = new Semaphore(n);

    }


    static int result = 0;

    public static void orderPrintNum(final int n) {
        final boolean[] printFlag = new boolean[n];
        for (int i = 0; i < n; i++) {
            final int index = i;
            if (0 == i) {
                printFlag[index] = true;
            }
            new Thread(() -> {
                try {
                    while (result <= 100) {
                        if (printFlag[index]) {
                            System.out.println("thread" + index + ": " + result++);
                            printFlag[index] = false;
                            if (index == (n - 1)) {
                                printFlag[0] = true;
                            } else {
                                printFlag[index + 1] = true;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }

    public static void main(String[] args) {
//        orderPrintNum(5);


        List<Integer> a = Lists.newArrayList();
        Integer integer = a.stream().reduce((aa, b) -> aa + b).get();
        System.out.println(integer);


    }


    public void notifyPrint(int n) {

//        线程的打印状态
        boolean[] booleans = new boolean[n];


    }
}
