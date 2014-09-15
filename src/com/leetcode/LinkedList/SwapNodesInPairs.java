package com.leetcode.LinkedList;

/**
 * Created by Hou Zhaowei on 9/15/2014.
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * Idea:
 * !important!! Swapping two nodes in linked list.
 *
 *  Simple Python solution:
 class Solution:
 # @param a ListNode
 # @return a ListNode
 def swapPairs(self, head):
 pre = ListNode(0)
 pre.next = head
 cur = head
 head = pre
 while cur and cur.next:
 pre.next = cur.next
 cur.next = pre.next.next
 pre.next.next = cur
 pre = cur
 cur = cur.next
 return head.next
 *
 *
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode resultHead = new ListNode(0);
        ListNode traverser = new ListNode(0);
        traverser.next = head;
        resultHead.next = head;
        int index = 1;
        int previous = 0;
        while (traverser.next != null){ // current node is traverser.next
            if (index % 2 == 1 && traverser.next.next != null){ // only operate on odd elements
                ListNode tmp = traverser.next.next;
                traverser.next.next = traverser.next.next.next;
                tmp.next = traverser.next;
                traverser.next = tmp;
                if (index == 1){
                    resultHead.next = traverser.next;
                }
            }
            index ++;
            traverser = traverser.next;
        }

        return resultHead.next;
    }

    public ListNode simplerSwapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur= head;
        head = pre;
        while (cur != null && cur.next != null){
            pre.next = cur.next;
            cur.next = pre.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return head.next;
    }


    public static void main(String[] args){
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = new SwapNodesInPairs().simplerSwapPairs(node1);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
