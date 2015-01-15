package com.leetcode.LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by houzhaowei on 1/5/15.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 *
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (null == lists || lists.size() == 0){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val){
                    return 1;
                } else if(o1.val < o2.val){
                    return -1;
                } else{
                    return 0;
                }
            }
        });

        for (ListNode node : lists){
            if (null != node) {
                pq.add(node);
            }
        }
        while (pq.size() > 0){
            ListNode node = pq.remove();
            cur.next = node;
            if (node.next != null){
                pq.add(node.next);
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
