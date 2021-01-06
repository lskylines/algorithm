package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @author lskyline
 * @ 2021/1/6 22:45
 */
public class MergeTwoLists {
    /*
     * Description : LeetCode 21
     *
     * Merge two sorted linked lists and return it as a sorted list.
     * The list should be made by splicing together the nodes of the first two lists.
     */

    /**
     * 解题思路:
     *          1. 如果l1链表不为空，l2为空，直接返回l1
     *          2. 如果l2链表不为空, l1为空, 直接返回l2
     *          3. 如果l1, l2都不为空，设置哨兵节点， 比较 l1.val与 l2.val的值，值相对小的指向哨兵节点后面，同时哨兵节点往后移动
     *              如果其中一个链表到达末尾了，退出循环， 将不为空的链表指向在哨兵节点后面
     * @param l1 l1链表
     * @param l2 l2链表
     * @return ListNode
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //如果l1链表为空，直接返回l2
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //设置哨兵节点
        ListNode sentinelNode = new ListNode(-1);
        //保存哨兵节点,用于返回
        ListNode saveSentinelNode = sentinelNode;
        //如果两个链表都不为空
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                sentinelNode.next = l1;
                l1 = l1.next;
            } else {
                sentinelNode.next = l2;
                l2 = l2.next;
            }
            sentinelNode = sentinelNode.next;
        }
        if (l1 == null) {
            sentinelNode.next = l2;
        }
        if (l2 == null) {
            sentinelNode.next = l1;
        }
        return saveSentinelNode.next;
    }

    /**
     * 解题思路: 递归法
     * @param l1 l1链表
     * @param l2 l2链表
     * @return  ListNode
     */
    public ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists02(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists02(l1, l2.next);
            return l2;
        }
    }
}
