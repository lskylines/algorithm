package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName Rob
 * @ author lskyline
 * @ 2021/1/16 17:03
 * @ Version: 1.0
 */
public class Rob {
    /*
     * Description : leetcode337  House Robber III
     * The thief has found himself a new place for his thievery again.
     *  There is only one entrance to this area, called the "root."
     *  Besides the root, each house has one and only one parent house.
     *  After a tour, the smart thief realized that "all houses in this place forms a binary tree".
     *  It will automatically contact the police if two directly-linked houses were broken into on the same night.
     */

    /**
     * 解题思路: TODO
     * @param root 树的根节点
     * @return 返回小偷偷到的最大值
     */
    public int rob(TreeNode root) {
       if (root == null) {
           return 0;
       }
       int val = 0;
       if (root.left != null) {
           val += rob(root.left.left) + rob(root.left.right);
       }
       if (root.right != null) {
           val += rob(root.right.left) + rob(root.right.right);
       }
       return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    public int rob02(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    public int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;
        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }
        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }
        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);
        return val;
    }
    public static void main(String[] args) {
        /*TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(1);*/

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(2);
        node.left.left.left = new TreeNode(3);
        Rob rob = new Rob();
        int num = rob.rob(node);
        System.out.println(num);
    }
}
