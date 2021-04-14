package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.Stack;

/**
 * @ ClassName Convert
 * @ author lskyline
 * @ 2021/4/14 10:12
 * @ Version: 1.0
 */
public class Convert {
    /*
     * 二叉搜索树与双向链表
     * 1) 递归
     * 2) Morris遍历 TODO
     */

    private TreeNode pre = null;
    private TreeNode head = null;
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        return head;
    }



    public void inOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        inOrder(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inOrder(root.right);
    }


}
