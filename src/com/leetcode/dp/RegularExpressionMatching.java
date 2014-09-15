package com.leetcode.dp;

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
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        int i = 0, j = 0;
        char previousp = 'a';// always keep the previous value of p (for * calculation)
        boolean stared = false;
        while (i < s.length() || j < p.length()){

            if (i == s.length()){ // string i is over
                if (p.length() -1 - j <= 2){
                    if (p.charAt(p.length()-1) == '*'){
                        return true;
                    }
                    return false;
                } else {
                    return false;
                }

            }

            if (j == p.length()){ // string j is over
                if (!stared){
                    return false;
                }
            }

            char ones = s.charAt(i);
            char onep = p.charAt(j);


            if (!stared && onep == '*'){ // this will consume 0 or more elements in p.
                stared = true;
            }

            if (stared){
                if (previousp == ones || previousp == '.'){
                    i ++;
                    continue;
                } else {
                    stared = false;
                    j ++;
                    continue;
                }
            }

            if (ones == onep || onep == '.'){
                i ++; j ++;
                previousp = onep;
                continue;
            } else {
                if (j < p.length() - 1){
                    if (p.indexOf(j + 1) == '*') {
                        previousp = onep;
                        j++;
                        continue;
                    }
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new RegularExpressionMatching().isMatch("aaba","ab*a*c*a"));
    }
}
