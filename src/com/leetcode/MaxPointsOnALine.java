package com.leetcode;

import java.util.Random;

/**
 * Created by houzhaowei on 8/15/14.
 *
 * Hint:
 * Calculate the slope of any two points, and group the same slopes.
 * count the maximum same slopes.
 *
 *
 */
public class MaxPointsOnALine {


    private static class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
    }

    private class Pair{

    }

    public int maxPoints(Point[] points) {

        long[] pairs = new long[points.length * points.length];
        int maxCount = 0;

        for (Point outterPoint : points){
            for (Point innerPoint: points){
                if (outterPoint != innerPoint){
                    int distanceX = innerPoint.x - outterPoint.x;
                    int distanceY = innerPoint.y - outterPoint.y;

                    /**
                     *  in case that two points are the same, then do not pair them
                     *  instead, we need to add one to
                     */
                    if (distanceX == 0 && distanceY == 0){
                        maxCount ++;
                    }

                    double gradient;
                    if (distanceX == 0) {
                        gradient = Double.POSITIVE_INFINITY;
                    }
                    if (distanceY == 0) {
                        gradient = 0;
                    }
                    gradient = (innerPoint.x - outterPoint.x)/(innerPoint.y - outterPoint.y);
//                    pairs[index] = gradient;
//                    index ++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Point[] points = new Point[20];
        Random r = new Random();
        for (int i = 0 ; i < 20; i ++){
            points[i] = new Point(r.nextInt(10),r.nextInt(10));
        }

        new MaxPointsOnALine().maxPoints(points);
    }

}
