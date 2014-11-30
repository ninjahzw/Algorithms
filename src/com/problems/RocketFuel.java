package com.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by houzhaowei on 11/18/14.
 */
public class RocketFuel {

    public void test(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/houzhaowei/files"));
            String line = br.readLine();
            while (null != line){
                if (map.get(line) != null){
                    int count = map.get(line);
                    map.put(line,count + 1);
                } else {
                    map.put(line,1);
                }
                line = br.readLine();
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if (null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Iterator<String> it = map.keySet().iterator();

    }

    public static void main(String[] args){
        System.out.println("This is the test");
    }
}
