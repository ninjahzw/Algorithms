package com.datastructure.Heap;

/**
 * Created by houzhaowei on 7/6/14.
 */
public interface Heap {


    /**
     * build the heap structure.
     * @param src , the source array
     */
    public void buildHeap(Comparable[] src);

    /**
     * extract the top element of the heap and maintain the heap property.
     * @param src , the source array
     */
    public Comparable ExtractTop(Comparable[] src);

    /**
     * maintain heap property on i-th element.
     * @param src
     * @param i
     */
    public void heapify(Comparable[] src , int i);

    /**
     * return the last element index.
     */
    public int getLastElementIndex();

    /**
     * set the last element index.
     * @param lastElementIndex
     * @return
     */
    public void setLastElementIndex(int lastElementIndex);


}
