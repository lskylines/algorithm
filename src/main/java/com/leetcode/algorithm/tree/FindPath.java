package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName FindPath
 * @ author lskyline
 * @ 2021/4/13 23:22
 * @ Version: 1.0
 */
public class FindPath {
    /*
     * 二叉树中和为某一值的路径
     * 1) 从根节点到叶子节点
     * 2）从根节点某一个节点
     * 3) 从某一节点到叶子节点
     * 4）从某一节点到某一节点
     */

    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        traverse(root, target, new ArrayList<>());
        return ret;
    }

    private void traverse(TreeNode root, int target, List<Integer> arr) {
        if (root == null) {
            return ;
        }
        arr.add(root.val);
        target -= root.val;
        if (target ==0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(arr));
        } else {
            traverse(root.left, target, arr);
            traverse(root.right, target, arr);
        }
        arr.remove(arr.size()-1);
    }

    public List<List<Integer>> findPathRoot2Leaf(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        dfs(root, target, new ArrayList<>());
        return ret;
    }

    private void dfs(TreeNode root, int target, List<Integer> arr) {
        if (root == null) {
            return ;
        }
        arr.add(root.val);
        target -= root.val;
        if (target == 0) {
            ret.add(new ArrayList<>(arr));
        } else {
            dfs(root.left, target, arr);
            dfs(root.right, target, arr);
        }
        arr.remove(arr.size() - 1);
    }

    public List<List<Integer>> findPath2Leaf(TreeNode root, int target) {
        if (root ==  null) {
            return ret;
        }
        dfs2Leaf(root, target, new ArrayList<>());
        findPath2Leaf(root.left, target);
        findPath2Leaf(root.right, target);
        return ret;
    }

    private void dfs2Leaf(TreeNode root, int target, List<Integer> arr) {
        if (root == null) {
            return ;
        }
        arr.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(arr));
        } else {
            dfs2Leaf(root.left, target, arr);
            dfs2Leaf(root.right, target, arr);
        }
        arr.remove(arr.size() -1);
    }

    public List<List<Integer>> findPath2Path(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        dfs(root, target, new ArrayList<>());
        findPath2Path(root.left, target);
        findPath2Path(root.right, target);
        return ret;
    }

    private void dfs2Path(TreeNode root, int target, List<Integer> arr) {
        if (root == null) {
            return ;
        }
        arr.add(root.val);
        target -= root.val;
        if (target == 0) {
            ret.add(new ArrayList<>(arr));
        } else {
            dfs2Path(root.left, target, arr);
            dfs2Path(root.right, target, arr);
        }
        arr.remove(arr.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(0);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        FindPath obj = new FindPath();
        List<List<Integer>> rets = obj.findPath2Path(root, 17);
        for (List<Integer> ret : rets) {
            System.out.println(ret);
        }
    }
}
