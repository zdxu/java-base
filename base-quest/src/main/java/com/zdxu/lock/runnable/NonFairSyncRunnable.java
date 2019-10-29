package com.zdxu.lock.runnable;

import com.zdxu.util.ThreadUtil;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaodexu on 2019/10/29.
 */
public class NonFairSyncRunnable implements Runnable {

    private ReentrantLock reentrantLock;

    public NonFairSyncRunnable(ReentrantLock reentrantLock) {
        if (reentrantLock.isFair()) {
            throw new RuntimeException("Fair must be false.");
        }
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        /*
         * lock
         * setExclusiveOwnerThread
         *      设置当前锁所属线程
         * acquire true 获取成功 false 获取失败
         *      tryAcquire
         *          判断锁是否已释放并尝试获取
         *          判断锁所在线程是否是当前线程
         *      acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
         *          addWaiter(Node.EXCLUSIVE)
         *              将当前线程加入到锁等待队列中
         *              第一次尝试加入，未加入调用 enq 一直尝试，直至加入。
         *          acquireQueued
         *              一直尝试
         *              在当前等待节点前置节点为头节点时尝试获取锁，获取完成，去除头节点
         *              在获取锁失败时，如果需要（shouldParkAfterFailedAcquire 返回true），
         *              挂起当前线程但若当前线程被中断，将中断标示设置为 true。
         *
         *              unsafe.park 挂起线程，可以手动唤起或设置时间自动唤起，
         *                          挂起的线程非中断状态，Thread.sleep 线程属于中断状态
         */
        reentrantLock.lock();
        try {
            String message = "[no fair sync] " + Thread.currentThread().getName() + " is running ...";
            System.out.println(message);
        }finally {
            /*
             *  tryRelease 必须是获取锁的线程才可释放
             *      尝试释放锁 state - releases（一般为 1），当变更后 state 为 0 标示锁已释放。
             *
             *  unparkSuccessor 在锁等待节点队列不为空，且队列头节点的等待状态不为 0，
             *                  释放后续挂起的所有节点
             *      唤起头节点最近的后置节点（waitStatus 小于 0 的最近节点）
             *      将头节点的 waitStatus 设置为 0
             */
            reentrantLock.unlock();
        }
    }

}
