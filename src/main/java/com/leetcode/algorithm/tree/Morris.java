package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName Mirrors
 * @ author lskyline
 * @ 2021/4/16 16:46
 * @ Version: 1.0
 */
public class Morris {
    /**
     * Morris实现
     * 1) 前序遍历
     * 2) 中序遍历
     * 3) 后续遍历
     */
    public void preOrderTraverse(TreeNode root) {
        if (root == null) {
            return ;
        }
        TreeNode curNode = root;
        TreeNode mostRight = null;
        while (curNode != null) {
            mostRight = curNode.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != curNode) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = curNode;
                    System.out.println(curNode.val);
                    curNode = curNode.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.println(curNode.val);
            }
            curNode = curNode.right;
        }
    }

    public void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return ;
        }
        TreeNode curNode = root;
        TreeNode mostRight = null;
        while (curNode != null) {
            mostRight = curNode.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != curNode) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = curNode;
                    curNode = curNode.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(curNode.val);
            curNode = curNode.right;
        }
    }

    public void postOrderTraver(TreeNode root) {
        if (root == null) {
            return ;
        }
        TreeNode curNode = root;
        TreeNode mostRight = null;
        while (curNode != null) {
            mostRight = curNode.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != curNode) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = curNode;
                    curNode = curNode.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(curNode.left);
                }
            }
            curNode = curNode.right;
        }
        printEdge(root);
    }

    public void printEdge(TreeNode head) {
        TreeNode tailNode = reverseEdge(head);
        TreeNode curNode = tailNode;
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.right;
        }
        reverseEdge(tailNode);
    }

    public TreeNode reverseEdge(TreeNode head) {
        TreeNode pre = null;
        TreeNode next = null;
        while (head != null) {
            next = head.right;
            head.right = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Morris obj = new Morris();
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        obj.postOrderTraver(root);
    }
}
