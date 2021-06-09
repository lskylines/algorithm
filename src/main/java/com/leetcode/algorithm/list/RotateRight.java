package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.util.Stack;

/**
 * @ ClassName RotateRight
 * @ author lskyline
 * @ 2021/6/8 22:13
 * @ Version: 1.0
 */
public class RotateRight {
    /*
     * 旋转链表
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        int len = getLength(head);
        k %= len;
        if (k == 0) {
            return head;
        }
        ListNode fastNode = forward(head, k);
        ListNode slowNode = head;
        ListNode newNode = null;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        newNode = slowNode.next;
        slowNode.next = null;
        fastNode.next = head;
        return newNode;
    }

    private ListNode forward(ListNode head, int n) {
        while (n -- > 0 && head  != null) {
            head = head.next;
        }
        return head;
    }

    private int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }







    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        RotateRight obj = new RotateRight();
        ListNode target = obj.rotateRight(head, 2);
        while (target != null) {
            System.out.println(target.val);
            target = target.next;
        }
    }
}
