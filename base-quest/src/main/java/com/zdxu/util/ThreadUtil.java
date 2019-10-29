package com.zdxu.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaodexu on 2019/10/19.
 */
public class ThreadUtil {

//    private static AtomicInteger count = new AtomicInteger(0);

    public static void sleep(long millis) {
        try{
            Thread.sleep(millis);
        }catch (Exception e) {
            System.out.println("sleep error.");
        }
    }

    public static Thread create(Runnable runnable) {
//        String threadName = String.format("%s%s", "thread-", count.getAndAdd(1));
        return new Thread(runnable);

    }
}
