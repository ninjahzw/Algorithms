package com.leetcode.dp;

/**
 * Created by houzhaowei on 11/23/14.
 */
public class EditDistance {


    public int editDistance(String s, String t){
        int[][] result = new int[s.length()+1][t.length()+1];
        for (int i = 1 ; i <= s.length(); i++){
            result[i][0] = i;
        }
        for (int j = 1 ; j <= t.length(); j++){
            result[0][j] = j;
        }

        for (int i = 1 ; i <= s.length(); i++){
            for (int j = 1 ; j <= t.length(); j++){
                result[i][j] = Math.min(result[i-1][j] + 1, Math.min( result[i][j-1] + 1, s.charAt(i-1) == t.charAt(j-1) ? result[i-1][j-1]:(result[i-1][j-1]+1) ));
            }
        }
        return result[s.length()][t.length()];
    }

    public static void main(String [] args){
        System.out.println(new EditDistance().editDistance("abcd","abcd"));
    }
}
