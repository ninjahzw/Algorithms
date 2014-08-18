package com.problems;

import java.util.Stack;

/**
 * Created by Zhaowei on 8/14/2014.
 * ------------
 * Problem:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * Solution:
 * Use stack to solve this problem
 *
 */
public class EvaluateReversePolishNotation {

    public static String operators = "+-*/";
    public static int ERROR_VALUE = -1000;

    public static int calculate(String[] tokens){
        Stack<String> stack = new Stack<String>();
        for (String one : tokens){
            if (operators.contains(one)){
                // there should be at least 2 value in the stack
                if (stack.empty()){
                    System.out.println("Error occurred when parsing");
                    return ERROR_VALUE;
                }
                int first = Integer.parseInt(stack.pop());

                if (stack.empty()){
                    System.out.println("Error occurred when parsing");
                    return ERROR_VALUE;
                }
                int second = Integer.parseInt(stack.pop());

                // Attention! 'second' must be 'before' first in the following calculation!
                // because 'stack' reverse the order!
                switch (operators.indexOf(one)){
                    case 0:
                        stack.push(String.valueOf(second+first));
                        break;
                    case 1:
                        stack.push(String.valueOf(second-first));
                        break;
                    case 2:
                        stack.push(String.valueOf(second*first));
                        break;
                    case 3:
                        stack.push(String.valueOf(second/first));
                        break;
                }


            } else {
                stack.push(one);
            }
        }
        return Integer.valueOf(stack.pop());
    }



    public static void main (String[] args){
        String[] test = {"0","3","/"};
        System.out.println(EvaluateReversePolishNotation.calculate(test));
    }

}
