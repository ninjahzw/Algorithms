package com.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by houzhaowei on 8/10/14.
 *
 * Problem
 * Sort a linked list in O(n log n) time using constant space complexity.
 * So
 *
 */
public class SortLinkedList {

    private static class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
            this.next = null;
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



    /**
     * for extra storage of Merge sort.
     */
    private static ListNode helper;

    private static List<String> list = new LinkedList<String>();

    public static void sort(ListNode startNode){
        int length = 0;
        helper = new SortLinkedList.ListNode(0);
        ListNode node = startNode;
        // initialize the length of the linked list.
        while (node.getNext() != null){
            length ++;
            node = node.getNext();
        }

        mergeSort(startNode,length);
    }


    private static void mergeSort(ListNode startNode, int length){
        if (startNode.getNext() != null){
            int middle = (length)/2;
            ListNode middleNode = startNode;
            int index = 0;
            while (middleNode.getNext() != null){
                if (index == middle){
                    break;
                }
                index ++;
                middleNode = middleNode.getNext();
            }
            mergeSort(startNode, middle);
            mergeSort(middleNode,length - middle);
            merge(startNode, middleNode, middle, length - middle);
        }
    }

    public static void merge(ListNode start, ListNode end, int lengthStart, int lengthEnd){
        int startIndex = 0, endIndex = 0, times = 0;
        // Create a traverser to traverse the
        ListNode traverser = helper;
        while (start.getNext() != null && startIndex < lengthStart && end.getNext() != null && endIndex < lengthEnd){

            if (start.getValue() > end.getValue()){
                ListNode newNode = new ListNode(end.getValue());
                traverser.setNext(newNode);
                traverser = newNode;
                end = end.getNext();
                endIndex ++;
            } else {
                ListNode newNode = new ListNode(start.getValue());
                traverser.setNext(newNode);
                traverser = newNode;
                start = start.getNext();
                startIndex ++;
            }

            while (startIndex < lengthStart){
                ListNode newNode = new ListNode(start.getValue());
                traverser.setNext(newNode);
                traverser = newNode;
                start = start.getNext();
                startIndex ++;
            }

            while (endIndex < lengthEnd){
                ListNode newNode = new ListNode(end.getValue());
                traverser.setNext(newNode);
                traverser = newNode;
                end = end.getNext();
                endIndex ++;
            }

            while (helper.getNext() != null){
                start.setNext(helper.getNext());
                helper = helper.getNext();
                start = start.getNext();
            }
        }
    }




    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        SortLinkedList.sort(node1);


    }

}
