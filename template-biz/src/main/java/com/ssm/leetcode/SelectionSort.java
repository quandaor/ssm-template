package com.ssm.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author quandaoran
 * @date 2020-04-25
 * @description
 */
public class SelectionSort {


    //    选择排序
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 4, 9, 2, 3};

        selectionSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

    }


    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(i, minIndex, arr);
        }
    }


    /**
     * 交换
     *
     * @param i
     * @param j
     * @param arr
     */
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    class Solution {
        public int removeElement(int[] nums, int val) {
            //            1,3,4,2,5,5
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }

        public int removeDuplicates(int[] nums) {
            int i = 0;
            //  1,1,2,
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i;
        }
    }
}
