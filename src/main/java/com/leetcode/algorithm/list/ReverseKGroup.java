package com.leetcode.algorithm.list;

import com.leetcode.algorithm.Heap.HeapSort;
import com.leetcode.algorithm.list.Node.ListNode;

import java.util.Stack;

/**
 * @ ClassName ReverseKGroup
 * @ author lskyline
 * @ 2021/5/17 21:37
 * @ Version: 1.0
 */
public class ReverseKGroup {
    /*
     * K 个一组翻转链表
     * 1) 借助栈
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        int len = getLength(head);
        ListNode currentNode = head;
        ListNode dumyNode = new ListNode(-1);
        ListNode res = dumyNode;
        Stack<ListNode> stack = new Stack<>();
        int time = len / k;
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < k; j++) {
                stack.push(currentNode);
                currentNode = currentNode.next;
            }
            while (!stack.isEmpty()) {
                ListNode popNode = stack.pop();
                popNode.next = dumyNode.next;
                dumyNode.next = popNode;
                dumyNode = dumyNode.next;
            }
        }
        dumyNode.next = currentNode;
        return res.next;
    }


    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseKGroup obj = new ReverseKGroup();
        ListNode target = obj.reverseKGroup(head, 3);
        while (target != null) {
            System.out.println(target.val);
            target = target.next;
        }
    }

}
