package com.leetcode.dp;

/**
 * Created by Hou Zhaowei on 9/15/14.
 *
 * Problem:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Ideas:
 * Use Dynamic Programming,
 * for each step, the stair could ether combine with the previous one or as a single step.
 * Ways to climb to ith stair is W(i) = W(i-1) + W(i-2)
 * where W(i-1) is when the ith stair is as a single step
 * and W(i-2) is when the ith stair is paired with the previous one.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] tmp = new int[n];
        if (n < 2){
            return 1;
        }
        tmp[0] = 1;
        tmp[1] = 2;
        for (int i = 2; i < n; i++){
            tmp[i] = tmp[i-1] + tmp[i-2];
        }
        return tmp[n-1];
    }

    public static void main(String[] args){
        System.out.println(new ClimbingStairs().climbStairs(1));
    }
}
