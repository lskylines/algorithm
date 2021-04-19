package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName ReConstructBinaryTree
 * @ author lskyline
 * @ 2021/4/9 7:19
 * @ Version: 1.0
 */
public class ReConstructBinaryTree {
     private Map<Integer, Integer> indexForInOrders = new HashMap<>();
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, in,0, pre.length, 0, in.length);
    }

    private TreeNode reConstructBinaryTree(int[] pre,int[] in, int preL, int preR, int inL, int inR) {
        if (preL >= pre.length || inL >= in.length || preL > preR || inL > inR) {
            return null;
        }
        int value = pre[preL];
        TreeNode node = new TreeNode(value);
        int count = inL;
        while (in[count] != value) {
            count++;
        }
        count -= inL;
        node.left = reConstructBinaryTree(pre, in, preL + 1, preL + count, inL, inL + count -1);
        node.right = reConstructBinaryTree(pre, in, preL + count +1, preR, inL + count + 1, inR);
        return node;
    }

    public void Inorder(TreeNode root) {
        if (root == null) {
            return ;
        }
        Inorder(root.left);
        System.out.println(root.val);
        Inorder(root.right);
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        ReConstructBinaryTree obj = new ReConstructBinaryTree();
        TreeNode treeNode = obj.reConstructBinaryTree(pre, in);
        obj.Inorder(treeNode);
    }
}
