package com.problems;

/**
 * Created by Zhaowei on 8/11/2014.
 *
 * Problem:
 *  Let's say you have a list of N+1 integers between 1 and N.
 *  You know there's at least one duplicate, but there might be more.
 *  For example, if N=3, your list might be 3, 1, 1, 3 or it might be 1, 3, 2, 2. Print out a number that appears in the list more than once.
 *  (That is, in the first example, you can print '1' or '3' -- you don't have to print both.)
 *
 *  Solution:
 *  Use heap, need extra space and time is O(n* log n)
 *
 *
 *  binary search for a duplicated number. For example,
 *  I go through the list and count the number of integers between 1 and N/2.
 *  If the count is greater than the number of possible integers in that range, then I know there's a duplicate in that range.
 *  Otherwise, a duplicate must exist in the range of N/2+1 to N.
 *  Once I know which half of the range the duplicate is in,
 *  I can recurse and binary search in that half, then keep repeating the process until I've found a duplicated number.
 *  The time complexity is O(n*log n) and the space complexity is O(1).
 *
 *  ----------------------------------
 *
 *  Other Mentioned
 *  given a list of n+1 numbers from [1,n] find the duplicate
 *  Naive: compare each pair - n^2 time and  constant space
 *  Better: Use a hashset. n time and n space
 *  Optimal: sum the numbers. n time and constant space  (Like counting sort!!)
 */
public class FindDupInList {

    public double findMedianSortedArrays(int A[], int B[]) {

        return 1;
    }
}
