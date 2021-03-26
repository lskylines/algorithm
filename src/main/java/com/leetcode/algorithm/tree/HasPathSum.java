package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @author lskyline
 * @ 2021/1/16 13:06
 *
 */
public class HasPathSum {

    /*
     *  Description : leetcode112  Path Sum
     * Given a binary tree and a sum,
     * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     */

    /**
     * 解题思路:
     *         采用递归法，递归左右子树, 如果根左右子树为空，且sum == root.val，说明存在根节点到叶子节点的值总和为sum的树
     *
     * @param root 树的根节点
     * @param sum  目标值
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
       if (root.left == null && root.right == null && sum == root.val) {
           return true;
       }
       return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


}
