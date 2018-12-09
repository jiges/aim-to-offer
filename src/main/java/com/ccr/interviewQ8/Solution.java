package com.ccr.interviewQ8;

/**
 * 解法一：暴利解法，中序遍历树节点找到下一个节点，这种方法简单，但是时间复杂度是O(n)
 * 解法二：分析一下中序遍历的过程，如果某个节点有右子树，则中序遍历右子树的第一个节点就是
 * 下一个节点，如果没有右子树，则向上查找，知道找到第一个父节点的左子节点是它自己的节点，
 * 它的父节点就是解
 *
 * 算法二最坏情况下只会扫描n个节点，n为树高。最坏情况下的时间复杂度为O(lgn)
 */
public class Solution {

    public TreeNode nextTreeNodeByMediumOrder(TreeNode currentNode){
        if(currentNode == null) {
            return null;
        }
        if(currentNode.right != null) {
            TreeNode next = currentNode.right;
            for (;;next = next.left) {
                if(next.left == null) {
                    return next;
                }
            }
        } else {
            TreeNode p = currentNode;
            for (;;) {
                //向上查找，找不到满足的节点，则currentNode就是最后一个节点
                if(p.parent == null) {
                    return null;
                } else {
                    //父节点的左子节点是自己，则父节点就是问题的解
                    if(p.parent.left == p) {
                        return p.parent;
                    } else {
                        //找不到继续往上找
                        p = p.parent;
                    }
                }
            }
        }
    }
}
