package com.leetcode.array;

import java.util.*;

/**
 * Created by houzhaowei on 11/30/14.

 Problem:


 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].


 */
public class MergeIntervals {
    private class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1){
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++ ){
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end){
                Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
                // IMPORTANT
                pre = merged;
            } else {
                // means the previous merge end up here.
                result.add(pre);
                pre = cur;
            }
        }

        // add the last interval
        result.add(pre);

        return result;
    }

    private class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
}


