package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.util.Stack;

/**
 * @author lskyline
 * @ 2021/1/9 0:48
 *
 */
public class AddTwoNumbers {
    /*
     * Description : leetcode445
     * You are given two non-empty linked lists representing two non-negative integers.
     * The most significant digit comes first and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     */

    /**
     *  解题思路: 分别将两个链表添加到栈中， 此时栈顶存储的值分别时链表的尾节点值 -> 链表头节点的值
     *          如果栈1、栈2、以及进位值都不为0， 此时进入循环
     *          取出栈1 + 栈2 + 进位值创建一个新节点， 采用头插法插入， 最终组成的新链表即为所求
     * @param l1 链表1
     * @param l2 链表2
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1 , ListNode l2) {
        Stack<Integer> stack1 = buildStack(l1);
        Stack<Integer> stack2 = buildStack(l2);
        //创建哨兵节点
        ListNode node = new ListNode(-1);
        ListNode curNode = node;
        //存储进位值
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + carry;
            //头插法
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = curNode.next;
            curNode.next = newNode;
            carry = sum / 10;
        }
        return node.next;
    }

    public ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null)  {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //利用链表反转后，节约了O（N）的存储空间
        ListNode dummyNode = new ListNode(-1);
        ListNode head1 = reverseNode(l1);
        ListNode head2 = reverseNode(l2);
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            int num1 = head1 != null ? head1.val : 0;
            int num2 = head2 != null ? head2.val : 0;
            int sum = num1 + num2 + carry;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = dummyNode.next;
            dummyNode.next = newNode;
            carry = sum / 10;
            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null;
        }
        return dummyNode.next;
    }

    private ListNode reverseNode(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    /**返回组装进栈的链表值*/
    private Stack<Integer> buildStack(ListNode node) {
        Stack<Integer> stack = new Stack<Integer>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }
}
