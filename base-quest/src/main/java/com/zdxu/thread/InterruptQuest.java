package main.java.zdxu.thread;

/**
 * Created by zhaodexu on 2019/4/24.
 */
public class InterruptQuest {

    public static void main(String[] args) throws Exception {
        threadInterrupt();
    }


    /**
     * interrupt 将线程标记为中断状态，如果该线程属于阻塞状态（sleep、wait等），则阻塞方法会终止并抛出中断异常
     * isInterrupted 判断线程是否是中断状态
     *
     * 通过 interrupt 中断阻塞状态线程，通过在非阻塞状态线程中监听 isInterrupted 然后通过 interrupt 中断非阻塞状态线程
     */
    public static void threadInterrupt() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e) {
                    System.out.println("interrupt and skip out");
                }
            }
        });
        thread1.start();

        Thread.sleep(3000);

        thread1.interrupt();

        System.out.println("thread interrupt status: " + thread1.isInterrupted());
    }

    public static void deathLockThreadInterrupt() throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new DeathThread(lock1, lock2);
        Thread thread2 = new DeathThread(lock2, lock1);

        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        thread1.interrupt();
        thread2.interrupt();
    }
}


class DeathThread extends Thread {

    private Object lock1 = null;
    private Object lock2 = null;

    public DeathThread(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }


    @Override
    public void run() {
        try {
            deathlock(lock1, lock2);
        }catch (InterruptedException e) {
            System.out.println("interrupt and skip out");
        }

    }

    static void deathlock(Object lock1, Object lock2) throws InterruptedException {
        synchronized (lock1) {
            System.out.println("Thread: " + Thread.currentThread().getName() + "in lock1 ...");
            Thread.sleep(10);
            synchronized (lock2) {
                System.out.println("Thread: " + Thread.currentThread().getName() + "in lock2 ...");
                Thread.sleep(10000);
            }
        }
    }
}
