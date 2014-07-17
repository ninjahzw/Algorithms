package com.datastructure.Heap;

/**
 * Created by houzhaowei on 7/6/14.
 */
public class MaxHeap extends AbstractHeap implements Heap{


    @Override
    public int getLastElementIndex() {
        return lastElementIndex;
    }

    @Override
    public void setLastElementIndex(int lastElementIndex) {
        this.lastElementIndex = lastElementIndex;
    }

    @Override
    public void buildHeap(Comparable[] src) {
        // initialize the last element index
        this.lastElementIndex = src.length - 1;
        for (int i = src.length/2 ; i >= 0.; i --){
            heapify(src,i);
        }
    }

    @Override
    public Comparable ExtractTop(Comparable[] src) {
        if (lastElementIndex > 0) {
            Comparable result = src[0];
            // maintain heap property
            src[0] = src[lastElementIndex];
            src[lastElementIndex] = null;
            lastElementIndex --;
            heapify(src,0);
            return  result;
        } else {
            return src[0];
        }
    }

    @Override
    public void heapify(Comparable[] src , int i) {

        int l = left(i);
        int r = right(i);
        int largestIndex = i;
        //System.out.println("DEBUG: l is: " + l + " r is: " + r + " largest index is: " + largestIndex );
        if (l <= lastElementIndex && src[l].compareTo(src[largestIndex]) > 0){
            largestIndex = l;
        }
        if (r <= lastElementIndex && src[r].compareTo(src[largestIndex]) > 0) {
            largestIndex = r;
        }
        // swap current element with the largest child (if there is).
        if (largestIndex != i) {
            Comparable tmp = src[largestIndex];
            src[largestIndex] = src[i];
            src[i] = tmp;
            //do this method again on the element
            heapify(src,largestIndex);
        }
    }

    public static void main(String[] dd){

        Integer[] array = {8,4,1,3,7,9,2,10,5,6,12,102,32,2,8};
        // this is a in-place sort.
        Heap minHeap = new MaxHeap();
        try {
            minHeap.buildHeap(array);
        }catch (Exception e){
            e.printStackTrace();
        }

        for (int one : array){
            System.out.print(one + ",");
        }

        System.out.println();
        for (int i = 0 ; i < array.length; i ++){
            System.out.print(minHeap.ExtractTop(array) + "--");
        }

    }
}
