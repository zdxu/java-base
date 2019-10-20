package com.zdxu.util;

/**
 * Created by zhaodexu on 2019/10/19.
 */
public class ThreadUtil {

    public static void sleep(long millis) {
        try{
            Thread.sleep(millis);
        }catch (Exception e) {
            System.out.println("sleep error.");
        }
    }
}
