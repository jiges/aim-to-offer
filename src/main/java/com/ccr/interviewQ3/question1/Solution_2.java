package com.ccr.interviewQ3.question1;


import java.util.HashSet;
import java.util.Set;

/**
 * 解法二，利用Set的性质，不改变数组元素位置
 *
 * Set查找元素的复杂度是O(1),所以问题解的时间复杂度O(n),空间复杂度O(n)
 */
public class Solution_2 {
    public int findOneDuplicateNumber(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                return arr[i];
            } else {
                set.add(arr[i]);
            }
        }
        return -1;
    }
}
