package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houzhaowei on 12/14/14.
 */
public class MissingRange {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (A == null || A.length == 0){
            result.add(lower + "->" + upper);
            return result;
        }
        if (A.length == 1){
            if (A[0] > lower && A[0] < upper){

            }
        }
        for (int i = 1; i < A.length ; i++){
            if (A[i] - A[i-1] > 1){
                String one = "";
                if (A[i] - A[i-1] == 2){
                    one += A[i] - 1;
                } else {
                    one += A[i-1] + 1 + "->" + (A[i] - 1);
                }
                result.add(one);
            }
        }
        return result;
    }

    public static void main(String[] args){

    }
}
