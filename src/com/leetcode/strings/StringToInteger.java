package com.leetcode.strings;

/**
 * Created by zhou001 on 8/25/2014.
 *
 * Problem:
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 *
 */
public class StringToInteger {

    public int atoi(String str) {
        long result = 0;
        if (str == null || str.length() < 1){
            return 0;
        }
        str = str.trim();

        if (str .length() < 1){
            return 0;
        }

        short sign = 1;
        int i = 0;

        if (str.charAt(0) == '-'){
            i++;
            sign = 0;
        } else if (str.charAt(0) == '+'){
            i++;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            result = result*10 + Integer.valueOf(str.charAt(i) - '0');
            i++;
        }

        if (sign == 0){
            result = -result;
        }

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)result;
    }


    public static String itoa(int x)     {
        boolean negative = false;
        String s = "";
        if (x == 0) return "0";
        negative = (x<0);
        if (negative) x = -1 * x; // must convert it to positive before reminder operation
        while (x != 0)   {
            s = (char)(48 + (x % 10)) + s; // add char to front of s
            x = x / 10; // integer division gives quotient
        }
        if (negative) s = "-" + s;
        return s;
    }

    public static void main(String[] args){
        System.out.println(new StringToInteger().atoi("+1"));
    }
}
