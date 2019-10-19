package com.zdxu.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaodexu on 2019/10/19.
 */
public class AboutReentrantlock {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        new AboutReentrantlock().thread1();
        new AboutReentrantlock().thread2();
    }


    public void thread1() {
        new Thread(() -> {
            reentrantLock.lock();
            try {
                for(int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    System.out.println("thread1 ... " + i);
                }
            }catch (Exception e){

            }finally {
                reentrantLock.unlock();
            }
        }).start();
    }


    public void thread2() {
        new Thread(() -> {

            try {
                reentrantLock.lockInterruptibly();
                for(int j = 0; j < 100; j++) {
                    Thread.sleep(10);
                    System.out.println("thread2 ... " + j);
                }
            } catch (Exception e) {
            }finally {
                reentrantLock.unlock();
            }
        }).start();
    }
}
