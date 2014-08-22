package com.leetcode;

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
 * Solution:
 * Use HashMap to achieve O(n) otherwise its O(n^2)
 *
 */
public class LongestSubstrNoRepeat {

    public int lengthOfLongestSubstring(String s) {

        int longest = 0;
        char[] target = s.toCharArray();

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int times = 1;
        for (int i = 0 ; i < target.length; i ++){
            Integer current = map.get(target[i]);
            if ( current == null) {
                longest ++;
                map.put(target[i],times); // all set value to current times.
            } else {
                if (current == times){
                    longest = 1; // reset the result
                    times ++; // proceed to next round.
                    map.put(target[i],times);
                } else {

                    longest ++;
                    map.put(target[i],times);
                }
            }
        }

        return longest;
    }

    public static void main (String[] args){

        System.out.println (new LongestSubstrNoRepeat().lengthOfLongestSubstring("abcdeddffgdsnnf"));

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        System.out.println(map.get(1));
    }
}
