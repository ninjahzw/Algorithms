package com.algorithm.sort;


/**
 * Created by houzhaowei on 6/24/14.
 */
public class QuickSort {

    public static void main(String[] dd){

        int[] array = {8,4,1,3,7,9,2,10,5,6,12,102,32,2,8};
        // this is a in-place sort.
        try {
            QuickSort.sort(array,0,array.length-1);
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int one : array){
            System.out.print(one + ",");
        }
    }

    /**
     * Not correct, figure it out later.
     * @param src
     * @param start
     * @param end
     */
    private static void Mysort(int[] src, int start, int end) {
        int originalStart = start;
        int originalEnd = end;
        int pivot = src[end];

        while ( start < end ) {
            if (src[start] < pivot) {
                start ++;
            } else {
                // always exchange the smaller to the front
                int tmp = src[end];
                src[end] = src[start];
                src[start] = tmp;

                end --;
            }
        }
        end = end + 1;
        // swap the last one to the pivot, so that the pivot can be in the middle (approximately).
        src[src.length-1] = src[end];
        src[end] = pivot;
        System.out.println(start + " -- " +  end);
        if(end > start){
            Mysort(src, originalStart, start);
            Mysort(src, end + 1, originalEnd);
        }
    }

    private static void sort (int[] src, int start, int end) {
        if (start >= end){
            return;
        }
        int pivot = src[end];
        int i = start - 1;
        for (int j = start ; j <= end -1 ; j++ ) {
            if (src[j] < pivot) {
                i ++;
                int tmp = src[j];
                src[j] = src[i];
                src[i] = tmp;
            }
        }

        src[end] = src[i + 1];
        src[i + 1] = pivot;

        sort(src, start, i);
        sort(src, i+2, end);
    }

}
