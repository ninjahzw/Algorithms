package com.algorithm.sort;

import com.datastructure.Heap.Heap;
import com.datastructure.Heap.MaxHeap;

/**
 * Created by houzhaowei on 7/6/14.
 */
public class HeapSort {
    public static void main(String[] dd){

        Integer[] array = {8,4,1,3,7,9,2,10,5,6,12,102,32,2,8};
        // this is a in-place sort.
        try {
            HeapSort.sort(array);
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int one : array){
            System.out.print(one + ",");
        }
    }

    private static void sort (Comparable[] src) {

        Heap maxHeap = new MaxHeap();
        maxHeap.buildHeap(src);

        for (int i = maxHeap.getLastElementIndex() ; i > 0; i --,maxHeap.setLastElementIndex(i-1)){
            // Exchange top element with the last element
            Comparable tmp = src[i];
            src[i] = src[0];
            src[0] = tmp;
            maxHeap.heapify(src,0);
        }

    }

}
