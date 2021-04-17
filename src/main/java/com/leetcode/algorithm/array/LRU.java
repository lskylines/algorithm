package com.leetcode.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName LRU
 * @ author lskyline
 * @ 2021/4/17 19:18
 * @ Version: 1.0
 */
public class LRU {
    /*
     * LRU算法实现
     */
    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> last;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public NodeDoubleLinkedList() {
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
                newNode.last = this.tail;
                this.tail.next = newNode;
                this.tail = newNode;
            }
        }

        public void moveNodeToTail(Node<K, V> node) {
            if (this.tail == node) {
                return ;
            }
            if (this.head == node) {
                this.head = node.next;
                this.head.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            this.tail.next = node;
            node.next = null;
            this.tail = node;
        }

        public Node<K, V> removeHead() {
            if (this.head == null) {
                return null;
            }
            Node<K, V> res = this.head;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }
    }

    public static class MyCache<K, V> {
        private Map<K, Node<K, V>> map;
        private NodeDoubleLinkedList<K, V> nodeList;
        private int capacity;

        public MyCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("should be more than 0");
            }
            this.map = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList<>();
            this.capacity = capacity;
        }

        public V get(K key) {
            if (this.map.containsKey(key)) {
                Node<K, V> res = this.map.get(key);
                this.nodeList.moveNodeToTail(res);
                printList(this.nodeList.head);
                return res.value;
            }
            return null;
        }

        public void set(K key, V value) {
            if (this.map.containsKey(key)) {
                Node<K, V> node = this.map.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            } else {
                Node<K, V> newNode = new Node<K, V>(key, value);
                this.map.put(key, newNode);
                this.nodeList.addNode(newNode);
                if (this.map.size() == this.capacity + 1) {
                    this.removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache() {
            Node<K, V> removeNode = this.nodeList.removeHead();
            K key = removeNode.key;
            this.map.remove(key);
        }

        public void printList(Node<K, V> node) {
            while (node != null) {
                System.out.println("key:" + node.key + ", value:" + node.value);
                node = node.next;
            }
        }

    }



    public static void main(String[] args) {
        MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println("==========================");
        System.out.println(testCache.get("A"));
        System.out.println("==========================");
        testCache.set("D", 4);
        System.out.println("==========================");
        System.out.println(testCache.get("D"));
        System.out.println("==========================");
        System.out.println(testCache.get("C"));
    }
}
