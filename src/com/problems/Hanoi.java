package com.problems;

/**
 * Created by houzhaowei on 10/6/14.
 */
public class Hanoi {
    public static void move(int N, int src, int dest) {
        if (N > 0) {
            // neat trick to get index of other pole.
            final int temp = 6 - src - dest;
            move(N - 1, src, temp);
            System.out.println("Move ring from pole "
                    + src + " to pole " + dest);
            move(N - 1, temp, dest);
        }
    }

    public static void main(String[] args) {
        // Move two rings from pole 1 to pole 3.
        System.out.println("\nSoln for two rings:\n");
        move(2, 1, 3);
        // Move three rings from pole 1 to pole 3.
        System.out.println("\nSoln for three rings:\n");
        move(3, 1, 3);
    }
}