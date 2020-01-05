package com.example.project.jvm;

import org.junit.jupiter.api.Test;

class JDKInfoTests {

    @Test
    void JDKInfo(){
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.vendor.url"));
    }
}
