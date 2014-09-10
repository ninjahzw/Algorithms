package com.leetcode.bitwise_operation;

/**
 * Created by houzhaowei on 9/9/14.
 *
 * Problem:
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Idea:
 * The key to solve this problem is bit manipulation.
 * Using the feature of XOR
 * XOR will return 1 only on two different bits. So if two numbers are the same, XOR will return 0.
 * Finally only one number left.
 * because
 * a XOR b XOR c = a XOR (b XOR c)  which means the order of the operation does not affect.
 * is right, so we can just simply XOR all elements of the array and the final number will be the result!
 *
 */
public class SingleNumber {

    public int singleNumber(int[] A) {
        int x=0;

        for(int a: A){
            x = x ^ a;
        }

        return x;
    }

    public static void main(String[] args){
        System.out.println(new SingleNumber().singleNumber(new int[]{4, 2, 3, 3, 2}));
    }
}
