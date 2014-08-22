package com.leetcode;

/**
 * Created by houzhaowei on 8/22/14.
 *
 * Problem:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 *
 * Solution:
 *
 *
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {
        char[] result = new char[s.length()];
        int index = 0;
        int i = 0;

        if (nRows >= 1){
            while (index < s.length()){
                result[i] = s.charAt(index);
                i ++;
                index += 4;
            }
        }
        if (nRows >= 2){
            index = 1;
            while (index < s.length()){
                result[i] = s.charAt(index);
                i ++;
                index += 2;
            }
        }
        if (nRows >= 3){
            index = 2;
            while (index < s.length()){
                result[i] = s.charAt(index);
                i ++;
                index += 4;
            }
        }
        return  String.valueOf(result);
    }

    public static void main(String[] args){
        String s = new String("PAYPALISHIRING");
        System.out.println(new ZigZagConversion().convert(s, 3));
    }
}
