package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.time.temporal.ChronoUnit;

/**
 * @ ClassName ReverseBetween
 * @ author lskyline
 * @ 2021/5/3 17:11
 * @ Version: 1.0
 */
public class ReverseBetween {
    /*
     * 反转链表 II
     */
    public ListNode reverseBetween(ListNode head, int from, int to) {
        int len = 0;
        ListNode fPre = null;
        ListNode tPost = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            len++;
            fPre = len == from - 1 ? currentNode : fPre;
            tPost = len == to + 1 ? currentNode : tPost;
            currentNode = currentNode.next;
        }
        if (from > to || from < 0 || to > len) {
            return head;
        }
        ListNode preNode = fPre == null ? head : fPre.next;
        ListNode current = preNode.next;
        ListNode nextNode = null;
        preNode.next = tPost;
        while (current != tPost) {
            nextNode = current.next;
            current.next = preNode;
            preNode = current;
            current = nextNode;
        }
        if (fPre != null) {
            fPre.next = preNode;
            return head;
        } else {
            return preNode;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseBetween obj = new ReverseBetween();
        int from  = 1;
        int to = 4;
        ListNode current = obj.reverseBetween(head, from, to);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
