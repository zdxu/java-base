package com.zdxu.lock.runnable;

import com.zdxu.util.ThreadUtil;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaodexu on 2019/11/9.
 */
public class LockInterruptiblyRunnable implements Runnable {

    private ReentrantLock reentrantLock;

    public LockInterruptiblyRunnable(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        try {
            /**
             * 原理同 lock
             * 差别是遇到线程中断就抛出异常（因异常导致锁失效）
             */
            reentrantLock.lockInterruptibly();
            try {
                String message = Thread.currentThread().getName() + " in.";
                System.out.println(message);
            }finally {
                reentrantLock.unlock();
            }
        }catch (InterruptedException e) {
            System.out.println("Interrupted exception.");
        }
    }
}
