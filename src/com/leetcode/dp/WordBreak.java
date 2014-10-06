package com.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hou Zhaowei on 8/26/14.
 *
 * Problem:
 * Given a string s and a dictionary of words dict, determine if s can be segmented into
 * a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * Solution:
 * Use DP could be a more general solution to this kind of problems.
 * this solution can also handle the following combination:
 * dict = ["leetco", "leet", "code"]
 *
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] tmp = new boolean[s.length()+1];
        tmp[0] = true; //start from the initial state.

        for(int i=0; i<s.length(); i++){
            // always start from the end of former word in dict.
            if(tmp[i] == false) {
                continue;
            }

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length()) {
                    continue;
                }

                if(tmp[end]) {
                    continue;
                }

                if(s.substring(i, end).equals(a)){
                    // set the index of the end of word to be true so that can continue from here.
                    tmp[end] = true;
                }
            }
        }

        return tmp[s.length()];
    }

    public static void main(String[] args){
        String s = "abcdefg";
        Set<String> set = new HashSet<String>();
        set.add("fg");
        //set.add("abcde");
        System.out.println(new WordBreak().wordBreak(s,set));
    }
}
