package com.zdxu.lock.runnable;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaodexu on 2019/10/29.
 */
public class FairSyncRunnable implements Runnable{

    private ReentrantLock reentrantLock;

    public FairSyncRunnable(ReentrantLock reentrantLock) {
        if(!reentrantLock.isFair()) {
            throw new RuntimeException("Fair must be true.");
        }
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        /**
         *  主流程同 NonFairSync，主要区别在于 tryAcquire
         *  FairSync 对于新加入的线程依然需要等待前置先尝试获取锁的线程获取锁完毕才能获取到锁
         *  NonFairSync 对于尝试获取锁的新线程（不再锁等待线程队列里）给予第一次直接获取机会，
         *  若获取不到则加入锁等待线程队列。
         *  在锁等待线程队列的线程按队列顺序依次获取。
         */
        reentrantLock.lock();
        try {
            String message = "[fair sync] " + Thread.currentThread().getName() + " is running ...";
            System.out.println(message);
        }finally {
            /**
             * 同 NonFairSync
             */
            reentrantLock.unlock();
        }
    }
}
