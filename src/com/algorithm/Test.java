package com.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: houzhaowei
 * Date: 8/11/13
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String dd[]){
        String a = "aaa";
        String b = "aaa";
        System.out.println(a==b);
        System.out.println(a.equals(b));
        String c = new String ("aaa");
        String d = new String ("aaa");
        System.out.println(c==d);
        System.out.println(c.equals(c));


    }
}
