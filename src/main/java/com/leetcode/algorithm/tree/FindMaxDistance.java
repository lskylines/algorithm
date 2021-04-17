package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName FindMaxDistance
 * @ author lskyline
 * @ 2021/4/17 15:45
 * @ Version: 1.0
 */
public class FindMaxDistance {
    /*
     * 从一棵树中找最大距离
     */
    public static class ReturnData {
        public int maxDistance;
        public int height;

        public ReturnData(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public int getMaxDistance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ReturnData p = process(root);
        return p.maxDistance;
    }

    public ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, 0);

        }
        ReturnData leftSubTree = process(root.left);
        ReturnData rightSubTree = process(root.right);
        int includeSelf = leftSubTree.height + 1 + rightSubTree.height;
        int p1 = process(root.left).maxDistance;
        int p2 = process(root.right).maxDistance;
        int maxDistance = Math.max(Math.max(p1, p2), includeSelf);
        int height = Math.max(leftSubTree.height, rightSubTree.height) + 1;
        System.out.println(root.val + ":" + "maxDistance:" + maxDistance + ",height:" + height);
        return new ReturnData(maxDistance, height);
    }
    public static void main(String[] args) {
        FindMaxDistance obj = new FindMaxDistance();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int res = obj.getMaxDistance(root);
        System.out.println(res);
    }
}
