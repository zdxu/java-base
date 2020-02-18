package com.zdxu.datastruct;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaodexu on 2019/11/26.
 */
public class AboutHashMap {

    static class HashMapThread extends Thread {

        private static AtomicInteger ai = new AtomicInteger(0);
        private static Map<Integer, Integer> map = new HashMap<>();

        @Override
        public void run() {
            while (ai.get() < 1000000) {
                map.put(ai.get(), ai.get());
                ai.incrementAndGet();
            }
            System.out.println(currentThread().getName() + "执行完毕。");
        }
    }

    public static void main(String[] args) {
        HashMapThread hashMapThread1 = new HashMapThread();
        HashMapThread hashMapThread2 = new HashMapThread();
        HashMapThread hashMapThread3 = new HashMapThread();
        HashMapThread hashMapThread4 = new HashMapThread();

        hashMapThread1.start();
        hashMapThread2.start();
        hashMapThread3.start();
        hashMapThread4.start();
    }
}
