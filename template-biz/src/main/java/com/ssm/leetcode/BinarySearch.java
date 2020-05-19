package com.ssm.leetcode;

/**
 * @author quandaoran
 * @date 2020-04-25
 * @description
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
//        长度9
        int i = binarySearch(arr, 8);
        System.out.println(i);
    }


    public static int binarySearch(int[] arr, int num) {

        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            System.out.println("left :" + left + " right: " + right + " mid:" + mid);
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return 1;

    }
}
