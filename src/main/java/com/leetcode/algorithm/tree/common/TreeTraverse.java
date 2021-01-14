package com.leetcode.algorithm.tree.common;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @author lskyline
 * @ 2021/1/15 0:38
 *
 */
public class TreeTraverse {

    /**前序遍历*/
    public static void preorderTraversal(TreeNode root) {
        if (root == null)  {
            return ;
        }
        System.out.println(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
