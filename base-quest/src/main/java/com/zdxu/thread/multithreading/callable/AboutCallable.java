package com.zdxu.thread.multithreading.callable;


/**
 * Created by zhaodexu on 2019/11/10.
 */
public class AboutCallable {

    public static void main(String[] args) {
        /**
         * implement Callable
         * override only method call
         * method have thrown exception
         *
         */
        OneTaskCallable taskCallable = new OneTaskCallable();
        try {
            taskCallable.call();
        }catch (Exception e) {
            System.out.println("Exception occur.");
        }

    }
}
