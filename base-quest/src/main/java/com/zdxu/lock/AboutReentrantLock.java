package com.zdxu.lock;

import com.zdxu.lock.runnable.FairSyncRunnable;
import com.zdxu.lock.runnable.LockInterruptiblyRunnable;
import com.zdxu.lock.runnable.NonFairSyncRunnable;
import com.zdxu.util.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaodexu on 2019/10/19.
 *
 */
public class AboutReentrantLock {

    public static void main(String[] args) {
//        aboutNonFairSync();
//
//        aboutFairSync();

        aboutLockInterruptibly();
    }


    private static void aboutNonFairSync() {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(() -> {
            reentrantLock.lock();
            ThreadUtil.sleep(1000*5);
            reentrantLock.unlock();
            System.out.println("辅助 end ...");
        }).start();

        ThreadUtil.sleep(1000);
        new Thread(() -> {
            for(int i = 0; i < 1000; i ++) {
                Runnable runnable = new NonFairSyncRunnable(reentrantLock);
                Thread thread = ThreadUtil.create(runnable);
                thread.start();
            }
        }).start();

        ThreadUtil.sleep(1000*4);
        for(int i = 0; i < 1000; i ++) {
            Runnable runnable = new NonFairSyncRunnable(reentrantLock);
            Thread thread = ThreadUtil.create(runnable);
            thread.start();
        }

        System.out.println("master thread end ...");
    }


    public static void aboutFairSync() {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        new Thread(() -> {
            reentrantLock.lock();
            ThreadUtil.sleep(1000*5);
            reentrantLock.unlock();
        }).start();

        ThreadUtil.sleep(1000);
        new Thread(()->{
            for(int i = 0; i < 1000; i++ ) {
                Runnable runnable = new FairSyncRunnable(reentrantLock);
                Thread thread = ThreadUtil.create(runnable);
                thread.start();
            }
        }).start();


        ThreadUtil.sleep(1000*4);
        for(int i = 0; i < 1000; i ++) {
            Runnable runnable = new FairSyncRunnable(reentrantLock);
            Thread thread = ThreadUtil.create(runnable);
            thread.start();
        }
        System.out.println("master thread end ...");

    }

    public static void aboutLockInterruptibly() {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(() -> {
            reentrantLock.lock();
            ThreadUtil.sleep(1000*10);
            reentrantLock.unlock();
        }).start();

        List<Thread> array = new ArrayList(1000);
        for(int i = 0; i < 1000; i ++) {
            Runnable runnable = new LockInterruptiblyRunnable(reentrantLock);
            Thread thread = ThreadUtil.create(runnable);
            thread.start();
            array.add(thread);
        }

        for(int i = 0; i < 1000; i ++) {
            array.get(i).interrupt();
        }
    }
}
