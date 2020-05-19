package com.ssm.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @author quandaoran
 * @date 2019-10-23
 * @description
 */
public class SemaphoreTest {

    //
    static final Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException {
//        运行三个线程执行
//        即提供公平也提供非公平方法
//        获取信号量
        semaphore.acquire();
        System.out.println();


    }


}
