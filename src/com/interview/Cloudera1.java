package com.interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Zhaowei on 12/20/2014.
 */
public class Cloudera1 {

    private static String operators = "+*";
    private static int ERROR_VALUE = -1;

    public int solution(String S) {
        // skip bad values
        if (S == null || S.length() == 0){
            return -1;
        }
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < S.length(); i++){
            String one = "" + S.charAt(i);
            if (operators.contains(one)){
                // there should be at least 2 value in the stack
                if (stack.empty()){
                    return ERROR_VALUE;
                }
                int first = Integer.parseInt(stack.pop());

                if (stack.empty()){
                    return ERROR_VALUE;
                }
                int second = Integer.parseInt(stack.pop());
                int result = 0;
                switch (operators.indexOf(one)){
                    case 0:
                        result = second + first;
                        break;
                    case 1:
                        result = second * first;
                        break;
                }
                // in case overflow
                if (result > Integer.MAX_VALUE){
                    return -1;
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(one);
            }
        }
        /*
        At last there should be exactly one element left in the stack.
        This can also deal with empty input.
         */
        if (!(stack.size() == 1)){
            return -1;
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args){
        System.out.println(new Cloudera1().solution(""));
    }
}
