package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @ ClassName DeleteNode
 * @ author lskyline
 * @ 2021/4/9 14:56
 * @ Version: 1.0
 */
public class DeleteNode {
    /**
     * O（1）的时间内删除链表节点
     */
    public ListNode deleteNode(ListNode head, ListNode toDeleteNode) {
        if (head == null || toDeleteNode == null) {
            return null;
        }
        if (toDeleteNode.next != null) {
            ListNode nextNode = toDeleteNode.next;
            toDeleteNode.val = nextNode.val;
            toDeleteNode.next = nextNode.next;
        } else {
            if (head == toDeleteNode) {
                head = null;
            } else {
                ListNode cur = head;
                while (cur.next != toDeleteNode) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }
}
