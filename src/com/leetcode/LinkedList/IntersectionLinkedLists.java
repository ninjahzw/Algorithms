package com.leetcode.LinkedList;

/**
 * Created by houzhaowei on 11/29/14.
 *
 Write a program to find the node at which the intersection of two singly linked lists begins.

 For example, the following two linked lists:

 A:          a1 → a2
                     ↘
                      c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * Idea:
 *
 * Intuitive way: First count then two list start from longer list first move abs(length2-length1) steps.
 *
 * Better way:
 *
 * Two pointer solution (O(n+m) running time, O(1) memory):
 Maintain two pointers pA and pB initialized at the head of A and B, respectively.
 Then let them both traverse through the lists, one node at a time.
 When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.);
 similarly when pB reaches the end of a list, redirect it the head of A.

 NOTE !! if tailA == tailB then they surely meet, if not then surely not meet!
 *
 *
 */
public class IntersectionLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode fakeHeadA = headA;
        ListNode fakeHeadB = headB;
        ListNode tailA = null;
        ListNode tailB = null;
        while (true){
            if (fakeHeadA == null){
                fakeHeadA = headB;
            }
            if (fakeHeadB == null){
                fakeHeadB = headA;
            }

            // tail of A
            if (fakeHeadA.next == null){
                tailA = fakeHeadA;
            }
            // tail of B
            if (fakeHeadB.next == null){
                tailB = fakeHeadB;
            }

            if (tailA != null && tailB != null && tailA != tailB){
                return null;
            }

            if (fakeHeadB == fakeHeadA){
                return fakeHeadA;
            }

            fakeHeadA = fakeHeadA.next;
            fakeHeadB = fakeHeadB.next;

        }

    }

}
