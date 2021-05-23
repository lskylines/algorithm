package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.*;

/**
 * @ ClassName LevelOrderBottom
 * @ author lskyline
 * @ 2021/5/23 17:19
 * @ Version: 1.0
 */
public class LevelOrderBottom {
    /*
     * 二叉树的层序遍历 II
     * 1) 广度优先遍历
     * 2) 深度优先遍历
     */
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                res.add(temp.val);
            }
            result.add(0, res);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom02(TreeNode root) {
        if (root == null) {
            return results;
        }
        int level = 0;
        dfs(root, level);
        Collections.reverse(results);
        return results;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return ;
        }

        if (level >= results.size()) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LevelOrderBottom obj = new LevelOrderBottom();
        List<List<Integer>> results = obj.levelOrderBottom02(root);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
