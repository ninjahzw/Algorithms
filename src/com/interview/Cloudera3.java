package com.interview;

/**
 * Created by Zhaowei on 12/20/2014.
 */
public class Cloudera3 {

    int read4(char[] buf){
        return 4;
    }

    public int read(char[] buf, int n) {
        int result = 0;
        int numRead = 0;
        while ((numRead = read4(buf)) == 4){
            result += numRead;
        }
        result += numRead;
        return result;
    }

    public static void main(String[] args){

    }
}
