package com.zdxu.bitwiseOperation;

/**
 * Created by zhaodexu on 2019/11/10.
 */
public class DemoQuest1 {

    public static void main(String[] args) {

        System.out.println(-(1<<(Integer.SIZE-3)));
        System.out.println((-1)<<(Integer.SIZE-3));
        System.out.println(1 << 29);
        System.out.println(3<<1);
        System.out.println(~(-1));
    }
}
