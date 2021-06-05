package com.leetcode.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName LRUCache
 * @ author lskyline
 * @ 2021/6/5 0:15
 * @ Version: 1.0
 */
public class LRUCache {
    /*
     * LRU 缓存机制
     */
    class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> pre;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    class DoubleLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;
        public DoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<K, V> newNode) {
            if (newNode == null) {
                return ;
            }
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.head.pre = newNode;
                newNode.next = this.head;
                this.head = newNode;

            }
        }

        public void moveNodeToHead(Node<K, V> node) {
            if (this.head == node) {
                return ;
            }
            if (this.tail == node) {
                this.tail = node.pre;
                node.pre = null;
            } else {
                node.next.pre = node.pre;
                node.pre.next = node.next;
            }
            node.next = this.head;
            this.head.pre = node;
            node.pre = null;
            this.head = node;
        }
        public Node<K, V> removeTail() {
            if (this.tail == null) {
                return null;
            }
            Node<K, V> res = this.tail;
            if (this.tail == this.head) {
                this.head = null;
                this.tail = null;
            } else {
                this.tail.pre.next = null;
                this.tail = res.pre;
                res.pre = null;
            }
            return res;
        }
    }


    private Map<Integer, Node<Integer, Integer>> map;
    private DoubleLinkedList<Integer, Integer> nodeList;
    private int capacity;

    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("...");
        }
        this.map = new HashMap<>();
        this.nodeList = new DoubleLinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            Node<Integer, Integer> res = this.map.get(key);
            this.nodeList.moveNodeToHead(res);
            return res.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node<Integer, Integer> node = this.map.get(key);
            node.value = value;
            this.nodeList.moveNodeToHead(node);
        } else {
            Node<Integer, Integer> newNode = new Node<Integer, Integer>(key, value);
            this.map.put(key, newNode);
            this.nodeList.addNode(newNode);
            if (this.map.size() == this.capacity + 1) {
                this.removeMostUnusedCache();
            }
        }
    }

    private void removeMostUnusedCache() {
        Node<Integer, Integer> removeNode = this.nodeList.removeTail();
        Integer key = removeNode.key;
        this.map.remove(key);
    }


    public static void main(String[] args) {
        LRUCache obj = new LRUCache(3);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.put(3, 3);

        obj.get(2);

        Node<Integer, Integer> list = obj.nodeList.head;
        while (list != null) {
            System.out.println(list.value);
            list = list.next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
