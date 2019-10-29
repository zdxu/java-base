package com.zdxu.thread;

import com.zdxu.util.ThreadUtil;

/**
 * Created by zhaodexu on 2019/10/20.
 *
 */
public class AboutThreadInterrupt {


    public static void main(String[] args) {
        threadInterrupt();

        runningThreadInterrupt();
    }

    /**
     * interrupt 中断阻塞状态线程（属于阻塞状态（sleep、wait等）的线程会终止阻塞
     * 并抛出中断异常）
     *
     * isInterrupted 判断线程是否是中断状态
     */
    private static void threadInterrupt() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000*10);
            }catch (InterruptedException e) {
                System.out.println("interrupt and skip out");
            }
        });
        thread.start();

        ThreadUtil.sleep(1000*2);
        thread.interrupt();

        System.out.println("thread interrupt status: " + thread.isInterrupted());
    }


    private static void runningThreadInterrupt() {
        Thread thread = new Thread(() -> {
            Thread.currentThread().interrupt();
            System.out.println(" inerrupt end ...");
        });
        thread.start();
        ThreadUtil.sleep(1000 * 10);
    }
}
