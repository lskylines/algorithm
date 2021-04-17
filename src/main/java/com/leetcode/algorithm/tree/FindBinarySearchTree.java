package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @ ClassName FindBinarySearchTree
 * @ author lskyline
 * @ 2021/4/17 15:08
 * @ Version: 1.0
 */
public class FindBinarySearchTree {

    public static class ReturnData {
        public TreeNode head;
        public int size;
        public int min;
        public int max;

        public ReturnData(TreeNode head, int size, int min, int max) {
            this.head = head;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    /*
     * 从一棵树中寻找二叉搜索树
     */
    public TreeNode findBinarySearchTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = process(root).head;
        return res;
    }

    public ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        ReturnData leftSubTree = process(leftNode);
        ReturnData rightSubTree = process(rightNode);
        int includeSelf = 0;
        if (leftSubTree.head == leftNode && rightSubTree.head == rightNode
                && root.val > leftSubTree.max && root.val < rightSubTree.min) {
            includeSelf = leftSubTree.size + 1 + rightSubTree.size;
        }
        int p1 = leftSubTree.size;
        int p2 = rightSubTree.size;
        int maxSize = Math.max(Math.max(p1, p2), includeSelf);
        TreeNode maxHead = p1 > p2 ? leftSubTree.head : rightSubTree.head;
        if (maxSize == includeSelf) {
            maxHead = root;
        }
        return new ReturnData(maxHead, maxSize, Math.min(Math.min(leftSubTree.min,  rightSubTree.min), root.val),
                Math.max(Math.max(leftSubTree.max, rightSubTree.max), root.val));
    }

    public void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return ;
        }
        inOrderTraverse(root.left);
        System.out.println(root.val);
        inOrderTraverse(root.right);
    }

    public static void main(String[] args) {
        FindBinarySearchTree obj = new FindBinarySearchTree();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        root.right = new TreeNode(13);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        TreeNode node = obj.findBinarySearchTree(root);
        obj.inOrderTraverse(node);
    }
}
