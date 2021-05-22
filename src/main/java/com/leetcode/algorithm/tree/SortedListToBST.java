package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.list.Node.ListNode;
import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName SortedListToBST
 * @ author lskyline
 * @ 2021/5/1 15:31
 * @ Version: 1.0
 */
public class SortedListToBST {
    /*
     * 有序链表转换二叉搜索树
     * 1) 分治
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next  == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode preNode = null;
        while (fast != null && fast.next != null) {
            preNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preNode.next = null;
        TreeNode newNode = new TreeNode(slow.val);
        newNode.left = sortedListToBST(head);
        newNode.right = sortedListToBST(slow.next);
        return newNode;
    }


    public TreeNode sortedListToBST02(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode middle = findMiddle(left, right);
        TreeNode root = new TreeNode(middle.val);
        root.left = buildTree(left, middle);
        root.right = buildTree(middle.next, right);
        return root;
    }

    private ListNode findMiddle(ListNode left, ListNode right) {
        ListNode slowNode = left;
        ListNode fastNode = left;
        while (fastNode != right && fastNode.next != right) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
