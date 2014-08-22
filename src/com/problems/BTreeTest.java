package com.problems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by zhou001 on 8/22/2014.
 */
public class BTreeTest {

    private class Node implements Comparable<Node>{

        public int start;
        public int end;
        public double priority;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
            this.priority = end - 2*start;
        }

        @Override
        public int compareTo(Node node) {

            return this.priority >= node.priority ? 1 : 0;
        }
    }

    public static void test(Node node){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //pq.add(length);

    }

    public static void main(String[] args){

    }
}
