package com.leetcode.LinkedList;

/**
 * !! Important
 * Not good at LinkedList, I will review this class frequently.
 *
 * Created by houzhaowei on 8/16/14.
 */
public class InsertionSortLinkedList {

//    public ListNode insertionSortList(ListNode head) {
//
//        int sortedCount = 0;
//
//        // one element list
//        if (head.next == null){
//            return head;
//        }
//        ListNode current = head.next;
//        ListNode traverser = head;
//        ListNode pre = new ListNode(0);
//        pre.next = head;
//        while (current != null){
//            int index = 0;
//            while (traverser != null){
//                if (current.val < traverser.val && index <= sortedCount){
//                    pre.next = current;
//                    current.next = traverser;
//                }
//                sortedCount ++;
//            }
//        }
//
//    }


    /**
     * Other people's solution, which seems simpler.
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        // this helper always pointed to the first element.
        ListNode helper=new ListNode(0);
        ListNode pre=helper;
        ListNode current=head;
        while(current!=null) {
            pre=helper;
            while(pre.next!=null&&pre.next.val<current.val) {
                pre=pre.next;
            }

            /**
             * !!
             * the following code segment shows how to insert nodes in linked list!
             */
            ListNode next=current.next;
            current.next=pre.next;
            pre.next=current;
            current=next;
        }
        return helper.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = new InsertionSortLinkedList().insertionSortList(node1);


    }
}
