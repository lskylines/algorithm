package com.leetcode.algorithm.list;


import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName HasSubtree
 * @ author lskyline
 * @ 2021/4/10 23:25
 * @ Version: 1.0
 */
public class HasSubtree {
    /*
     * 树的子结构
     */
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtreeWithRoot(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public static boolean isSubtreeWithRoot(TreeNode l1, TreeNode l2) {
        if (l2 == null) {
            return true;
        }
        if (l1 == null) {
            return false;
        }
        if (l1.val != l2.val) {
            return false;
        }
        return isSubtreeWithRoot(l1.left, l2.left) && isSubtreeWithRoot(l1.right, l2.right);
    }
}
