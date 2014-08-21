package com.leetcode;

/**
 * TODO!!!
 *
 *
 * Created by Zhaowei on 8/18/2014.
 *
 * Problem:
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Solution:
 *
 * This is the special case of the "Find the k-th Smallest Element in the Union of Two Sorted Arrays" problem,
 * where k = (A.length + B.length)/2
 *
 * Solution to k-th Smallest Element problem:
 *
 * If we pick two elements, A[i] and B[j], and look at the bigger of the two, let it be A[i],
 * we know that it is at least the i+j smallest element in A∪B.
 * Why? Because it is bigger than everything in A[1..i−1] and B[1..j], and the amount of elements in those two is equal to i+j.
 *
 * What about the smaller of the two, B[j]?
 * We can say that it’s at most the i+j−1 smallest element in A∪B.
 * Why? Because A[i+1..n],B[j..n] are all bigger than it.
 *
 * Now if k<i+j, we can say for sure that our kth smallest element is not A[i] or any of A’s elements after it.
 * Similarly, if k≥i+j, that rules out B[1..j].
 *
 * We start at A[⌊n/2⌋],B[⌊n/2⌋], and depending on who’s bigger,
 * we use the above observations to rule out either the bottom or top half of one of the arrays.
 * If we rule the top of an array, we go back to our original problem only one of the arrays has shrunk in half.
 * If we rule out the bottom, we now have to find the (k− number of elements thrown) smallest element in the halved array and the untouched one.
 *
 * We are done when one of the arrays is empty, then we simply return the kth element in the other one.
 * It should be fairly obvious why this takes Θ(lgn). At each step of the algorithm we do a constant amount of work,
 * and our recursion call loses half an array (similar to binary search).
 *
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {


        return -1;
    }


    public double findKthSmallest(int A[], int startA, int endA, int B[], int startB, int endB, int k){

        int i = (endA + startA) / 2;
        int j = (endB - startB) / 2;

        if (A[i] >= B[j]){

        }
        return 1;
    }

}
