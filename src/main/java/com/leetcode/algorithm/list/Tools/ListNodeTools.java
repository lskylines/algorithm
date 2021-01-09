package com.leetcode.algorithm.list.Tools;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @author lskyline
 * @ 2021/1/10 0:07
 *
 */
public class ListNodeTools {
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("==========================");
    }
}
