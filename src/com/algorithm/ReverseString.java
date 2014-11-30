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

    /**
     * One simple approach is a two-pass solution: First pass to split the string by spaces into an array of words,
     * then second pass to extract the words in reversed order.
     * We can do better in one-pass. While iterating the string in reverse order,
     * we keep track of a word’s begin and end position. When we are at the beginning of a word,
     * we append it.
     * @para
     * @return
     */
    public String reverseWordsEfficient(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }


    public static void main(String[] args){
        System.out.println(new ReverseString().reverseWords("  "));
    }
}
