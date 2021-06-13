package com.leetcode.algorithm.backtracking;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName SumNumbers
 * @ author lskyline
 * @ 2021/5/1 11:13
 * @ Version: 1.0
 */
public class SumNumbers {
    /*
     * 求根节点到叶节点数字之和
     * 1) 存储根节点到叶子节点的节点值，进行字符串拼接，转换数值进行相加
     * 2) 直接结算
     */
    private List<List<Integer>> ret = new ArrayList<>();

    private List<String> result = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, new ArrayList<>());
        int res = 0;
        for (int i = 0; i < ret.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < ret.get(i).size(); j++) {
                sb.append(ret.get(i).get(j));
            }
            res += Integer.parseInt(sb.toString());
        }
        return res;
    }

    public int sumNumbers02(TreeNode root) {
        return dfs02(root, 0);
    }

    private int dfs02(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs02(root.left, sum) + dfs02(root.right,sum);
        }
    }

    private void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return ;
        }
        arr.add(root.val);
        if (root.left == null && root.right == null) {
            ret.add(new ArrayList<>(arr));
        }
        dfs(root.left, arr);
        dfs(root.right, arr);
        arr.remove(arr.size() -1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        SumNumbers obj = new SumNumbers();
        int res = obj.sumNumbers02(root);
        System.out.println(res);
    }
}
