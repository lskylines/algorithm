package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lskyline
 * @ 2021/1/12 23:33
 *
 */
public class MaxDepth {

    /*
     * Description : leetcode104  Maximum Depth of Binary Tree
     * Given the root of a binary tree, return its maximum depth.
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     */

    /**
     * 解题思路:
     *         递归求出左右子树高度，比较左右子树，取最大值
     * @param root 根节点
     * @return 树的高度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 解题思路:
     *      非递归，采用广度优先遍历
     * @param root 根节点
     * @return 树的高度
     */
    public int maxDepth02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            count++;
        }
        return count;
    }
}
