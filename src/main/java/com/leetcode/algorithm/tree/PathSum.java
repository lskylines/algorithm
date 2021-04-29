package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName PathSum
 * @ author lskyline
 * @ 2021/4/29 15:26
 * @ Version: 1.0
 */
public class PathSum {
    /*
     * 路径总和 III
     */
    private int ret = 0;
    private List<List<Integer>> result = new ArrayList<>();
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfsTraverse(root, targetSum, new ArrayList<>());
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return ret;
    }

    private void dfsTraverse(TreeNode root, int targetSum, List<Integer> arr) {
        if (root == null) {
            return ;
        }
        arr.add(root.val);
        if (root.val == targetSum) {
            result.add(new ArrayList<>(arr));
            ret++;
        }
        dfsTraverse(root.left, targetSum - root.val, arr);
        dfsTraverse(root.right, targetSum-root.val, arr);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        PathSum obj = new PathSum();
        int result = obj.pathSum(root, -1);
        System.out.println(result);

        System.out.println(obj.result);

    }
}
