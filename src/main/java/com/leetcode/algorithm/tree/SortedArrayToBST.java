package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName SortedArrayToBST
 * @ author lskyline
 * @ 2021/5/9 11:41
 * @ Version: 1.0
 */
public class SortedArrayToBST {
    /*
     * 将有序数组转换为二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildSearchTree(nums, 0, nums.length -1);
    }

    private TreeNode buildSearchTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildSearchTree(nums, start, mid - 1);
        root.right = buildSearchTree(nums, mid + 1, end);
        return root;
    }
}
