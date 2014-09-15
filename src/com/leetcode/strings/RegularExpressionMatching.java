package com.leetcode.strings;

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
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for(int i = 1; i <= m; i++){
            match[i][0] = false;
        }
        for(int j = 1; j <= n; j++){
            if(p.charAt(j - 1) == '*'){
                match[0][j] = match[0][j - 2];
            }else{
                match[0][j] = false;
            }
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j - 1) == '*'){
                    match[i][j] |= match[i][j - 2];
                    if(s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2)
                            == '.'){
                        match[i][j] |= match[i - 1][j];
                    }
                }else{
                    match[i][j] = ((s.charAt(i - 1) == p.charAt(j - 1) || p.
                            charAt(j - 1) == '.') && match[i - 1][j - 1]);
                }
            }
        }

        return match[m][n];
    }

    public boolean isMatch1(String s, String p) {

        if(p.length() == 0) {
            return s.length() == 0;
        }

        //p's length 1 is special case
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch1(s.substring(1), p.substring(1));

        }else{
            int len = s.length();

            int i = -1;
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch1(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println(new RegularExpressionMatching().isMatch1("aaba", "ab*a*b*a"));
    }
}
