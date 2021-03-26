package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName SumOfLeftLeaves
 * @ author lskyline
 * @ 2021/1/16 16:30
 * @ Version: 1.0
 */
public class SumOfLeftLeaves {
    private int sum = 0;
    /**
     * 解题思路:
     *      递归遍历树， 如果左子树为空，右子树为空，且满足是左子树的情况下，即为左子树叶子节点
     * @param root 树的根节点
     * @return 返回树的左叶子节点的值总和
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverseTree(root, false);
        return sum;
    }

    /**遍历，判断是否是左子树叶子节点*/
    private void traverseTree(TreeNode root, boolean isLeft) {
        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
        }
        traverseTree(root.left, true);
        traverseTree(root.right, false);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        SumOfLeftLeaves obj = new SumOfLeftLeaves();
        int sum = obj.sumOfLeftLeaves(treeNode);
        System.out.println("左子树节点值总和:" + sum);
    }
}
