package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ ClassName CodeTree
 * @ author lskyline
 * @ 2021/4/21 10:26
 * @ Version: 1.0
 */
public class CodeTree {
    /*
     * 二叉树序列化、反序列化
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode == null) {
                res.append("#,");
                continue;
            }
            res.append(tempNode.val + ",");
            queue.add(tempNode.left);
            queue.add(tempNode.right);
        }
        return res.toString();
    }

    public String dfsSerialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + dfsSerialize(root.left) + "," + dfsSerialize(root.right);
    }

    public TreeNode dfsDeserialize(String str) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(str.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String val = queue.poll();
        if ("#".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }

    public TreeNode deserialize(String str) {
        if (str == "#") {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = str.split(",");
        System.out.println(Arrays.toString(values));
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!"#".equals(values[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if (!"#".equals(values[++i])) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        CodeTree obj = new CodeTree();
        String res = obj.dfsSerialize(root);
        TreeNode temp  = obj.dfsDeserialize(res);
    }
}
