package com.ssm.leetcode.thread;

/**
 * @author quandaoran
 * @date 2019-10-16
 * @description
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar2 {
    private int n;
    private boolean fooFlag;
    private boolean barFlag;
    private Lock lock;
    private Condition fooCondition;
    private Condition barCondition;

    public FooBar2(int n) {
        this.n = n;
        this.fooFlag = false;
        this.barFlag = true;
        this.lock = new ReentrantLock();
        this.fooCondition = lock.newCondition();
        this.barCondition = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();

            try {
                while (fooFlag) {
                    fooCondition.await();
                }

                /**
                 * printFoo.run() outputs "foo". Do not change or remove this line.
                 */
                printFoo.run();
                fooFlag = true;
                barFlag = false;
                barCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();

            try {
                while (barFlag) {
                    barCondition.await();
                }

                /**
                 * printBar.run() outputs "bar". Do not change or remove this line.
                 */
                printBar.run();
                barFlag = true;
                fooFlag = false;
                fooCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
