package com.problems;

import java.util.Stack;

/**
 * Created by Zhaowei on 8/14/2014.
 * ------------
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

    public static char[] operators = {'+','-','*','/'};

    public static void calculate(String expression){
        Stack<Character> stack = new Stack<Character>();
        char[] chars = expression.toCharArray();
        for (char one : chars){

        }
        //stack.push()
    }

}
