package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @author lskyline
 * @ 2021/1/6 23:51
 *
 */
public class RemoveNthFromEnd {

    /*
     * Description:  LeetCode 19
     * Remove Nth Node From End of List
     */

    /**
     *  解题思路: 快慢指针思想
     *          1. 移除倒数第N个节点，设置一个fast快指针，slow慢指针, 先让fast指针往前走N步
     *             fast指针，slow指针同时向后移动，当fast指针走到最后一个节点时，slow指针已经到达要删除的目标节点前一个节点
     *             将slow指针下一个节点指向下下个节点即可
     * @param head 链表头
     * @param n   倒数第N
     * @return ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        //设置慢指针
        ListNode slow = head;
        //设置快指针
        ListNode fast = head;
        fast = forward(fast, n);
        if (fast == null) {
            //说明N已经大于整个链表长度，直接返回表头下一个节点即可
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //slow指针已经到达要删除的目标节点前一个节点，slow指针下一个节点指向下下个节点即可
        slow.next = slow.next.next;
        return head;
    }

    /**将fast指针往前走N步*/
    private ListNode forward(ListNode node, int n) {
        while (node != null && n-- > 0) {
            node = node.next;
        }
        return node;
    }
}
