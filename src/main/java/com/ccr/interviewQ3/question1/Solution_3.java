package com.ccr.interviewQ3.question1;


/**
 * 解3：数字都在0~n-1范围内，从第一个数字开始扫描，若数字与下标不等则找到对应下标的数字进行交换
 * 然后继续扫描第一个数字，直到数字与下标相等后再扫描第二个数字，如果在交换时发现被交换的数字与下标相等
 * 则说明该数字重复了
 *
 * 该算法改变了数组元素位置
 *
 * 该算法时间复杂度O(n),空间复杂度O(1)
 *
 * 如果有数字不在0~n-1的范围内，该算法不成立，直接返回-2
 *
 */
public class Solution_3 {
    public int findOneDuplicateNumber(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0 || arr[i] > arr.length - 1) {
                return -2;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            //数字与下标不等
            while(arr[i] != i) {
                //交换时发现被交换的数字与下标相等
                if(arr[arr[i]] == arr[i]) {
                    return arr[i];
                } else {//交换 a = (a + b) - (b = a);
                    arr[i] = (arr[i] + arr[arr[i]]) - (arr[arr[i]] = arr[i]);
                }
            }
        }
        return -1;
    }
}
