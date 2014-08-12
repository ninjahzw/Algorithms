package com.leetcode;

import java.util.LinkedList;

/**
 * Created by houzhaowei on 8/10/14.
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortLinkedList {

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args){

        LinkedList list = new LinkedList();

    }

}
