package com.leetcode.bitwise_operation;

/**
 * Created by houzhaowei on 9/8/14.
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Idea:
 * Use bit operation to solve this problem.
 *
 */
public class SingleNumber_II {

    /**
     * general Idea
     * for each bit in each element in array A, calculate the sum of this bit.
     * the result modulo 3 we can know if the "single" value we are looking for is 1 or 0 in this bit.
     * after the calculation, in the end we can get each bit of the single value, and thus can get the value itself.
     * @param A
     * @return
     */
    public int singleNumber_0(int A[]) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < count.length; i++){
            for (int j = 0; j < A.length; j++){
                count[i] += (A[j] >> i) & 1;// get the i-th bit of each value in the array
            }
            result |= (count[i] % 3) << i;// restore each bit of the result.
        }
        return result;
    }



//    public int singleNumber_0(int A[]) {
//        int[] count = new int[32];
//        int result = 0;
//        for (int i = 0; i < 32; i++) {
//            for (int j = 0; j < A.length; j++) {
//                if (((A[j] >> i) & 1) == 1) {
//                    count[i]++;
//                }
//            }
//            result |= ((count[i] % 3) << i);
//        }
//        return result;
//    }

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
