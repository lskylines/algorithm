package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @author lskyline
 * @ 2021/1/16 14:28
 *
 */
public class Subtree {

    /**
     * 解题思路:
     *      1. 判断是否Tree s与Tree t都为空，如果都为空，满足
     *      2. 判断是否Tree s与Tree t其中一个为空，不满足
     *      3. 递归遍历左子树、右子树
     *          1. 对树s进行判断是否满足
     *          2. 对树s左子树进行判断是否满足
     *          3. 对树s右子树进行判断是否满足
     * @param s Tree s根节点
     * @param t Tree t根节点
     * @return  是否存在子树
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return traverseSubTree(s, t) || isSubtree(s.left, t) ||isSubtree(s.right, t);
    }

    /**遍历树，判断是否满足子树条件*/
    private boolean  traverseSubTree(TreeNode s, TreeNode t) {
        if (s == null && t ==null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return traverseSubTree(s.left, t.left) && traverseSubTree(s.right, t.right);
    }
}
