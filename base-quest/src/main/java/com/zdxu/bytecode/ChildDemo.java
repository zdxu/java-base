package com.zdxu.bytecode;

/**
 * Created by zhaodexu on 2019/11/6.
 */
public class ChildDemo extends ParentDemo {

    String childField = "ChildDemo";

    public void childMethod() {
        System.out.println("child method ...");
    }
}
