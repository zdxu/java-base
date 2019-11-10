package com.zdxu.lock;

import com.zdxu.lock.runnable.ConditionRunnable;
import com.zdxu.util.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaodexu on 2019/11/9.
 */
public class AboutCondition {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(() -> {
            reentrantLock.lock();
            ThreadUtil.sleep(1000*10);
            reentrantLock.unlock();
        }).start();

        /**
         *  Condition 接口
         *  结合 lock 实现对 object await、notify 等的替换
         *  如 Condition 拥有的方法 await、signal、signalAll 等
         *
         *  Object 的 wait 会让当前线程暂时释放锁
         *  Condition 的 await 也会让当前线程暂时释放锁
         *
         *  ReentrantLock 的内部实现 ConditionObject
         *  单向链表存储等待线程，顺序唤醒
         *  必须是锁中当前获取到锁的线程可以调用该方法，否则报 IllegalMonitorStateException。（调用前判断）
         *
         *  线程中断会导致 await 方法抛出中断异常
         *
         */
        Condition condition = reentrantLock.newCondition();

        List<Thread> array = new ArrayList<>(10);
        for(int i = 0; i < 10; i++) {
            ConditionRunnable runnable = new ConditionRunnable(reentrantLock, condition);
            Thread thread = ThreadUtil.create(runnable);
            thread.start();
            array.add(thread);
        }

        ThreadUtil.sleep(1000*10);
        array.get(5).interrupt();

        reentrantLock.lock();
        condition.signalAll();
        reentrantLock.unlock();




    }
}
