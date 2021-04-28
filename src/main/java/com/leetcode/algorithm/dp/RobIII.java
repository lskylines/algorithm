package com.leetcode.algorithm.dp;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.*;

/**
 * @ ClassName RobIII
 * @ author lskyline
 * @ 2021/4/28 21:32
 * @ Version: 1.0
 */
public class RobIII {
    /*
     * 打家劫舍III
     * 1) 暴力法
     * 2） 动态规划 TODO
     */
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        int res = Math.max(money, rob(root.left) + rob(root.right));
        map.put(root, res);
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.left.right.left.right = new TreeNode(1);
        root.left.right.left.right.right = new TreeNode(9);
        RobIII obj = new RobIII();
        int res = obj.rob(root);
        System.out.println(res);
    }
}
