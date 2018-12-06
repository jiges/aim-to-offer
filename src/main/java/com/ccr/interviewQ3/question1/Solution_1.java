package com.ccr.interviewQ3.question1;

import java.util.Arrays;

/**
 * 解法一：排序法，先将数组排序，相邻的元素进行比较
 *
 * 该算法改变了数组元素位置
 *
 * 时间复杂度O(nlogn) 空间复杂度O(1)
 */
public class Solution_1 {
    public int findOneDuplicateNumber(int[] arr) {

        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i - 1]) {
                return arr[i];
            }
        }
        return -1;
    }
}
