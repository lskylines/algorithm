package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ ClassName InorderTraversal
 * @ author lskyline
 * @ 2021/1/17 15:45
 * @ Version: 1.0
 */
public class InorderTraversal {
    /*
     * Description : leetcode94  Binary Tree Inorder Traversal
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     */
    /**保存结果*/
    private List<Integer> arr = new ArrayList<>();

    /**
     * 解题思路: 递归， 左子树 -> 根节点 -> 右子树
     * @param root 树的根节点
     * @return  返回的结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return arr;
        }
        inorderTraversal(root.left);
        arr.add(root.val);
        inorderTraversal(root.right);
        return arr;
    }

    /**非递归实现中序遍历*/
    public List<Integer> inorderTraversal02(TreeNode root) {
        if (root == null) {
            return arr;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tempNode = stack.pop();
            arr.add(tempNode.val);
            root = tempNode.right;
        }
        return arr;
    }
}
