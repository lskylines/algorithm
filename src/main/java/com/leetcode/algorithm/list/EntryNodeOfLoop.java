package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @ ClassName EntryNodeOfLoop
 * @ author lskyline
 * @ 2021/4/10 22:53
 * @ Version: 1.0
 */
public class EntryNodeOfLoop {
    /*
     * 链表中环的入口结点
     */
    public static ListNode entryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
