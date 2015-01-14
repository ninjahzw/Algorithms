package com.problems.Tests;

/**
 * Created by Zhaowei on 1/6/2015.
 */
public class General {
    public static void main(String[] args){
        int a = 1;
        int b = a;
        a = 2;
        System.out.println(a + " " + b);

        Integer c = new Integer(1);
        Integer d = c;
        c = new Integer(2);
        System.out.println(c + " " + d);
    }
}
