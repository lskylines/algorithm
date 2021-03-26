package com.leetcode.algorithm.list;

/**
 * @ ClassName LinkedListAlgo
 * @ author lskyline
 * @ 2021/3/27 6:08
 * @ Version: 1.0
 */

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * 1) 单链表反转
 * 2） 链表中环的检测
 * 3) 两个有序的链表合并
 * 4） 删除链表倒数第N个节点
 * 5） 求链表的中间节点
 */
public class LinkedListAlgo {
    //单链表反转
    public static ListNode reverse(ListNode node) {
        ListNode preNode = null;
        ListNode curNode = node;
        ListNode nextNode = node.next;
        while (curNode.next != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    //环检测
    public static boolean  checkCircle(ListNode node) {
        if (node == null)
            return false;
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow  == fast)
                return true;
        }
        return false;
    }


    //有序链表的归并
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;
    }

    //删除倒数第K个节点
    public static ListNode deleteLastKth(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null)
            return head.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode findMiddleNode(ListNode list) {
        if (list == null)
            return null;
        ListNode fast = list;
        ListNode slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
