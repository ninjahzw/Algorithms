package com.problems.Tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Zhaowei on 12/18/2014.
 */
public class LinkedHashMapTest {

    public static void main(String[] args){

        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        linkedHashMap.put(3,2);
        linkedHashMap.put(2,3);
        linkedHashMap.put(1,4);
        linkedHashMap.put(5,4);
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("------------------------------------");
        /*
        linked hash map will not reorder for this operation. (and also get operation)
         */
        linkedHashMap.put(5,1);
        Iterator it3 = linkedHashMap.keySet().iterator();
        while (it3.hasNext()){
            System.out.println(it3.next());
        }
        System.out.println("------------------------------------");
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(3,2);
        hashMap.put(2,3);
        hashMap.put(1,4);
        hashMap.put(5,4);

        Iterator it1 = hashMap.keySet().iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }

    }
}
