package com.problems.Amazon;

/**
 * Created by Zhaowei on 1/15/2015.
 */
public class LongestIncreasingSubsequence {

    public int[] lis(int[] source){
        int max = 0;
        int[] result =  new int[2];
        if (source == null || source.length < 1){
            return null;
        }
        int[] dp = new int[source.length];
        int[] pre = new int[source.length];
        for (int i = 0 ;i < source.length; i++){
            source[i] = i;
        }
        dp[0] = 1;

        for (int i = 1; i < source.length; i++){

            for (int j = i - 1; j >= 0; j--){
                if (source[i] >= source[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    if (dp[i] > max){
                        max = dp[i];
                        pre[i] = pre[j];
                        result[0] = pre[i];
                        result[1] = i;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args){
        System.out.println(new LongestIncreasingSubsequence().lis(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
    }
}
