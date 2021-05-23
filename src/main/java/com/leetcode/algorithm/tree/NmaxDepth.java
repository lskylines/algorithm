package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ ClassName NmaxDepth
 * @ author lskyline
 * @ 2021/5/23 22:08
 * @ Version: 1.0
 */
public class NmaxDepth {
    /*
     * N 叉树的最大深度
     * 1) 递归
     * 2） 非递归
     */
    public static class Node {
        public int val;
        public List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }
        return depth + 1;
    }

    public int maxDepth02(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tempNode = queue.poll();
                for (int j = 0; j < tempNode.children.size(); j++) {
                    queue.add(tempNode.children.get(j));
                }
            }
            depth++;
        }
        return depth;
    }
}
