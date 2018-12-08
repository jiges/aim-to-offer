package com.ccr.interviewQ7;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试用例：
 * 不合法输入：[2,5,8,7,6]和[3,5,8,6,7]
 * 不合法输入：[5,8,7,6]和[3,5,8,6,7]
 * 不合法输入：[]和[]
 * 完全二叉树：[1,2,4,8,9,5,10,11,3,6,12,13,7,14,15]和[8,4,9,2,10,5,11,1,12,6,13,3,14,7,15]
 * 普通二叉树：[1,2,4,7,3,5,6,8]和[4,7,2,1,5,3,8,6]
 * 单链表二叉树：[1,2,3,4]和[4,3,2,1]
 * 单链表二叉树：[1,2,3,4]和[3,4,2,1]
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            System.out.println("前序遍历数组：");
            line = in.readLine();
            String[] arr_1 = line.split(",");
            int[] preOrder = new int[arr_1.length];
            try {
                for (int i = 0; i < arr_1.length; i++) {
                    preOrder[i] = Integer.valueOf(arr_1[i]);
                }
            } catch (NumberFormatException e) {
                preOrder = new int[0];
            }

            System.out.println("中序遍历数组：");
            line = in.readLine();
            String[] arr_2 = line.split(",");
            int[] mediumOrder = new int[arr_2.length];
            try {
                for (int i = 0; i < arr_2.length; i++) {
                    mediumOrder[i] = Integer.valueOf(arr_2[i]);
                }
            } catch (NumberFormatException e) {
                mediumOrder = new int[0];
            }
            printTree(new Solution().rebuildTree(preOrder,mediumOrder));
        }

    }

    /**
     * 前序遍历打印树，叶子节点用null表示。如：
     * 1
     *   2
     *     3
     *     5
     *   4
     *
     * @param root 根节点
     */
    private static void printTree(TreeNode root) {
        if(root != null) {
            System.out.println(root.value);
            printTree(root.left,1);
            printTree(root.right,1);
        } else {
            System.out.println("NULL");
        }

    }

    private static void printTree(TreeNode root,int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        if(root != null) {
            System.out.println(root.value);
            printTree(root.left,level + 1);
            printTree(root.right,level + 1);
        } else {
            System.out.println("null");
        }
    }
}
