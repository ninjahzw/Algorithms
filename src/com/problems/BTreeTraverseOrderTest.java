package com.problems;

import java.util.PriorityQueue;

/**
 * Created by zhou001 on 8/22/2014.
 *
 * This is a test for a 4-fan-out B-tree
 * traversing the tree use the priority determined by end - MULTIPLIER * start
 *
 * if
 *
 */
public class BTreeTraverseOrderTest {


    public double multiplier;

    private class Node implements Comparable<Node>{

        public int start;
        public int end;
        public double priority;
        private double MULTIPLIER = 0.8;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
            this.priority = end - multiplier * start;
        }

        @Override
        public int compareTo(Node node) {
            double diff = this.priority - node.priority;
            if (diff == 0){
                return 0;
            }
            // have to write it this way because java only have min-heap,
            // this way can convert it to a max-heap:
            return this.priority - node.priority > 0 ? -1 : 1;
        }
        @Override
        public String toString(){
            return "start: " + start + " end : " + end + " priority: " + priority;
        }
    }


    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    private static int FAN_OUT = 4;

    public BTreeTraverseOrderTest(double offset){
        this.multiplier = offset;
    }

    /**
     * When # nodes is large, stack overflow error occurs.
     * @param node
     */
    public void test(Node node){
        System.out.println(pq.size());

        int interval = (node.end - node.start)/FAN_OUT;

        for (int i = 0 ; i < FAN_OUT; i ++){
            if (node.start < node.end - 1){
                pq.add(new Node(node.start + i*interval, node.start + (i+1)*interval));
            }
        }
        //System.out.println(pq.remove() + " " + pq.remove() + " " + pq.remove() );
        if (pq.isEmpty()){
            return;
        }

        Node chosen = pq.remove();
        //System.out.println(chosen.priority);
        test(chosen);
    }

    /**
     * Fix stack overflow error when # nodes is large.
     * @param node
     */
    public void test1(Node node){

        pq.add(node);
        int max = 0;
        while(!pq.isEmpty()){

            node = pq.remove();
            int interval = (node.end - node.start)/FAN_OUT;

            for (int i = 0 ; i < FAN_OUT; i ++){
                if (node.start < node.end - 1){
                    pq.add(new Node(node.start + i*interval, node.start + (i+1)*interval));
                }
            }
            //System.out.println(pq.remove() + " " + pq.remove() + " " + pq.remove() );
            if (pq.isEmpty()){
                break;
            }
            int size = pq.size();
            if (size > max){
                max = size;
            }

            //System.out.println(chosen.priority);
        }

        System.out.println(max);
    }


    public void start(){
        Node node = new Node(0,1024);
        this.test1(node);
    }

    public static void main(String[] args){
        for (double i = 0.0 ; i < 9.9; i+=0.1) {
            System.out.print(i + "\t");
            new BTreeTraverseOrderTest(i).start();
        }
    }
}
