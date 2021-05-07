package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @author lskyline
 * @ 2021/1/16 14:28
 *
 */
public class Subtree {
    /**
     * Description : leetcode572   Subtree of Another Tree
     * Given two non-empty binary trees s and t,
     * check whether tree t has exactly the same structure and node values with a subtree of s.
     * A subtree of s is a tree consists of a node in s and all of this node's descendants.
     * The tree s could also be considered as a subtree of itself.
     */

    /**
     * 解题思路:
     *      1. 判断是否Tree s与Tree t都为空，如果都为空，满足
     *      2. 判断是否Tree s与Tree t其中一个为空，不满足
     *      3. 递归遍历左子树、右子树
     *          1. 对树s进行判断是否满足
     *          2. 对树s左子树进行判断是否满足
     *          3. 对树s右子树进行判断是否满足
     * @param s Tree s根节点
     * @param t Tree t根节点
     * @return  是否存在子树
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return traverseSubTree(s, t) || isSubtree(s.left, t) ||isSubtree(s.right, t);
    }

    public boolean isSubtree02(TreeNode s, TreeNode t) {
        String str1 =  preTraverse(s);
        String str2 = preTraverse(t);
        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);
        int res  = str1.indexOf(str2);
        System.out.println(res);
        return res != -1;
    }

    public static int getIndexOf(String s,String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi  == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos-1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    private String preTraverse(TreeNode s) {
        if (s == null) {
            return "#";
        }
        return String.valueOf(s.val > 10 ? s.val + ":" : s.val + "_") + preTraverse(s.left) + preTraverse(s.right);
    }

    /**遍历树，判断是否满足子树条件*/
    private boolean  traverseSubTree(TreeNode s, TreeNode t) {
        if (s == null && t ==null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return traverseSubTree(s.left, t.left) && traverseSubTree(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(1);
        s1.left= new TreeNode(2);

        TreeNode s2 = new TreeNode(1);

        Subtree obj = new Subtree();
        boolean res = obj.isSubtree02(s1, s2);
        System.out.println(res);
    }
}
