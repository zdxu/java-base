package com.zdxu.thread.multithreading.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhaodexu on 2019/10/19.
 */
public class AboutLinkedBlockingQueue {

    public static void main(String[] args) {

        /**
         * 基于链表实现的阻塞队列(可指定容量，默认整型最大值)
         * 线程安全（ReentrantLock）
         * 写入使用 putLock，在队列容量已用完时，使用 Condition（notFull） wait 阻塞
         * 读取使用 takeLock，在队列无数据时，使用 Condition（notEmpty） wait 阻塞
         * 当写入且当前队列只有一个元素时，唤醒所有读取等待
         * 当读取且当前队列已满时，唤醒所有写入等待
         */
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
    }
}
