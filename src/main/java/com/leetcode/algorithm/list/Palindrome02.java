package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @ ClassName Palindrome02
 * @ author lskyline
 * @ 2021/4/21 15:32
 * @ Version: 1.0
 */
public class Palindrome02 {

    public static class Pair <T, U>{
        private T t;
        private U u;

        public Pair(T t, U u) {
            this.t = t;
            this.u = u;
        }

        public T getLeft() {
            return t;
        }

        public U getRight() {
            return u;
        }
    }

    public  Pair<ListNode, Boolean> isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return new Pair<ListNode, Boolean>(null, true);
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //找到链表中点
        ListNode middleNode = findMiddle(slow, fast);
        //对中点链表进行反转
        ListNode lastNode = reverseList(middleNode);
        ListNode firstNoe = head;

        ListNode tempNode = lastNode;
        boolean flag = true;
        while (firstNoe != null) {
            if (firstNoe.val != lastNode.val) {
                flag  = false;
                break ;
            }
            firstNoe = firstNoe.next;
            lastNode = lastNode.next;
        }

        //将链表恢复原来状态
        reverseList(tempNode);
        return new Pair<ListNode, Boolean>(head, flag);
    }

    //对反转的链表进行恢复操作
    public  void recoverList(ListNode tempNode) {
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
    public  ListNode reverseList(ListNode middleNode) {
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
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        Palindrome02 obj = new Palindrome02();
        Pair<ListNode, Boolean> pair = obj.isPalindrome(root);
        System.out.println(pair.getRight());

        ListNode newNode = pair.getLeft();
        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
}
