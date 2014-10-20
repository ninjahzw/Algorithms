package com.problems;

import java.util.*;

/**
 * Created by Zhaowei on 9/22/2014.
 */
public class Test {


    private void assign(List a){
        a.add(10);
        a = new ArrayList();
        a.add(1);
        a.add(2);
    }

    public void test(){
        List a = new ArrayList();
        a.add(0);
        assign(a);
        System.out.println(a);
    }

    public static void main(String[] args){
//        StringBuffer a = new StringBuffer("123");
//        StringBuffer b = new StringBuffer("1");
//        b.append(a);
//        System.out.println(b.toString());
//        a = new StringBuffer("321");
//        System.out.println(b.toString());

//        ArrayList<Integer> a = new ArrayList<Integer>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//
//        ArrayList<Integer> b = new ArrayList<Integer>();
//        int x = 30;
//        b.add(x);
//        b.add(2);
//        b.add(3);
//
//        a.addAll(b);
//        b.add(0);
//        x = -1;
//        System.out.println(a);
//        ArrayList<Integer>  c = ( ArrayList<Integer>)a.clone();
//
//        a.remove(1);
//        x = -1;
//        System.out.println(c);
//        Map<String,String> map = new TreeMap<String, String>();
//        map.put(null, "");

        String a = "abcd";
        String b = a.replace("bc","BC");
        System.out.print(a + " " + b);
        new Test().test();
    }
}
