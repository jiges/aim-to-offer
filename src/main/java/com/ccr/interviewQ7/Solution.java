package com.ccr.interviewQ7;

/**
 * 前序遍历的第一个节点就是根节点，拿到根节点再到
 */
public class Solution {

    /**
     * 前序遍历数组的第一个节点即为根节点,利用根节点在中序遍历数组中的位置
     * 确定左子树和右子树的范围进行递归调用
     * @param preOrder 前序遍历数组
     * @param mediumOrder 中序遍历数组
     * @return 返回重建后的二叉树，如果输入不合法则返回null
     */
    public TreeNode rebuildTree(int[] preOrder,int[] mediumOrder) {
        int length;
        //遍历的数组长度相等且不为0
        if(preOrder != null && mediumOrder != null && (length = preOrder.length) == mediumOrder.length && length != 0) {
            try {
                return rebuildTree(preOrder,0,mediumOrder,0,length);
            } catch (IllegalDataException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 递归调用方法 preOrder 和 preOrderStart与length组成前序遍历数组
     * 递归调用方法 mediumOrder 和 mediumOrderStart与length组成中序遍历数组
     * @param preOrder 前序遍历数组
     * @param preOrderStart 前序遍历数组起始位置
     * @param mediumOrder 中序遍历数组
     * @param mediumOrderStart 中序遍历数组起始位置
     * @param length 数组长度
     * @throws IllegalDataException 当输入非法时抛出
     * @return 重建后的二叉树，如果length为0，则返回null
     */
    private TreeNode rebuildTree(int[] preOrder, int preOrderStart,int[] mediumOrder,int mediumOrderStart,int length) throws IllegalDataException{
        if (length == 0) {
            return null;
        }
        /*
         * 前序遍历数组的第一个节点即为根节点,利用根节点在中序遍历数组中的位置
         * 确定左子树和右子树的范围进行递归调用
         */
        int rootVal = preOrder[preOrderStart];
        int leftLength = 0,rightLength = 0;//左子树和右子树的元素数量
        int i = mediumOrderStart;
        for (; i < mediumOrderStart + length; i++) {
            //找到根节点的位置
            if(mediumOrder[i] == rootVal) {
                leftLength = i - mediumOrderStart;
                rightLength = mediumOrderStart + length - i - 1;
                break;
            }
        }
        //两种遍历结果中 元素不一致的情况，如[1,2,3]和[3,5,6]
        if(i == mediumOrderStart + length) {
            throw new IllegalDataException("Illegal input...");
        }
        //构建左子树和右子树
        TreeNode root = new TreeNode(rootVal);
        root.left = rebuildTree(preOrder,preOrderStart + 1,mediumOrder,mediumOrderStart,leftLength);
        root.right = rebuildTree(preOrder,preOrderStart + leftLength + 1,mediumOrder,mediumOrderStart + leftLength + 1,rightLength);
        return root;
    }

}
