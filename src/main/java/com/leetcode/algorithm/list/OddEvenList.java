package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.util.Stack;

/**
 * @author lskyline
 * @ 2021/1/10 0:43
 */
public class OddEvenList {
    /*
     * Description : LeetCode 328
     * Given a singly linked list, group all odd nodes together followed by the even nodes.
     * Please note here we are talking about the node number and not the value in the nodes.
     */
    /**
     * 解题思路:
     *        使用两个栈，其中一个存储奇数节点，另一个存储偶数节点
     *        使用哨兵节点，采用头插法，按照偶数栈、奇数栈插入
     *        空间复杂度O(N), 时间复杂度O(N)
     * @param head 链表头
     * @return ListNode
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> oddStack = buildStack(head);
        Stack<ListNode> evenStack = buildStack(head.next);
        //设置哨兵节点
        ListNode node = new ListNode(-1);
        //头插法
        headAdd(node, evenStack);
        headAdd(node, oddStack);
        return node.next;

    }

    /**时间复杂度O(N), 空间复杂度O(1)*/
    public ListNode oddEvenList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode even = evenNode;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;
        }
        oddNode.next = even;
        return head;
    }

    /**头插法，插入栈中的节点*/
    private void headAdd(ListNode node, Stack<ListNode> stack) {
        while (!stack.isEmpty()) {
            ListNode popNode = stack.pop();
            popNode.next = node.next;
            node.next = popNode;
        }
    }

    /**将链表节点存入栈中*/
    private Stack<ListNode> buildStack(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head !=null) {
            stack.push(head);
            if (head.next != null) {
                head = head.next.next;
            } else {
                break ;
            }
        }
        return stack;
    }
}
