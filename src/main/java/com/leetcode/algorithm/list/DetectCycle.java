package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ ClassName DetectCycle
 * @ author lskyline
 * @ 2021/4/26 20:06
 * @ Version: 1.0
 */
public class DetectCycle {
    /*
     * 环形链表 II
     * 1) 双指针
     * 2) 使用Set集合校验
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        do {
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            fastNode = fastNode.next.next;
            slowNode  =slowNode.next;
        } while (fastNode != slowNode);
        slowNode = head;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        return fastNode;
    }

    public ListNode detectCycle02(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode currentNode = head;
        Set<ListNode> set = new HashSet<>();
        while (currentNode != null) {
            //如果链表中存在换，会进入if语句中
            if (set.contains(currentNode)) {
                return currentNode;
            }
            set.add(currentNode);
            currentNode = currentNode.next;
        }
        //遍历完链表，不存在环， 返回null
        return null;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next.next = root.next;
        DetectCycle obj = new DetectCycle();
        ListNode res = obj.detectCycle(root);
        System.out.println(res.val);

    }
}
