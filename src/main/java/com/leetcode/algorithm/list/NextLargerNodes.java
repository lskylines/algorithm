package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ ClassName NextLargerNodes
 * @ author lskyline
 * @ 2021/5/1 23:45
 * @ Version: 1.0
 */
public class NextLargerNodes {
    /*
     * 链表中的下一个更大节点
     * 1） 单调栈
     */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[]{0};
        }
        List<Integer> ret = new ArrayList<>();
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        int[] res = new int[ret.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ret.size(); i++) {
            while (!stack.isEmpty() && ret.get(i) > ret.get(stack.peek())) {
                int index = stack.pop();
                res[index] = ret.get(i);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next= new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(1);
        NextLargerNodes obj = new NextLargerNodes();
        int[] res = obj.nextLargerNodes(head);
        System.out.println(Arrays.toString(res));
    }
}
