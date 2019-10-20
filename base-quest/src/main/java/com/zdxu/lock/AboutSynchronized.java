package com.zdxu.lock;

import com.zdxu.util.ThreadUtil;

/**
 * Created by zhaodexu on 2019/10/21.
 *
 */
public class AboutSynchronized {

    private final String syncLock = "lock";

    public static void main(String[] args) {

        AboutSynchronized aboutSynchronized = new AboutSynchronized();
        aboutSynchronized.synchronizedThread1();
        aboutSynchronized.synchronizedThread2();

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
}
