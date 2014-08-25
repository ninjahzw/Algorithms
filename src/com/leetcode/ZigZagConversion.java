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
 * Idea:
 * What we need to do is to observe the pattern of each row.
 * It can be found that for each row, it has a period of 2∗nRows−2 ,
 * i.e., characters that are  2∗nRows−2 apart are in the same row.
 * The first character in the first period is s[i] , where i is the row index.
 * Except for the top and the bottom rows,
 * there is (possibly) a second character in each period that is period−2∗i apart from the first one.
 * With this pattern, we can work top-down and pick up characters at certain indices to make up the converted string.
 *
 * Wrap-up:
 * Little algorithmic insight is needed for this problem.
 *
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {
        if (nRows <= 1) { // ZigZag needs at least two rows
            return s;
        }
        int period = 2 * nRows - 2;
        int n = s.length();
        String result = "";
        // Scan each row
        for (int i = 0; i < nRows; i++) { // add each row
            for (int j = i; j < n; j += period) {
                result += s.charAt(j);
                // Possibly two characters in a period for all rows except the top and bottom one
                // The second character is period-2*j apart from the first
                if (i > 0 && i < nRows-1 && j+period-2*i < n) { // skip the first line and last line
                    result += s.charAt(j + period - 2 * i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        String s = new String("PAYPALISHIRING");
        System.out.println(new ZigZagConversion().convert(s, 3));
    }
}
