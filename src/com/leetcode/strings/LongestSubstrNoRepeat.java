package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HouZhaowei on 8/20/14.
 *
 * Problem:
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Solution:  (Dynamic Programming !?)
 * Use HashMap to achieve O(n) otherwise its O(n^2)
 *
 * Store the start of each segment that have no repeating characters,
 * if a repeated is found, check the LAST index of the repeated,
 * if the index is less than the start of current segment, then ignore it.
 * if not, start a new segment and check if the length of the previous segment is longer than the currently longest.
 *
 */
public class LongestSubstrNoRepeat {

    public int lengthOfLongestSubstring(String s) {

        if (s == null){
            return 0;
        }

        int longest = 0;
        int length = 0;
        char[] target = s.toCharArray();
        int currentStart = 0;

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0 ; i < target.length; i ++){
            Integer index = map.get(target[i]);
            if ( index == null) {
                length ++;
                map.put(target[i],i);
            } else {
                if (index >= currentStart){
                    if (length > longest){
                        longest = length;
                    }
                    // restart from the last index where the duplicate is found.
                    // NOT restart from current index.
                    currentStart = index + 1;
                    length = i - currentStart + 1;
                } else { // it appears before current start, so skip it.
                    length ++;
                }
                map.put(target[i],i);
            }
        }

        if (length > longest){
            longest = length;
        }

        return longest;

    }

    public static void main (String[] args){

        System.out.println (new LongestSubstrNoRepeat().lengthOfLongestSubstring("abcdefcg"));

    }
}
