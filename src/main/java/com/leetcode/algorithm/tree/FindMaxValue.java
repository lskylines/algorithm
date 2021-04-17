package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName FindMaxValue
 * @ author lskyline
 * @ 2021/4/17 14:03
 * @ Version: 1.0
 */
public class FindMaxValue {
    /**
     * 寻找二叉树中最大、最小值
     */
    public static class ReturnData {
        public int max;
        public int min;

        public ReturnData(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    public void printMinAndMax(TreeNode head) {
        ReturnData data = p(head);
        System.out.println("max:" + data.max);
        System.out.println("min: " + data.min);
    }


    public static ReturnData p(TreeNode head) {
        if (head == null) {
            return new ReturnData(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ReturnData leftData = p(head.left);
        ReturnData rightData = p(head.right);
        return new ReturnData(Math.max(Math.max(leftData.max, rightData.max), head.val),
                Math.min(Math.min(leftData.min, rightData.min), head.val));
    }
    public static void main(String[] args) {
        FindMaxValue obj = new FindMaxValue();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        obj.printMinAndMax(root);

    }
}
