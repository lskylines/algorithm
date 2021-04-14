package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.List;

/**
 * @ ClassName Serialize
 * @ author lskyline
 * @ 2021/4/14 10:52
 * @ Version: 1.0
 */
public class Serialize {
    /*
     * 序列化二叉树
     */

    private String deserializeStr;


    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    public TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Serialize obj = new Serialize();
        String serialStr = obj.serialize(root);
        System.out.println(serialStr);
        TreeNode t = obj.Deserialize(serialStr);
        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> ret = inorderTraversal.inorderTraversal(t);
        System.out.println(ret);
    }
}
