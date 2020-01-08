package com.example.practice.lang.system;

import org.junit.jupiter.api.Test;

/**
 * 打印信息
 */
class JDKInfoTests {

    @Test
    void JDKInfo(){
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.vendor.url"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("security.destroy"));
    }
}
