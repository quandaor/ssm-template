package com.ssm.leetcode.algorithm;

/**
 * @author quandaoran
 * @date 2019-11-06
 * @description
 */
public class Sort {


    /**
     * 冒泡排序
     *
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println();
        }
        return arr;
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static int[] insertSort(int[] arr) {
//        从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素默认有序
        int j;
        for (int i = 1; i < arr.length; i++) {
//            arr[i-1] = 8   arr[i] = 2  temp = 2
//                记录要插入的数据
            int temp = arr[i];

            /**
             * 48～53
             * 实现的是  插入  倒序比较插入 数据
             */
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;

        }
        return arr;
    }


    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static int[] choiceSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static void test(int a, int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
            if (a < arr[i]) {
                int temp = arr[i];

            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 1, 5, 7};
        int[] arr2 = {3, 5, 1};

        int[] ints = choiceSort(arr);

        for (int i : ints) {
            System.out.println(i);
        }


    }
}
