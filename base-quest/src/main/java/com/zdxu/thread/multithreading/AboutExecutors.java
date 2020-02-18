
package com.zdxu.thread.multithreading;

import java.util.concurrent.*;

class AboutExecutors {

    public static void main(String[] args) {


        int nThreads = 5;
        ThreadFactory threadFactory = Executors.defaultThreadFactory();



        /**
         * fixed thread pool
         * 相当于 ThreadPoolExecutor(nThreads, nThreads,
         * 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(),
         * threadFactory, new ThreadPoolExecutor.AbortPolicy())
         *
         *
         */
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        executorService = Executors.newFixedThreadPool(nThreads, threadFactory);











        
        
    }
}