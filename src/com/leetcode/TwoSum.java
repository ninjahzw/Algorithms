package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhaowei on 8/18/2014.
 *
 * Problem:
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * Solution:
 * ----------- O(nlogn) ------------
 * Copy the numbers and sort first, and then use two pointers to get the two numbers we want,
 * then check the indices of these two numbers.
 * One from head and the other from tail to avoid duplication if two numbers are the same.
 * ----------- O(n) -------------
 * This algorithm can be implemented using O(n) approach if we use hashing (HashMap in Java)
 * Use map to record the index of each element, and check if the wanted complementary element exists in the map.
 * Special process the two numbers equal situation.
 *
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length ; i++){
            if (map.containsKey(target - numbers[i])){
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }

        return new int[]{0, 0};
    }



    public static void main(String args[]){
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 130;
        int[] result = new TwoSum().twoSum(numbers, target);

        for (int one : result){
            System.out.print(one + " ");
        }
    }
}
