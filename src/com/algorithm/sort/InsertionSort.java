package com.algorithm.sort;

/**
 * Created with IntelliJ IDEA.
 * User: houzhaowei
 * Date: 1/10/14
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSort {


    public static int[] sort(int[] src){
        for (int i = 1 ; i < src.length ; i++){
            int key = src[i];
            int j = i -1;
            while (j >= 0 && src[j] > key){
                src[j+1] = src[j];
                j--;
            }
            src[j+1] = key;
        }
        return src;
    }

    public static void main(String[] dd){
        int[] array = {8,4,1,3,7,9,2,10,5,6};
        int[] result = InsertionSort.sort(array);
        for (int one : result){
            System.out.print(one + ",");
        }
    }
}
