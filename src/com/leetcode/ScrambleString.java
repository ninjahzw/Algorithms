package com.leetcode;

/**
 * Created by Zhaowei on 1/14/2015.
 * Problem:
 * https://oj.leetcode.com/problems/scramble-string/
 *
 * Idea:
 * http://www.lifeincode.net/programming/leetcode-scramble-string-java/
 */
public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        if (s1.equals(s2)){
            return true;
        }
        // NOTE, IMPORTANT
        // check if two strings are composed of same character
        // do not use sort and equal, use o(0) solution
        int[] chars = new int[26];
        for (int i = 0 ; i < s1.length(); i++){
            chars[s1.charAt(i) - 'a'] += 1;
            chars[s2.charAt(i) - 'a'] -= 1;
        }
        for (int c : chars){
            if (c != 0){
                return false;
            }
        }
        // recursion phase
        // check if each possible substring is valid
        // if one is valid, return true
        for (int i = 1 ; i < s1.length(); i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s1.length());
            // two cases:
            // 1. two sub-strings does not swap at this level
            if (isScramble(s11, s21) && isScramble(s12, s22))
                return true;
            // 2. two sub-strings swapped at this level
            // NOTE in this case, s2 has to be re-cut !!!
            s21 = s2.substring(0, s1.length() - i);
            s22 = s2.substring(s1.length() - i, s1.length());
            if (isScramble(s11, s22) && isScramble(s12, s21))
                return true;
        }

        return false;
    }
}
