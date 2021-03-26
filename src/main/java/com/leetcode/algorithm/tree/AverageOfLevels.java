package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.*;

/**
 * @ ClassName AverageOfLevels
 * @ author lskyline
 * @ 2021/1/16 22:14
 * @ Version: 1.0
 */
public class AverageOfLevels {
    /*
     * Description : leetcode637  Average of Levels in Binary Tree
     * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
     */

    /**
     * 解题思路:
     *          1. 使用BFS算法，使用队列数据结构,统计每一层队列节点每层总和 / 每层总数，放入List中
     * @param root 树的根节点
     * @return 返回每层的平均值
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> ret = calAverageOfLevel(root);
        return ret;
    }
    /**统计每层节点平均值*/
    private List<Double> calAverageOfLevel(TreeNode root) {
        List<Double> average = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                sum += tempNode.val;
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            average.add(sum / size);
        }
        return average;
    }
}
