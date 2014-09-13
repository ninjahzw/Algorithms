package com.leetcode.LinkedList;

/**
 * Created by Hou Zhaowei on 9/13/14.
 *
 * Problem:
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * Idea:
 *
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode startHead1 = new ListNode(0);
        ListNode resultHead1 = new ListNode(0);// keeps values < x
        startHead1.next = resultHead1;// remember the start point of head to for the last returning.
        ListNode startHead2 = new ListNode(0);
        ListNode resultHead2= new ListNode(0);// keeps values >= x
        startHead2.next = resultHead2; // remember the start point of head to for the last joining.
        ListNode traverser = new ListNode(0);
        traverser.next = head;
        while (traverser.next != null){
            traverser = traverser.next;
            if (traverser.val < x){
                resultHead1.next = new ListNode(traverser.val);
                resultHead1 = resultHead1.next;
            } else {
                resultHead2.next = new ListNode(traverser.val);
                resultHead2 = resultHead2.next;
            }

        }

        // join two partitions together.
        resultHead1.next = startHead2.next.next;
        return startHead1.next.next;

    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode tmp = new ListNode(0);
        tmp.next = new PartitionList().partition(node1,3);
        while (tmp.next != null){
            tmp = tmp.next;
            System.out.println(tmp.val);
        }

    }
}
