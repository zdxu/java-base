
package com.zdxu.thread.multithreading.examples;

import java.util.concurrent.*;

class AboutExecutors {

    public static void main(String[] args) {


        System.out.println(System.getSecurityManager());

        // 
        int nThreads = 5;

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        Executors.newFixedThreadPool(nThreads);
        Executors.newFixedThreadPool(nThreads, threadFactory);

        Thread thread = threadFactory.newThread(() -> {
            System.out.println(" ... ");
            try {
                Thread.sleep(100000000);
            }catch (Exception e) {

            }
        });

        thread.start();


        thread.stop();

        int i = 10;

        jjj:


            for (; i > 0;) {
                System.out.println(i);

                i--;

        }

        System.out.println("end ...");





        
        
    }
}