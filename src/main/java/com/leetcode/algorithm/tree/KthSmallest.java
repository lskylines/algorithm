package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ ClassName KthSmallest
 * @ author lskyline
 * @ 2021/1/17 16:54
 * @ Version: 1.0
 */
public class KthSmallest {

    /*
     * Description : leetcode230  Kth Smallest Element in a BST
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
     */

    /**统计递归遍历树的索引*/
    private int index = 0;
    /**存储结果*/
    private int ret = -1;

    /**
     * 解题思路:
     *         二叉树中序遍历是有序的，利用有序特性，遍历后，第N个节点即为所求
     * @param root 树的根节点
     * @param k  第N个
     * @return 第N个数
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null ||  k <= 0) {
            return -1;
        }
        inOrderTraverse(root, k);
        return ret;
    }

    /**递归中序遍历二叉树*/
    private void inOrderTraverse(TreeNode root, int k) {
        if (root == null) {
            return ;
        }
        inOrderTraverse(root.left, k);
        if (++index == k) {
            ret = root.val;
        }
        inOrderTraverse(root.right, k);
    }

    /**非递归实现中序遍历*/
    public int kthSmallest02(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tempNode = stack.pop();
            ret.add(tempNode.val);
            root = tempNode.right;
        }
        return ret.get(k-1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        KthSmallest obj = new KthSmallest();
        int ret = obj.kthSmallest02(root, 1);
        System.out.println(ret);
    }
}
