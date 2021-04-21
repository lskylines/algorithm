package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @author lskyline
 * @ 2021/1/5 23:48
 *
 */
public class IntersectionNode {
    /**
     * Description : LeetCode 160
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     */

    /**
     * 解题思路: 首先遍历一次链表，求出A、B两个链表的长度， 如果A > B , 将A链表往前走(A-B)， 否则(B-A）
     *          如果链表A、B真的存在相交点、此时A、B一起往前走，一定会找出相交点
     * @param headA A链表
     * @param headB B链表
     * @return ListNode 返回的相交点节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //如果A、B节点都为空链表，此时不存在交点，直接返回空
        if (headA == null && headB == null) {
            return null;
        }
        //如果A、B节点其中一个为空链表，另一个不为空，不存在相交节点
        if (headA == null || headB == null) {
            return null;
        }
        int aLength = traverList(headA);
        int bLength = traverList(headB);
        if (aLength > bLength) {
            //如果A链表大于B链表的长度，A链表往前走
            headA = forward(headA, (aLength - bLength));
        }
        if (bLength > aLength) {
            //如果B链表大于A链表的长度，B链表往前走
            headB = forward(headB, (bLength - aLength));
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public ListNode getIntersectionNode02(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA != null ? tempA.next : headB;
            tempB = tempB != null ? tempB.next : headA;
        }
        return tempA;
    }

    private ListNode forward(ListNode node, int length) {
        for (int i=0 ; i < length; i++) {
            node = node.next;
        }
        return node;
    }

    /**遍历链表，求出长度 **/
    private int traverList(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length ++;
        }
        return length;
    }
}
