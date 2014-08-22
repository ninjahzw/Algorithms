package com.leetcode;

/**
 * Created by HouZhaowei on 8/21/14.
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Solution:
 * It seems stupid to return them back to integer then add two integers then transform the result to a linked list again.
 *
 * I gave the smarter solution that make use of the feature of the list to sum digit by digit and form up
 * to a new linked list (the result) simultaneously.
 *
 */
public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode traverser = result;
        int sum = 0;
        while (l1 != null || l2 != null){
            sum = sum / 10; // each time reduce the sum to units digit, ignore the rest.
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            traverser.next = new ListNode(sum % 10);
            traverser = traverser.next;

        }

        // this is in case that the sum of two final digits is greater than 10!
        if (sum / 10 == 1){
            traverser.next = new ListNode(1);
        }

        return result.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(2);
        l1.next = l11; l11.next = l12;

        ListNode l2 = new ListNode(2);
        ListNode l21 = new ListNode(8);
        ListNode l22 = new ListNode(3);
        l2.next = l21; l21.next = l22;


        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
