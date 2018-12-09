package com.ccr.interviewQ8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 测试案例：
 * 普通二叉树：[1,2,3,4,5,6,7,null,null,8,9]
 *                 1
 *                / \
 *               2   3
 *              /\  /\
 *             4 5 6 7
 *              /\
 *             8 9
 * 特殊二叉树,所有节点都没有右子节点[1,2,null,3,null,4]
 * 特殊二叉树,所有节点都没有左子节点[1,null,2,null,3,null,4]
 * 只有一个节点的二叉树[1]
 * 空树[]
 *
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            System.out.println("请输入树：");
            TreeNode root = stringToTreeNode(in.readLine());

            System.out.println("请输入要被查找的节点：");
            TreeNode nextTo = findTreeNode(root,Integer.parseInt(in.readLine()));

            TreeNode ret = new Solution().nextTreeNodeByMediumOrder(nextTo);

            System.out.println(ret);
        }
    }


    /**
     * 构造二叉树，按照二叉堆的方式进行构造，空元素用null补充
     * @param input int数组用逗号隔开
     * @return 二叉树根节点
     */
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber,node);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber,node);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    /**
     * 中序遍历查找相应的节点
     * @param root 根节点
     * @param val 查找的数据
     * @return 相应的节点
     */
    public static TreeNode findTreeNode(TreeNode root,int val){
        if(root == null) {
            return null;
        }
        TreeNode finding;
        finding = findTreeNode(root.left,val);
        if(finding == null) {
            if(root.value == val) {
                finding = root;
            }
        }
        if(finding == null)
            finding = findTreeNode(root.right,val);
        return finding;
    }
}
