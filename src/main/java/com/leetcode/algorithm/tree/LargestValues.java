package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ ClassName LargestValues
 * @ author lskyline
 * @ 2021/5/1 18:40
 * @ Version: 1.0
 */
public class LargestValues {
    /*
     * 在每个树行中找最大值
     */
    private List<Integer> ret = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                maxValue = Math.max(maxValue, tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            ret.add(maxValue);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
    }
}
