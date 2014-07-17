package com.algorithm.sort;

/**
 * Created with IntelliJ IDEA.
 * User: houzhaowei
 * Date: 1/10/14
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class BubbleSort {

    public static int[] sort(int[] src){
        for (int i = 0 ; i < src.length ; i ++){
            boolean changed = false;
            for (int j = src.length -1; j > i; j--){
                if (src[j] < src[j-1]){
                    int tmp = src[j-1];
                    src[j-1] = src[j];
                    src[j] = tmp;
                    changed = true;
                }
            }
            // if the array remain unchanged during ont iteration, then break and return the result.
            if (!changed){
                break;
            }
        }
        return src;
    }

//    public static int[] sortRecursion(int[] src){
//
//        return sortRecursion(src);
//    }

    public static void main(String[] dd){
        int[] array = {8,4,1,3,7,9,2,10,5,6};
        int[] result = BubbleSort.sort(array);
        for (int one : result){
            System.out.print(one + ",");
        }
    }
}
