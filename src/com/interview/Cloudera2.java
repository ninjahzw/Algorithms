package com.interview;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by Zhaowei on 12/20/2014.\
 *
 *
 * An other approach is we can first sort the two arrays and
 * then use two pointers from the start of the two sorted arrays,
 * find the first common then return.
 * this approach will take Time: O(m log(m) + n log (n) + (m+n)) Space: O(1)
 *
 * My following hash approach can solve this problem using O(m+n) time and O(m) space
 */
public class Cloudera2 {

    public int solution(int[] A, int[] B) {
        int result = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<Integer>();
        boolean exist = false;
        for (int one : A){
            set.add(one);
        }
        for (int one : B){
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

    public static void main(String[] args){
        int firstArray[] = {};
        int secondArray[] = {};
        int number = new Cloudera2().solution(firstArray, secondArray);
        System.out.println("The number is " + number);
    }
}
