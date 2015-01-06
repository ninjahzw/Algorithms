package com.problems.Tests;

/**
 * Created by Zhaowei on 1/5/2015.
 */
public class StringSplit {

    public static void main(String[] args){
        String a = "11.12.13";
        String[] b = a.split("\\.");
        String[] c = a.split("\\.", 2);
        for (String x : b){
            System.out.println(x);
        }
        System.out.println("-----------------------");
        for (String x : c){
            System.out.println(x);
        }
    }
}
