package com.leetcode.algorithm.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @ ClassName Connect
 * @ author lskyline
 * @ 2021/5/23 17:34
 * @ Version: 1.0
 */
public class Connect {
    /*
     * 填充每个节点的下一个右侧节点指针
     * 1) 广度优先遍历
     */
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node preNode = null;
            for (int i = 0; i < size; i++) {
                Node tempNode = queue.poll();
                if (preNode != null) {
                    preNode.next = tempNode;
                }
                preNode = tempNode;
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return root;
    }

}
