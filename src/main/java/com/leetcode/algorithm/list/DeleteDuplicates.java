package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @author lskyline
 * @ 2021/1/6 23:06
 *
 */
public class DeleteDuplicates {
    /*
     *  Description : LeetCode 83
     *  Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     *  Return the linked list sorted as well.
     *
     */

    /**
     * 解题思路:
     *      1. 如果链表是空链表或者只有一个节点的链表，直接返回
     *      2. 如果链表大于2个节点，循环判断curNode不为空，
     *          nextNode节点不为空且nextNode.val  == curNode.val,将nextNode节点往后移动,
     *          当nextNode.val != curNode.val， 将curNode下一个节点指向nextNode, 同时将curNode置为nextNode
     *          直到循环退出，此时已经是一个无重复元素的链表
     * @param head 链表
     * @return ListNode 删除重复元素后的链表头
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        ListNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            while (nextNode != null && curNode.val == nextNode.val) {
                nextNode = nextNode.next;
            }
            curNode.next = nextNode;
            curNode = nextNode;
        }
        return head;
    }

    public ListNode deleteDuplicates02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        while (curNode != null) {
            if (curNode.next== null) {
                break;
            }
            if (curNode.next.val == curNode.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }

    /**
     * 解题思路: 递归法
     * @param head 链表
     * @return ListNode 删除重复元素后的链表头
     */
    public ListNode deleteDuplicates03(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates03(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
