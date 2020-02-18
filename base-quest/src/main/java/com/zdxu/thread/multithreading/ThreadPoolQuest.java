/**
 * 
 */

package com.zdxu.thread.multithreading;

import com.zdxu.thread.multithreading.callable.OneTaskCallable;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadPoolQuest {

    public static void main(String[] args) {

        System.out.println("start ...");

        /**
         *
         * runWorker
         *    while 循环，执行队列中的 task
         */
        ExecutorService executorService = new ThreadPoolExecutor(
             4, 4, 10, TimeUnit.DAYS,
             new LinkedBlockingQueue<Runnable>(),
             Executors.defaultThreadFactory(),
             new ThreadPoolExecutor.AbortPolicy()
        );


        /**
         * 1、线程池未达到设置的核心线程数
         *     直接新建 worker 线程
         * 2、线程池线程数已达到设置的核心线程数，且添加队列成功
         *     将任务添加到队列中，检查线程池状态，针对处理
         * 3、添加队列失败
         *     新增非核心 worker 线程
         */
        executorService.execute(()-> System.out.println("task 1 ..."));


        OneTaskCallable oneTaskCallable = new OneTaskCallable();
        /**
         * 包装成 FutureTask
         * 调用 execute
         */
        executorService.submit(oneTaskCallable);


        /**
         *
         */



        System.out.println("end ...");
        
    }

}