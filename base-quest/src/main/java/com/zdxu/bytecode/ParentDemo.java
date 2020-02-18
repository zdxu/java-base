package com.zdxu.bytecode;

/**
 * Created by zhaodexu on 2019/11/6.
 */
public class ParentDemo {

    String parentField = "parent field";

    public ParentDemo() {
        System.out.println("parent demo ...");
    }

    public void parentMethod() {
        System.out.println("parent method ...");
    }
}
