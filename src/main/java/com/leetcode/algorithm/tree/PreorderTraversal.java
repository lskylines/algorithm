package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ ClassName PreorderTraversal
 * @ author lskyline
 * @ 2021/1/17 15:36
 * @ Version: 1.0
 */
public class PreorderTraversal {

    /*
     * Description : leetcode144   Binary Tree Preorder Traversal
     * Given the root of a binary tree, return the preorder traversal of its nodes' values.
     */

    /**保存遍历结果*/
    private final List<Integer> arr = new ArrayList<>();

    /**
     * 解题思路: 递归， 根节点 -> 左子树 -> 右子树
     * @param root 树的根节点
     * @return   返回结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return arr;
        }
        arr.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return arr;
    }

    /**非递归实现前序遍历*/
    public List<Integer> preorderTraversal02(TreeNode root) {
        if (root == null) {
            return arr;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            arr.add(tempNode.val);
            if (tempNode.right != null) {
                stack.push(tempNode.right);
            }
            if (tempNode.left != null) {
                stack.push(tempNode.left);
            }
        }
        return arr;
    }

}
