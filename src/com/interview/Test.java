package com.interview;

/**
 * Created by houzhaowei on 12/20/14.
 */
public class Test {
    public static void main(String[] args){
        System.out.println(new Test().aa(17));
    }

    public int aa(int a){
        int[] array = new int[]{3,7,1,11,5};
        int i = 0;
        int j = array.length-1;
        while(i <= j){
            i++;
            if (i == j){
                return array[i];
            }
            j--;
            System.out.println(i + "  " + j);
        }
        return array[j];
    }
}


