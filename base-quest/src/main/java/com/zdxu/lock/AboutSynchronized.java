package com.zdxu.lock;

import com.zdxu.util.ThreadUtil;

/**
 * Created by zhaodexu on 2019/10/21.
 *
 */
public class AboutSynchronized {

    private final String syncLock = new String("lock");

    public static void main(String[] args) {

        AboutSynchronized aboutSynchronized = new AboutSynchronized();
        aboutSynchronized.synchronizedThread1();
        aboutSynchronized.synchronizedThread2();

        for(int i = 0; i < 10; i++) {
            aboutSynchronized.synchronizedThread3();
        }

    }

    private void synchronizedThread1() {
        new Thread(() -> {
            synchronized (syncLock) {
                System.out.println("sync lock ... 1");
                ThreadUtil.sleep(1000*2);
            }
        }).start();
    }

    private void synchronizedThread2() {
        new Thread(() -> {
            synchronized (syncLock) {
                System.out.println("sync lock ... 2");
                ThreadUtil.sleep(1000*2);
            }
        }).start();
    }

    private void synchronizedThread3() {
        new Thread(() -> {
            synchronized (syncLock) {
                String message = Thread.currentThread().getName() + " in ...";
                System.out.println(message);
                try{
                    syncLock.wait();
                }catch (Exception e) {

                }
                ThreadUtil.sleep(1000*2);
            }
        }).start();
    }
}
