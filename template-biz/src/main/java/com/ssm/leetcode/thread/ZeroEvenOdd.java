package com.ssm.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author quandaoran
 * @date 2019-10-17
 * @description 假设有这么一个类：
 * <p>
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * <p>
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出："0102030405"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZeroEvenOdd {

    private int n;

    private ReentrantLock lock = new ReentrantLock();

    private volatile String flag = "zero";

    private volatile boolean even = false;


    private Condition zeroLock = lock.newCondition();

    private Condition evenLock = lock.newCondition();

    private Condition oddLock = lock.newCondition();


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    /**
     * // TODO: 2019-10-17 0
     *
     * @param printNumber
     * @throws InterruptedException
     */
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "_falg:" + flag);
                while (!flag.equals("zero")) {
                    System.out.println(Thread.currentThread().getName() + "==flag:" + flag + "   i=" + i);
                    zeroLock.await();
                }
                printNumber.accept(0);
                flag = "even";
                evenLock.signal();
                oddLock.signal();
            } catch (InterruptedException e) {
//
            } finally {
                lock.unlock();
            }
        }
    }


    /**
     * // TODO: 2019-10-17 1
     *
     * @param printNumber
     * @throws InterruptedException
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i < n; i += 2) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "_falg:" + flag);
                while (!flag.equals("even")) {
                    System.out.println(Thread.currentThread().getName() + "==flag:" + flag + "   i:" + i);
                    evenLock.await();
                }

                printNumber.accept(i);
                flag = "zero";
                oddLock.signal();
                zeroLock.signal();
            } catch (InterruptedException e) {
//
            } finally {
                lock.unlock();

            }
        }
    }

    /**
     * // TODO: 2019-10-17 2
     *
     * @param printNumber
     * @throws InterruptedException
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i < n; i += 2) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "_falg:" + flag);
                while (!flag.equals("odd")) {
                    System.out.println(Thread.currentThread().getName() + "==flag:" + flag + "   i:" + i);
                    oddLock.await();
                }
                printNumber.accept(i);
                flag = "zero";
                zeroLock.signalAll();
                evenLock.signal();
            } catch (InterruptedException e) {
//
            } finally {
                lock.unlock();

            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
        IntConsumer consumer = (x) -> System.out.println("======打印=======" + x);
        Thread a = new Thread(() -> {
            try {
                zeroEvenOdd.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程零");

        Thread b = new Thread(() -> {
            try {
                zeroEvenOdd.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程奇数");

        Thread c = new Thread(() -> {
            try {
                zeroEvenOdd.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程偶数");

        a.start();
        b.start();
        c.start();
    }


}
