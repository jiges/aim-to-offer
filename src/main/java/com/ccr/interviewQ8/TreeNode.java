package com.ccr.interviewQ8;

/**
 * 树节点
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value,TreeNode parent) {
        this.value = value;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
