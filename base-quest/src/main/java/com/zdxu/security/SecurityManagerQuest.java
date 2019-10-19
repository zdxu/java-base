package com.zdxu.security;

import sun.security.util.SecurityConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * Created by zhaodexu on 2019/5/12.
 */
public class SecurityManagerQuest {

    public static void main(String[] args) throws Exception{

        // FileInputStream 内部使用 system.getSecurityManager() 的 checkRead() 来控制对资源的安全访问
        // new FileInputStream(new File("file-path"));

        // system.getSecurityManager()
        // SecurityManager
        //   checkRead()
        //     checkPermission(new FilePermission(file, SecurityConstants.FILE_READ_ACTION));
        //       java.security.AccessController.checkPermission(perm);


        SecurityManager securityManager = System.getSecurityManager();
        if(securityManager == null) {
            System.out.println("security manager has not install default !");
            return ;
        }

        System.out.println("security manager has installed default !");





    }


}
