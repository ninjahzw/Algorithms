package com.algorithm.sort;

/**
 * Created with IntelliJ IDEA.
 * User: houzhaowei
 * Date: 1/12/14
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {

    /**
     * This is a bad fucking solution!!!
     */
//    public static int[] BADsort(int[] src){
//        int[] tmpArray = new int[src.length];
//        return MergeSort.BADsort(src,tmpArray);
//    }

    /**
     * This is a bad fucking solution!!!
     */
//    public static int[] BADsort(int[] src, int[] tmpArray){
//        if (src.length == 1) {
//            return src;
//        }
//
//        // clear the temp array
//        for (int i = 1; i < tmpArray.length; i++){
//            //tmpArray[i] = null;
//        }
//
//        int length = src.length;
//        int pivot =length/2;
//
//        int[] left = new int[length/2];
//        int[] right = new int[length - length/2];
//        for (int i = 0 ; i < pivot; i++){
//            left[i] = src[i];
//
//        }
//        for (int i = pivot ; i < length; i++){
//            right[i-pivot] = src[i];
//        }
//        int[] leftresult = sort(left);
//        int[] rightresult = sort(right);
//        int i = 0,j = 0,k = 0;
//
//        while(i < leftresult.length && j < rightresult.length) {
//            if (leftresult[i] < rightresult[j]){
//                tmpArray[k] = leftresult[i];
//                i ++;
//            } else {
//                tmpArray[k] = rightresult[j];
//                j ++;
//            }
//            k++;
//        }
//
//        for (;i < leftresult.length; i ++, k ++){
//            tmpArray[k] = leftresult[i];
//        }
//        for (;j < rightresult.length; j ++, k ++){
//            tmpArray[k] = rightresult[j];
//        }
//
//        return tmpArray;
//    }

    // -----------

    /**
     * for extra storage of Merge sort.
     */
    private static int[] sortHelper = null;

    /**
     * This should be the optimal MergeSort.
     * This method can modify the original array to a sorted array.
     * @param src
     */
    public static void sort(int[] src){
        sortHelper = new int[src.length];
        mergeSort(src,0,src.length - 1);
    }


    private static void mergeSort(int[] src, int start, int end){
        if (start < end){
            int middle = (end + start)/2;
            mergeSort(src,start,middle);
            mergeSort(src,middle + 1,end);
            merge(src,start,middle,end);
        }
    }

    private static void merge(int[] src, int start, int middle, int end){
        // in order to make this algorithm right, j must be middle + 1 here, this means merge start -> middle, and middle + 1 -> end.
        // because in java, odd number divided by 2 yields smaller number (e.g. 3/2 = 1)
        int i = start, j = middle + 1, k = start;
        while (i <= middle && j <= end){
            if (src[i] < src[j]){
                sortHelper[k] = src[i];
                i++;
            }else {
                sortHelper[k] = src[j];
                j++;
            }
            k++;
        }

        //add the left to the tail
        while (i <= middle){
            sortHelper[k] = src[i];
            i++;k++;
        }
        while (j <= end) {
            sortHelper[k] = src[j];
            j++;k++;
        }

        // copy helper to src
        for (int l = start ; l <= end; l++){
            src[l] = sortHelper[l];
        }
    }

    public static void main(String[] dd){
        int[] array = {8,4,1,3,7,9,2,10,5,6,12,102,32,2};
        int[] array1 = {8,4};
        MergeSort.sort(array);
        for (int one : array){
            System.out.print(one + ",");
        }
    }
}
