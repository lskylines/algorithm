package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @ ClassName OptPalindrome
 * @ author lskyline
 * @ 2021/4/7 18:25
 * @ Version: 1.0
 */
public class OptPalindrome {
    //判断是否回文字符串，优化
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //找到链表中点
        ListNode middleNode = findMiddle(slow, fast);
        //对中点链表进行反转
        ListNode lastNode = reverseList(middleNode);
        ListNode firstNoe = head;

        ListNode tempNode = lastNode;

        while (firstNoe != null) {
            if (firstNoe.val != lastNode.val) {
                return false;
            }
            firstNoe = firstNoe.next;
            lastNode = lastNode.next;
        }

        //将链表恢复原来状态
        recoverList(tempNode);
        return true;
    }

    //对反转的链表进行恢复操作
    public static void recoverList(ListNode tempNode) {
        ListNode pre = null;
        ListNode cur = tempNode;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    //对中点后的部分链表进行反转
    public static ListNode reverseList(ListNode middleNode) {
        ListNode preNode = null;
        ListNode nextNode = null;
        ListNode currentNode = middleNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode  = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    //查找链表中点
    public static ListNode findMiddle(ListNode slowNode, ListNode fastNode) {
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);
        boolean flag = isPalindrome(node);
        System.out.println(flag);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
