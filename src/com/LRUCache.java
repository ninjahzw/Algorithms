package com;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by houzhaowei on 11/29/14.
 * http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 */
public class LRUCache {
    private int capacity;
    Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    private ListNode head;
    private ListNode tail;
    private int size = 0;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }


    public int get(int key) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            this.removeNode(node);
            this.setToHead(node);
            return node.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            this.removeNode(node);
            this.setToHead(node);
        } else {
            ListNode node = new ListNode(key, value);
            // need to remove least recent used node.
            if (this.size >= this.capacity){
                if (null != tail){
                    map.remove(tail.key);
                    this.setToHead(node);
                    tail = tail.pre;
                    if (tail != null){
                        tail.next = null;
                    }
                    map.put(key, node);
                }
            } else {
                this.setToHead(node);
                map.put(key, node);
                size += 1;
            }
        }
    }

    private void removeNode(ListNode node){
        if (null != node.pre){
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
        if (null != node.next){
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    private void setToHead(ListNode node){
        node.next = head;
        node.pre = null;
        if (null != head){
            head.pre = node;
        }
        head = node;
        // initialize tail
        if (tail == null){
            tail = head;
        }
    }


    private class ListNode{
        private int key;
        private int val;
        private ListNode pre;
        private ListNode next;

        private ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(1, 1);
        System.out.println(cache.get(2));
        cache.set(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
