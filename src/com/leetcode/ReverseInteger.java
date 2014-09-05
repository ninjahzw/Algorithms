package com.leetcode;

/**
 * Created by HouZhaowei on 8/23/14.
 *
 * Problem:
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 *
 * Idea:
 * We definitely can use String or char array to do this job which is simple to human brain.
 * But here is a smarter method which is simple to computer, and is preferred in interview.
 *
 */
public class ReverseInteger {

    public int reverse(int x) {

        int result = 0;
        while (x != 0){ // this covers both positive and negative conditions.
            result = result * 10 + x % 10;
            x = x/10;
        }
        return result;
    }

    public static void main(String[] args){
        int i = -123;
        System.out.println(new ReverseInteger().reverse(i));
    }

}



