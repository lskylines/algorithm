package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lskyline
 * @ 2021/1/16 12:50
 *
 */
public class MergeTrees {
    /*
     * Description : leetcode617  Merge Two Binary Trees
     * Given two binary trees and imagine that when you put one of them to cover the other,
     * some nodes of the two trees are overlapped while the others are not.
     */


    /**
     * 解题思路: 创建新的节点，节点值为tree1与tree2之和，递归左子树、右子树
     * @param t1 Tree1 根节点
     * @param t2 Tree2 根节点
     * @return  返回新的树
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode newNode = buildNewTree(t1, t2);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }

    /**非递归实现树的合并*/
    public TreeNode mergeTrees02(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            t1.val += t2.val;
            if (t1.left != null && t2.left != null) {
                queue.add(t1.left);
                queue.add(t2.left);
            } else if (t1.left == null) {
                t1.left = t2.left;
            }
            if (t1.right != null && t2.right != null) {
                queue.offer(t1.right);
                queue.offer(t2.right);
            } else if (t1.right == null) {
                t1.right = t2.right;
            }
        }
        return root1;
    }

    public TreeNode buildNewTree (TreeNode t1, TreeNode t2){
        TreeNode newTreeNode = new TreeNode(t1.val + t2.val);
        return newTreeNode;
    }



    public void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return ;
        }
        TreeNode currentNode = root;
        TreeNode mostRightNode = null;
        while (currentNode != null) {
            mostRightNode = currentNode.left;
            if (mostRightNode != null) {
                while (mostRightNode.right != null && mostRightNode.right != currentNode) {
                    mostRightNode = mostRightNode.right;
                }
                if (mostRightNode.right == null) {
                    mostRightNode.right = currentNode;
                    currentNode = currentNode.left;
                    continue ;
                } else {
                    mostRightNode.right = null;
                }
            }
            System.out.println(currentNode.val);
            currentNode = currentNode.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        MergeTrees obj = new MergeTrees();
        TreeNode targetNode = obj.mergeTrees02(root1, root2);
        obj.inOrderTraverse(targetNode);
    }
}
