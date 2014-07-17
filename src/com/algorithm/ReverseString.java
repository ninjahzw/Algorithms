package com.algorithm;

/**
 * Created by houzhaowei on 5/15/14.
 */
public class ReverseString {


    public String reverseWords(String s) {

        if (s == null || (s = s.trim()).equals("")){
            return "";
        }

        String[] words = s.split("  *");
        for (int i = words.length - 1 ; i >= 0 ; i --){
            if (i == words.length - 1){
                s = words[i];
                continue;
            }
            s += " " + words[i];
        }
        return s;
    }

    public static void main(String[] args){
        System.out.println(new ReverseString().reverseWords("  "));
    }
}
