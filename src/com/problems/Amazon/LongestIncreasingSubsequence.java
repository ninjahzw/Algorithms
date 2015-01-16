package com.problems.Amazon;

/**
 * Created by Zhaowei on 1/15/2015.
 */
public class LongestIncreasingSubsequence {

    /**
     * Do not need to be consecutive
     * @param source
     * @return
     */
    public int[] lis(int[] source){
        int max = 0;
        int[] result =  new int[2];
        if (source == null || source.length < 1){
            return null;
        }
        int[] dp = new int[source.length];
        int[] pre = new int[source.length];
        // initialize pre to be itself.
        for (int i = 0 ;i < source.length; i++){
            pre[i] = i;
        }
        dp[0] = 1;
        for (int i = 1; i < source.length; i++){

            for (int j = i - 1; j >= 0; j--){
                if (source[i] >= source[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    // for each element, the pre value always set to the smallest of current sequence.
                    pre[i] = pre[j];
                    if (dp[i] > max){
                        max = dp[i];
                        result[0] = pre[i];
                        result[1] = i;
                    }
                }
            }
        }
        return result;
    }

    /**
     * when it must be consecutive.
     * this case is simpler BUT more edge cases needed to be taken into consideration!
     * @param source
     * @return
     */
    public int[] lisCons(int[] source){
        int max = 0;
        int cur = 0;
        int start = 0;
        int[] result =  new int[2];
        if (source == null || source.length < 1){
            return null;
        }
        int pre = source[0];
        for (int i = 0; i < source.length; i++){
            if (source[i] > pre){
                cur += 1;
            } else {
                if (cur > max){
                    result[0] = start;
                    result[1] = i-1;
                    max = cur;
                }
                start = i;
                cur = 0;
            }
            pre = source[i];
        }

        // NOTE: Most  Important!!!!! Miss this part, the whole is wrong.
        if (cur > max){
            result[0] = start;
            result[1] = source.length-1;
            max = cur;
        }
        return result;
    }

    public static void main(String[] args){
        int[] result = new LongestIncreasingSubsequence().lisCons(new int[]{10,2,3,8,4,5,6,4,1,2,3,4});
        System.out.println(result[0] + " " + result[1]);
    }
}
