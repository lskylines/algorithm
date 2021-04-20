package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @author lskyline
 * @ 2021/1/6 0:23
 *
 */
public class ReverseList {
    /**
     * Description : leetcode 206
     * Reverse a singly linked list.
     */
    /**
     * 直接反转法
     * @param head 链表头节点
     * @return ListNode 反转后的链表头节点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode nextNode = head.next;
        while (cur != null) {
            nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }

    /**
     * 头插法
     * @param head 链表头节点
     * @return ListNode 反转后的链表头节点
     */
    public ListNode reverseList02(ListNode head) {
        //设置一个哨兵节点
        ListNode headNode = new ListNode(-1);
        ListNode curNode = head;
        ListNode nextNode = null;
        while(curNode != null) {
            nextNode  = curNode.next;
            curNode.next = headNode.next;
            headNode.next = curNode;
            curNode = nextNode;
        }
        //插入完成后，已经是一个完全反转的链表，哨兵节点下一个节点就是反转后的第一个节点
        return headNode.next;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList03(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList03(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
