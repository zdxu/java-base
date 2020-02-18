package com.zdxu.thread.multithreading.callable;

import java.util.concurrent.Callable;

/**
 * Created by zhaodexu on 2019/11/11.
 */
public class OneTaskCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call ...");
        return null;
    }
}
