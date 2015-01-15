package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HouZhaowei on 8/20/14.
 *
 * Problem:
 * Given a string, find the length of the longest substring without K repeating characters.
 */
public class LongestSubstrNoRepeatK {

    public int lengthOfLongestSubstring(String s, int k) {
        int[] count = new int[256];
        int lastIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++){
            int num = count[s.charAt(i)] += 1;
            // since can't remember the index of the repeated, need to do a while loop.
            while (num > k){
                if (s.charAt(lastIndex) == s.charAt(i)){
                    count[s.charAt(i)] --;
                    num -= 1;
                }
                lastIndex += 1;
            }
            maxLength = Math.max(i-lastIndex + 1, maxLength);
        }
        return maxLength;
    }

    public static void main (String[] args){

        System.out.println (new LongestSubstrNoRepeatK().lengthOfLongestSubstring("123", 2));

    }
}
