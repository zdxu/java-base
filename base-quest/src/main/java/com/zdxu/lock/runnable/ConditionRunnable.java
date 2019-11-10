package com.zdxu.lock.runnable;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaodexu on 2019/11/9.
 */
public class ConditionRunnable implements Runnable {

    private ReentrantLock reentrantLock;
    private Condition condition;

    public ConditionRunnable(ReentrantLock reentrantLock, Condition condition) {
        this.reentrantLock = reentrantLock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try{
            reentrantLock.lock();
            System.out.println("Wait pre ...");
            condition.await();
            String message = Thread.currentThread().getName() + " in.";
            System.out.println(message);
            condition.signal();
        }catch (InterruptedException e) {
            System.out.println("Interrupted exception.");
            condition.signal();
        }finally {
            reentrantLock.unlock();
        }
    }
}
