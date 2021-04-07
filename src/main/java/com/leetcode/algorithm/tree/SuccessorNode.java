package com.leetcode.algorithm.tree;


/**
 * @ ClassName SuccessorNode
 * @ author lskyline
 * @ 2021/4/7 16:56
 * @ Version: 1.0
 */
public class SuccessorNode {
    //给定节点后一个节点,求出对应的后继节点

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    /**
     * 实现思路：
     *  如果给定节点有右子树，返回右子树中最左叶子节点
     *  如果给定节点不存在右子树，如果节点的父节点的左节点等于该节点，返回父节点， 否则将节点和父节点上移后在继续判断
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node)  {
        if (node == null) {
            return node;
        }
        Node curNode = node;
        if (curNode.right != null) {
            return getLeftMost(curNode.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        while (node != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node lNode = new Node(2);
        Node rNode = new Node(3);
        Node llNode = new Node(4);
        Node lrNode = new Node(5);
        node.left = lNode;
        node.right = rNode;
        node.left.left = llNode;
        node.left.right = lrNode;
        lNode.parent = node;
        rNode.parent = node;
        llNode.parent = lNode;
        lrNode.parent = lNode;
        Node targetNode = getSuccessorNode(llNode);
        System.out.println(targetNode.val);

    }
}
