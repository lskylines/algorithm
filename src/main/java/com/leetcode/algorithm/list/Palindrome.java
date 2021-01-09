package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.util.Stack;

/**
 * @author lskyline
 * @ 2021/1/9 1:13
 *
 */
public class Palindrome {
    /*
     * Description : LeetCode 234
     *
     * Given a singly linked list, determine if it is a palindrome.
     */

    /**
     * 解题思路:
     *      将整个链表的节点值都放入一个栈中，将链表节点值与栈中取出的值相比较
     *      如果存在不相等，即为非回文字符串
     *      如果整个链表遍历结束，不存在不相等的值，即为回文字符串, 时间复杂度为O(n), 空间复杂度为O(n)
     * @param head 链表
     * @return boolean 是否为回文字符串
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = buildStack(head);
        while (!stack.isEmpty()) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    /**
     * 解题思路:
     *          将链表分割成两个链表,对后面链表进行反转 1->2->3->2->1 ====>  1->2  3<-2<-1 比较两个链表
     *                                          1->2->2->1  =====> 1->2 2<-1
     *          分割过程中，找到分割点位置，采用快慢指针思想， 快指针每次走两步，慢指针走一步
     *                  1. 如果是奇数节点，当fast指针为null时，slow指针刚好指向分割点，即第二个指针头节点
     *                  2. 如果是偶数节点，fast指针刚好会指向最后一个节点，不为null, 此时让slow继续往下走一个节点
     *          切割后，将切割后的第二个链表节点反转，返回的节点刚好是最后一个节点， 也就是反转后的头节点,比较两个链表
     *          时间复杂度为O(N), 空间复杂度为O(1)
     * @param head 链表
     * @return boolean 是否为回文字符串
     */
    public boolean isPalindrome02(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //慢指针
        ListNode slow = head;
        //快指针
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        //此时链表slow节点已经到达断链后的第二个链表第一个节点
        cut(head, slow);
        //反转切割后的第二个链表
        ListNode tailNode = reverseList(slow);
        boolean isPalind = assertEquals(head, tailNode);
        return isPalind;
    }

    /**比较两个链表值*/
    private boolean assertEquals(ListNode head, ListNode tail) {
        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    /**反转链表*/
    private ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode =nextNode;
        }
        return preNode;
    }

    /**分隔链表*/
    private void cut(ListNode head, ListNode slow) {
        while (head.next != slow) {
            head = head.next;
        }
        head.next = null;
    }



    private Stack<Integer> buildStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(0);
        listNode.next.next.next.next.next = new ListNode(1);
        System.out.println(new Palindrome().isPalindrome02(listNode));
    }


}
