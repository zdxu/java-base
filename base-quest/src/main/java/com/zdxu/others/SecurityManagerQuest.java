package com.zdxu.others;


/**
 * Created by zhaodexu on 2019/10/12.
 */
public class SecurityManagerQuest {


    public static void main(String[] args) {

        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(securityManager);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Thread.sleep(10000000);

                }catch (Exception e) {

                }
            }
        });

        thread.start();


        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getThreadGroup().activeCount());
        System.out.println(thread.isAlive());


        securityManager.checkAccess(Thread.currentThread());
    }
}
