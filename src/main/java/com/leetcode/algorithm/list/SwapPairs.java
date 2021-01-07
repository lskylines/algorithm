package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @author lskyline
 * @ 2021/1/7 23:47
 *
 */
public class SwapPairs {
    /*
     * Description: leetcode 24
     * Given a linked list, swap every two adjacent nodes and return its head.
     */

    /**
     * 解题思路: 反转链表
     * @param head 链表头节点
     * @return ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //设置哨兵节点
        ListNode node = new ListNode(-1);
        ListNode pre = node;
        node.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;
            ListNode nextNode = l2.next;
            l1.next = nextNode;
            l2.next = l1;
            pre.next = l2;
            pre = l1;
        }
        return node.next;
    }
}
