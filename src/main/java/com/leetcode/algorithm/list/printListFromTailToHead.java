package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ ClassName printListFromTailToHead
 * @ author lskyline
 * @ 2021/4/9 6:53
 * @ Version: 1.0
 */
public class printListFromTailToHead {

    /*
     * 从尾到头打印链表
     *  1) 使用栈进行存储，遍历链表，满足后进先出
     *  2） 反转链表，遍历链表进行打印
     *  3） 使用递归
     */

    private List<Integer> result = new ArrayList<>();

    public List<Integer> printListFromTailToHead(ListNode head) {
        if (head == null) {
           return result;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }
        return result;
    }

    public List<Integer> printListFromTailToHead02(ListNode head) {
        if (head == null) {
            return result;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        while (pre != null) {
            result.add(pre.val);
            pre = pre.next;
        }
        return result;
    }

    public List<Integer> printListFromTailToHead03(ListNode head) {
        List<Integer> res = new ArrayList<>();
        if (head != null) {
            res.addAll(printListFromTailToHead03(head.next));
            res.add(head.val);
        }
        return res;
    }

    public void printListFromTailToHeadTest(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                printListFromTailToHead03(head.next);
            }
            System.out.println(head.val);
        }
    }

    public static void main(String[] args) {
        printListFromTailToHead obj = new printListFromTailToHead();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        List<Integer> result = obj.printListFromTailToHead02(head);
        System.out.println(result);
    }
}
