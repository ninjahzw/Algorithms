package com.problems.test;

/**
 * Created by houzhaowei on 12/1/14.
 */
public abstract class TestAbstract {
    public void doSomething(){

    }

    abstract void doOtherthing();

    public static void main(String[] args){
        new TestAbstract(){
            void doOtherthing(){

            }
        }.doSomething();
    }
}
