package com.ssm.leetcode;

/**
 * @author quandaoran
 * @date 2020-04-25
 * @description
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5, 4, 1};
//
        insertionSort(arr);

//        swap(1,2,arr);
        for (int i : arr) {
            System.out.println(i);
        }


    }


    public static void insertionSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(j + 1, j, arr);
            }
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
