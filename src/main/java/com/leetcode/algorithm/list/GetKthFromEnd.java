package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @ ClassName GetKthFromEnd
 * @ author lskyline
 * @ 2021/5/1 23:17
 * @ Version: 1.0
 */
public class GetKthFromEnd {
    /*
     * 链表中倒数第k个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }




    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        GetKthFromEnd obj = new GetKthFromEnd();
        ListNode target = obj.getKthFromEnd(head, 1);
        System.out.println(target);
    }
}
