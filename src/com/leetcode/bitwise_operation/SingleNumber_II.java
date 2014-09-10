package com.leetcode.bitwise_operation;

/**
 * Created by houzhaowei on 9/8/14.
 */
public class SingleNumber_II {

    /**
     * general Idea
     * @param A
     * @return
     */
    public int singleNumber_0(int A[]) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }

    /**
     * Optimal solution
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0, threes;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }


    public static void main(String[] args){
        System.out.println(new SingleNumber_II().singleNumber_0(new int[]{1, 1, 1, 4, 2, 2, 2}));
    }

}
