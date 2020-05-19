package com.ssm.leetcode.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.function.Consumer;

/**
 * @Author quandaoran3
 * @Date 2019-11-29 11:36
 * @Description 将fork/join封装起来  无返回值
 */


public class ForkJoinWrapperAction<T> extends RecursiveAction {
    /**
     * 源数据
     */
    private List<T> list;
    /**
     * 每次处理的阈值
     */
    private int threshold;
    /**
     * 起始
     */
    private int start;
    /**
     * 结束
     */
    private int end;
    /**
     * 将处理的业务的函数传入
     */
    private Consumer<List<T>> consumer;

    protected ForkJoinWrapperAction(List<T> list, int threslod, Consumer<List<T>> consumer) {
        this.list = list;
        this.end = list.size();
        this.threshold = threslod;
        this.consumer = consumer;
    }


    private ForkJoinWrapperAction(List<T> list, int threslod, int start, int end, Consumer<List<T>> consumer) {
        this.list = list;
        this.threshold = threslod;
        this.start = start;
        this.end = end;
        this.consumer = consumer;
    }

    @Override
    protected void compute() {

        if (canCompute(start, end)) {
//              直接计算
            consumer.accept(list);

            return;
        }

        int middle = start + end / 2;

        List<T> son = Lists.newArrayList(list.subList(start, middle));

        List<T> daughter = Lists.newArrayList(list.subList(middle, end));

        ForkJoinWrapperAction sonTask = new ForkJoinWrapperAction<T>(son, start, middle, threshold, consumer);

        ForkJoinWrapperAction daughterTask = new ForkJoinWrapperAction<T>(daughter, middle, end, threshold, consumer);

        invokeAll(sonTask, daughterTask);

    }

    private boolean canCompute(int start, int end) {
        return end - start <= threshold;
    }

    public static void main(String[] args) {
        retry:
        for (; ; ) {
            System.out.println("11");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 9)
                    continue retry;
            }
            System.out.println("33");
        }
    }

}