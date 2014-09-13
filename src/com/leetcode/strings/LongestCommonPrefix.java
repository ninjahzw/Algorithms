package com.leetcode.strings;

/**
 * Created by houzhaowei on 9/13/14.
 *
 * Problem:
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Idea:
 * I couldn't find any 'trick' in this problem, so I am going with the general idea:
 * Loop through the strings and start from the head of each string check equivalence.
 * for each char in the string, do the same until dis-equivalence is found.
 *
 * -- Pick one as a flag, the compare one by one to others.
 * -- Stop if the end of other string is reached or dis equivalence is found
 *
 *
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer("");
        if (strs == null || strs.length == 0){
            return "";
        }
        // pick one from the string array as a flag.
        char[] pickone = strs[0].toCharArray();

        for (int i = 0; i < pickone.length; i++){
            for (int j = 1; j < strs.length; j++){
                String str = strs[j];
                // if end of a string is reached or dis equivalence is found, then return.
                if (i == str.length() || str.charAt(i) != pickone[i]){
                    return sb.toString();
                }
            }
            sb.append(pickone[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String[] strs = new String[]{"aa","a"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

}
