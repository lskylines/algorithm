package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ ClassName SortList
 * @ author lskyline
 * @ 2021/4/26 21:38
 * @ Version: 1.0
 */
public class SortList {
    /*
     * 排序链表
     * 1) 归并排序（自顶向下)
     * 2) 归并排序(自底向上) TODO
     * 3) 小顶堆
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //找到中点
        ListNode middleNode = findMiddle(head);
        ListNode rightNode = middleNode.next;
        middleNode.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);
        ListNode res = mergeTwoList(left, right);
        return res;
    }

    public ListNode sortList03(ListNode head) {
        if (head == null) {
            return head;
        }
        Queue<Integer> pq = new PriorityQueue<>();
        ListNode p = head;
        while (p != null) {
            pq.offer(p.val);
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode target = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = new ListNode(pq.poll());
            dummy.next = cur;
            dummy = dummy.next;
        }
        return target.next;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1 != null ? l1 : l2;
        return res.next;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        SortList obj = new SortList();
        ListNode res = obj.sortList03(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
