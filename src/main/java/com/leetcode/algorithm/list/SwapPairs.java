package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.util.Stack;

/**
 * @author lskyline
 * @ 2021/1/7 23:47
 *
 */
public class SwapPairs {
    /*
     * Description: leetcode 24
     * Given a linked list, swap every two adjacent nodes and return its head.
     */

    /**
     * 解题思路: 反转链表
     * @param head 链表头节点
     * @return ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //设置哨兵节点
        ListNode node = new ListNode(-1);
        ListNode pre = node;
        node.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;
            ListNode nextNode = l2.next;
            l1.next = nextNode;
            l2.next = l1;
            pre.next = l2;
            pre = l1;
        }
        return node.next;
    }

    public ListNode swapPair02(ListNode head) {
        if (head == null || head.next ==null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode dummyNode = new ListNode(-1);
        ListNode target = dummyNode;
        dummyNode.next = head;
        ListNode curNode = head;
        ListNode nextNode = null;
        while (curNode != null && curNode.next != null) {
            stack.push(curNode);
            stack.push(curNode.next);
            curNode = curNode.next.next;
            while (!stack.isEmpty()) {
                nextNode = stack.pop();
                nextNode.next = dummyNode.next;
                dummyNode.next = nextNode;
                dummyNode = dummyNode.next;
            }
        }
        dummyNode.next = curNode;
        return target.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        SwapPairs obj = new SwapPairs();
        ListNode dummyNode = obj.swapPair02(root);
        while (dummyNode != null) {
            System.out.println(dummyNode.val);
            dummyNode = dummyNode.next;
        }
    }
}
