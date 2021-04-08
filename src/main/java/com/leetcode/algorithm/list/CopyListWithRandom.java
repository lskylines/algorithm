package com.leetcode.algorithm.list;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName CopyListWithRandom
 * @ author lskyline
 * @ 2021/4/8 8:44
 * @ Version: 1.0
 */
public class CopyListWithRandom {

    public static class Node {
        public Node next;
        public Node random;
        public int val;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next, Node random, int val) {
            this.next = next;
            this.random = random;
            this.val = val;
        }
    }

    /**
     * 链表复制
     * 1) 使用散列实现
     * 2) 不使用散列实现
     */

    public static Node copyListWithHash(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyList(Node head) {
        if (head == null) {
            return null;
        }
        Node curNode = head;
        Node nextNode = null;
        Node randomNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = new Node(curNode.val);
            curNode.next.next = nextNode;
            curNode = nextNode;
        }

        curNode = head;
        while (curNode != null) {
            nextNode = curNode.next.next;
            randomNode = curNode.random;
            curNode.next.random = randomNode != null ? randomNode.next : null;
            curNode = nextNode;
        }

        curNode = head;
        Node res = head.next;
        Node curCopy = null;
        while (curNode != null) {
            nextNode = curNode.next.next;
            curCopy = curNode.next;
            curNode.next = nextNode;
            curCopy.next = nextNode != null ? nextNode.next : null;
            curNode = nextNode;
        }
        return res;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        node.random = node.next.next.next;
        node.next.random = node.next.next;
    }

}
