package com.leetcode.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName NPostorder
 * @ author lskyline
 * @ 2021/5/9 11:21
 * @ Version: 1.0
 */
public class NPostorder {
    /*
     * N叉树的后序遍历
     */
    public static class Node {
        public int val;
        public List<Node> child;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> child) {
            this.val = val;
            this.child = child;
        }
    }

    private List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return result;
        }
        if (root.child != null) {
            for (Node ch : root.child) {
                postorder(ch);
            }
        }
        result.add(root.val);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> list = Arrays.asList(new Node(3), new Node(2), new Node(4));
        root.child = list;
        List<Node> leftList = Arrays.asList(new Node(5), new Node(6));
        root.child.get(0).child = leftList;

        NPostorder obj = new NPostorder();
        List<Integer> result = obj.postorder(root);
        System.out.println(result);
    }
}
