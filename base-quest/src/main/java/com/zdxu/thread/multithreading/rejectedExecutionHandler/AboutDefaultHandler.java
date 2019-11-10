package com.zdxu.thread.multithreading.rejectedExecutionHandler;

import java.util.concurrent.*;

/**
 * Created by zhaodexu on 2019/11/10.
 *
 * ThreadPoolExecutor.AbortPolicy
 */
public class AboutDefaultHandler {

    public static void main(String[] args) {

        /**
         *
         */
        RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4, 4, 10, TimeUnit.DAYS,
                new LinkedBlockingQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        /**
         * 抛出 RejectedExecutionException 来阻止该 task 执行
         */
        defaultHandler.rejectedExecution(
                ()-> System.out.println("Default reject handler of AbortPolicy"),
                threadPoolExecutor
        );


    }
}
