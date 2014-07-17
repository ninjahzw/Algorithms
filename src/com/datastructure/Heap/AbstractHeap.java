package com.datastructure.Heap;

/**
 * Created by houzhaowei on 7/6/14.
 * Because for java language 0-th element is the first element, so I have
 * to do a little modify to the left and right function.
 */
public class AbstractHeap {

    /*
     * the index of the last element of the array (heap)
     */
    protected int lastElementIndex;

    int parent (int i) {
        return i/2;
    }

    int left (int i) {
        return 2 * (i+1) - 1;
    }

    //
    int right (int i) {
        return 2 * (i+1);
    }
}
