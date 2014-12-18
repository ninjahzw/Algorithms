package com.problems;

/**
 * Created by houzhaowei on 11/27/14.
 */
public class LongestAscSequence {


    public int solution(String s){
        int pre = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            int one = (int)s.charAt(i) - 48;
            System.out.println(one);
            if (i == 0){
                pre = one;
                sum = one;
                continue;
            }
            if (one >= pre){
                sum += one;
            } else {
                if (sum > maxSum){
                    maxSum = sum;
                }
                sum = one;
            }
            pre = one;
        }
        if (sum > maxSum){
            maxSum = sum;
        }
        return maxSum;
    }



    public static void main(String[] args){
        System.out.println(new LongestAscSequence().solution("1231234"));
    }
}
