package com.ccr.interviewQ3.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试用例：[2,3,1,0,2,5,3]  输出 2 或 3
 * 测试用例：[1,2,5,3,9,8,7,0,4,6] 输出 -1
 * 测试用例：[] 输出 -1
 * 测试用例：[1,5,5,9]
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] arr = line.split(",");
            int[] intArr = new int[arr.length];
            try {
                for (int i = 0; i < arr.length; i++) {
                    intArr[i] = Integer.valueOf(arr[i]);
                }
            } catch (NumberFormatException e) {
                intArr = new int[0];
            }


            int ret_1 = new Solution_1().findOneDuplicateNumber(intArr);
            int ret_2 = new Solution_2().findOneDuplicateNumber(intArr);
            int ret_3 = new Solution_3().findOneDuplicateNumber(intArr);

            System.out.printf("Solution_1: %d%n",ret_1);
            System.out.printf("Solution_2: %d%n",ret_2);
            System.out.printf("Solution_3: %d%n",ret_3);
        }
    }
}
