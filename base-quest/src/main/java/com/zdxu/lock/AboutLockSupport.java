package com.zdxu.lock;

import com.zdxu.util.ThreadUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by zhaodexu on 2019/10/20.
 *
 */
public class AboutLockSupport {

    public static void main(String[] args) {
        lockSupportParkIsNotInterrupt();

        aboutPark();
    }

    private static void aboutPark() {
        parkExample();
    }

    private static void parkExample() {
        Thread thread = new Thread(() -> {
            /*
             * 调用 unpark 会终止该挂起
             * 调用 interrupt 会终止该挂起
             * 可能无缘由的自动终止挂起
             *
             */
            LockSupport.park();
            System.out.println("park release.");
        });
        thread.start();

        ThreadUtil.sleep(1000*10);
        System.out.println("Thread is park.");
        LockSupport.unpark(thread);
    }


    private static void lockSupportParkIsNotInterrupt() {
        AboutLockSupport aboutLockSupport = new AboutLockSupport();
        Thread thread = aboutLockSupport.lockSupportParkThread();

        ThreadUtil.sleep(1000*2);
        System.out.println(thread.isInterrupted());
        ThreadUtil.sleep(1000*2);
        System.out.println("invoke un park ...");

        aboutLockSupport.lockSupportUnPark(thread);
    }

    private Thread lockSupportParkThread() {
        Thread thread = new Thread(() -> {
            System.out.println("park in ... ");
            LockSupport.park();
            System.out.println("park out ...");
        });
        thread.start();
        return thread;
    }

    private void lockSupportUnPark(Thread thread) {
        LockSupport.unpark(thread);
    }


}
