package com.zdxu.thread.multithreading.future;

import com.zdxu.thread.multithreading.callable.OneTaskCallable;
import com.zdxu.util.ThreadUtil;

import java.util.concurrent.FutureTask;

/**
 * Created by zhaodexu on 2019/11/16.
 */
public class AboutFutureTask {


    public static void main(String[] args) {


        OneTaskCallable oneTaskCallable = new OneTaskCallable();
        FutureTask<String> futureTask = new FutureTask<String>(oneTaskCallable);

        Thread thread = ThreadUtil.create(futureTask);
        thread.start();

        try{
            String s = futureTask.get();
            System.out.println(s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
