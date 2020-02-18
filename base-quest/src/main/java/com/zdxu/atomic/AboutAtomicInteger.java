package com.zdxu.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaodexu on 2019/11/10.
 */
public class AboutAtomicInteger {

    public static void main(String[] args) {
        AtomicInteger obj = new AtomicInteger(2);
        obj.compareAndSet(4, 3);
        System.out.println(obj.intValue());
        obj.compareAndSet(2, 4);
        System.out.println(obj.intValue());

        System.out.println("end ...");
    }
}
