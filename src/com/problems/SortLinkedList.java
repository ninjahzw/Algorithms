package com.problems;

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
    private static ListNode[] sortHelper = null;

    public static void sort(ListNode startNode){
        int length = 0;

        ListNode node = startNode;
        // initialize the length of the linked list.
        while (node.next != null){
            length ++;
            node = node.next;
        }

        mergeSort(startNode,length);
    }


    private static void mergeSort(ListNode startNode, int length){
        if (startNode.next != null){
            int middle = (length)/2;
            ListNode middleNode = startNode;
            int index = 0;
            while (middleNode.next != null){
                if (index == middle){
                    break;
                }
                index ++;
                middleNode = middleNode.next;
            }
            mergeSort(startNode, middle);
            mergeSort(middleNode,length - middle);
            merge(startNode, middleNode, middle, length - middle);
        }
    }

    public static void merge(ListNode start, ListNode end, int lengthStart, int lengthEnd){
        int startIndex = 0, endIndex = 0;

        while (start.next != null && startIndex < lengthStart && end.next != null && endIndex < lengthEnd){
            if (start.getValue() > end.getValue()){

            }
        }
    }




    public static void main(String[] args){

        LinkedList list = new LinkedList();


    }

}
