package com.leetcode;

/**
 * Created by Zhaowei on 9/11/2014.
 *
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true

 */
public class RegulaExpressionMatching {
    public boolean isMatch(String s, String p) {

        int i = 0, j = 0;
        char previousp = p.charAt(0);// always keep the previous value of p (for * calculation)
        boolean stared = false;
        while (i < s.length() || j < p.length()){
            if (i == s.length()-1){
                return true;
            }
            if (j == p.length()-1){

            }
            char ones = s.charAt(i);

            if (stared){
                if (previousp == ones){
                    i ++;
                    continue;
                } else {
                    stared = false;
                }
            }

            char onep = p.charAt(j);

            if (onep == '*'){ // this will consume 0 or more elements in p.
                stared = true;
            }
            if (ones == onep){
                if (ones == onep || onep == '.'){
                    continue;
                }
            }
            previousp = onep;
        }
        return true;
    }

    public static void main(String[] args){

    }
}
