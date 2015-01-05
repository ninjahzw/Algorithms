package com.problems;

/**
 * Created by houzhaowei on 11/30/14.
 */
public class TestSingleton {
    private static TestSingleton testSingleton;

    private TestSingleton(){

    }

    public static TestSingleton getInstance(){
        if (null == testSingleton){
            testSingleton = new TestSingleton();
        }
        return testSingleton;
    }
}
