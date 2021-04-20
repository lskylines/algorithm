package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @ ClassName FindKthToTail
 * @ author lskyline
 * @ 2021/4/10 11:57
 * @ Version: 1.0
 */
public class FindKthToTail {
    /**
     * 链表中倒数第 K 个结点
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (k-- > 0 && fastNode != null) {
            fastNode = fastNode.next;
        }
        if (k >= 0) {
            return null;
        }
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        FindKthToTail obj = new FindKthToTail();
        ListNode curNode = obj.findKthToTail(head, 0);
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }
}
