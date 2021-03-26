package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ ClassName PostorderTraversal
 * @ author lskyline
 * @ 2021/1/17 16:27
 * @ Version: 1.0
 */
public class PostorderTraversal {
    private List<Integer> result = new ArrayList<>();
    /**
     * 解题思路: 递归 左子树 -> 根 -> 右子树
     * @param root 树的根节点
     * @return 返回的结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }

    /**非递归后序遍历解法，采用两个栈*/
    public List<Integer> postorderTraversal02(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> retStack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            retStack.push(tempNode);
            if (tempNode.left != null) {
                stack.push(tempNode.left);
            }
            if (tempNode.right != null) {
                stack.push(tempNode.right);
            }
        }
        while (!retStack.isEmpty()) {
            ret.add(retStack.poll().val);
        }
        return ret;
    }
}
