package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

/**
 * @ ClassName DeleteDuplicates02
 * @ author lskyline
 * @ 2021/4/10 10:21
 * @ Version: 1.0
 */
public class DeleteDuplicates02 {
    /**
     * 删除链表中重复的结点
     * 1) 递归  TODO 待完成
     * 2） 非递归
     * @param head
     * @return
     */

    public static ListNode deleteDuplicates(ListNode head) {
       if (head == null || head.next == null) {
           return head;
       }
       ListNode dummyNode = new ListNode(-1);
       dummyNode.next = head;

       ListNode curNode  = dummyNode.next;
       ListNode preNode = dummyNode;
       while (curNode != null) {
           while (curNode.next != null && curNode.val == curNode.next.val) {
               curNode = curNode.next;
           }
           if (curNode == preNode.next) {
               preNode = preNode.next;
           } else {
               preNode.next = curNode.next;
           }
            curNode = curNode.next;
       }
        return dummyNode.next;
    }

    public static void main(String[] args) {

    }
}
