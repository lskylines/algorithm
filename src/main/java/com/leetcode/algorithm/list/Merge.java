package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @ ClassName Merge
 * @ author lskyline
 * @ 2021/4/10 23:07
 * @ Version: 1.0
 */
public class Merge {

    /*
     * 合并两个链表
     * 1）递归合并
     * 2）非递归合并
     */
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeUnRecv(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode curNode = new ListNode(-1);
        ListNode res = curNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        if (l1 != null) {
            curNode.next = l1;
        }
        if (l2 != null) {
            curNode.next = l2;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        ListNode res = mergeUnRecv(l1, l2);
        while (res != null) {
            System.out.print(res.val + "\t");
            res = res.next;
        }
    }
}
