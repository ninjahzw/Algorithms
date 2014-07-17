package com.algorithm.sort;

/**
 * Created with IntelliJ IDEA.
 * User: houzhaowei
 * Date: 1/12/14
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {

    public static int[] sort(int[] src){
        if (src.length == 1) {
            return src;
        }

        int length = src.length;
        int pivot =length/2;

        int[] left = new int[length/2];
        int[] right = new int[length - length/2];
        for (int i = 0 ; i < pivot; i++){
            left[i] = src[i];

        }
        for (int i = pivot ; i < length; i++){
            right[i-pivot] = src[i];
        }
        int[] leftresult = sort(left);
        int[] rightresult = sort(right);
        int[] result = new int[length];
        int i = 0,j = 0,k = 0;

        while(i < leftresult.length && j < rightresult.length) {
            if (leftresult[i] < rightresult[j]){
                result[k] = leftresult[i];
                i ++;
            } else {
                result[k] = rightresult[j];
                j ++;
            }
            k++;
        }

        for (;i < leftresult.length; i ++, k ++){
            result[k] = leftresult[i];
        }
        for (;j < rightresult.length; j ++, k ++){
            result[k] = rightresult[j];
        }

        return result;
    }

    public static void main(String[] dd){
        int[] array = {8,4,1,3,7,9,2,10,5,6,12,102,32,2};
        int[] result = MergeSort.sort(array);
        for (int one : result){
            System.out.print(one + ",");
        }
    }
}
