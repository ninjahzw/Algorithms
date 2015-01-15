package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * Problem:
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Idea:
 * this is a sorting problem, how to compare two elements is the most important and fundamental part.
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        String result = "";
        // convert to String array
        String[] numString = new String[num.length];
        for (int i = 0; i < numString.length; i++){
            numString[i] = String.valueOf(num[i]);
        }
        Arrays.sort(numString, new Comparator<String>() {
            // NOTE Most important part
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for (int i = numString.length - 1; i >= 0; i--){
            result += numString[i];
        }

        // eliminate the case [0, 0] will result in "00"
        // just when the first digit of the result is 0 return 0.
        if (result.length() > 0 && result.charAt(0) != '0') {
            return result;
        }
        return "0";
    }

//    private class MyComparator implements Comparator<String>{
//        @Override
//        public int compare(String o1, String o2) {
//            return (o1 + o2).compareTo(o2 + o1);
//        }
//    }
}
