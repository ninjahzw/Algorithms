package com.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zhaowei on 12/18/2014.
 */
public class CommonMinimumNumber {
    public static void main(String s[]){
        int firstArray[] = {4, 14, 6, 82, 22};
        int secondArray[] = {4, 16, 12, 14, 48, 96};
        int number = getCommonMinimumNumber(firstArray, secondArray);
        System.out.println("The number is " + number);

    }


    public static int getCommonMinimumNumber(int[] firstSeries, int[] secondSeries){
        int result = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<Integer>();
        boolean exist = false;
        for (int one : firstSeries){
            set.add(one);
        }
        for (int one : secondSeries){
            if (set.contains(one) && one < result){
                exist = true;
                result = (one);
            }
        }
        if (exist) {
            return result;
        }
        return -1;
    }

}
