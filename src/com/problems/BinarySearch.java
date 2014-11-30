package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhaowei on 10/20/2014.
 */
public class BinarySearch {

    public boolean binary(int[] list, int target){
        int start = 0;
        int end = list.length;
        while (start <= end){
            int mid = (start + end)/2;
            int minValue = list[mid];
            if (minValue == target){
                return true;
            }
            if (minValue > target){
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args){
        int[] a = new int[]{1,2,3,6,7,8,9,12,14,17,20,22,23};
        System.out.println(new BinarySearch().binary(a,3));
        System.out.println(new BinarySearch().binary(a,4));
        System.out.println(new BinarySearch().binary(a,6));
        System.out.println(new BinarySearch().binary(a,9));
        System.out.println(new BinarySearch().binary(a,20));
        System.out.println(new BinarySearch().binary(a,1));
        System.out.println(new BinarySearch().binary(a,23));
        System.out.println(new BinarySearch().binary(a,17));

    }
}
