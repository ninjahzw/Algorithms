package com.problems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by zhou001 on 8/22/2014.
 */
public class BTreeTest {

    private static class Node implements Comparable<Node>{

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


    PriorityQueue<Node> pq = new PriorityQueue<Node>();

    public void test(Node node){

        int interval = (node.end - node.start)/4;
        Node node1 = new Node(node.start, node.start + interval);
        Node node2 = new Node(node.start + interval, node.start + 2*interval);
        Node node3 = new Node(node.start + 2*interval, node.start + 3*interval);
        Node node4 = new Node(node.start + 3*interval, node.start + 4* interval);

        pq.add(node1);
        pq.add(node2);
        pq.add(node3);
        pq.add(node4);

        test(pq.remove());
    }

    public static void main(String[] args){
        Node node = new Node(0,1024);


    }
}
