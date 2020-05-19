package com.ssm.leetcode.thread;

/**
 * @author quandaoran
 * @date 2019-10-16
 * @description 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Foo {

    public Foo() {

    }

    private boolean first = false;

    private boolean second = false;

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (this) {
            first = true;
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (this) {
            while (!first) {
                this.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            second = true;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {


        synchronized (this) {
            while (!second) {
                this.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Foo foo = new Foo();

        Thread A = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread C = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        A.start();
        B.start();
        C.start();


    }
}

