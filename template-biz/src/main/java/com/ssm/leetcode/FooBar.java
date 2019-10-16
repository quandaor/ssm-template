package com.ssm.leetcode;

/**
 * @author quandaoran
 * @date 2019-10-16
 * @description
 */
public class FooBar {

    private int n;

    private boolean flag = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (this) {
//                执行的时候保证flag  = false
                while (!flag) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = true;
                    this.notifyAll();
                }
                this.wait();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
//                执行的时候保证flag  = true
                while (!flag) {
                    this.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = false;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        Thread foo = new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread bar = new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        foo.start();
        bar.start();
    }


    /**
     *
     *   执行效率最优解
     * import java.util.concurrent.atomic.AtomicInteger;
     * class FooBar {
     *     private int n;
     *     private volatile boolean f = true;
     *
     * 	private java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);
     *
     *     public FooBar(int n) {
     *         this.n = n;
     *     }
     *
     *     public void foo(Runnable printFoo) throws InterruptedException {
     *
     *         for (int i = 0; i < n; i++) {
     *             while(!f){
     *                 Thread.yield();
     *             }
     *         	// printFoo.run() outputs "foo". Do not change or remove this line.
     *         	printFoo.run();
     *             f = !f;
     *         }
     *     }
     *
     *     public void bar(Runnable printBar) throws InterruptedException {
     *
     *         for (int i = 0; i < n; i++) {
     *             while(f){
     *                 Thread.yield();
     *             }
     *             // printBar.run() outputs "bar". Do not change or remove this line.
     *         	printBar.run();
     *             f = !f;
     *         }
     *     }
     * }
     */

}
