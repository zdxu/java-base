/**
 * 
 */

package com.zdxu.thread.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadPoolQuest {

    public int test() {
        try {
            System.out.println(1/0);
        }catch(Exception ignore){
            System.out.println("in catch ...");
            return 1;
        }finally {
            System.out.println("in finally ...");
            return 2;
        }
    }

    public static void main(String[] args) {


        System.out.println(new ThreadPoolQuest().test());

        System.out.println("start ...");

        AtomicInteger obj = new AtomicInteger(2);
        obj.compareAndSet(4, 3);
        System.out.println(obj.intValue());
        obj.compareAndSet(2, 4);
        System.out.println(obj.intValue());


        System.out.println((-1)<<(Integer.SIZE-3));
        System.out.println(1 << 29);

        System.out.println(3<<1);


        System.out.println(~(-1));

        ExecutorService executorService = Executors.newCachedThreadPool();
        
        ThreadPoolExecutor ThreadPoolExecutor = new ThreadPoolExecutor(
             4, 2, 10, TimeUnit.DAYS,
             new SynchronousQueue<Runnable>(),
             Executors.defaultThreadFactory(),
             new ThreadPoolExecutor.AbortPolicy()
        );

        System.out.println("end ...");
        
    }

}