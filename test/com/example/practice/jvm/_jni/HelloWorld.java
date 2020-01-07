package com.example.practice.jvm._jni;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * IDEA下的JNI编程
 * https://blog.csdn.net/i_am_yong_ge/article/details/97922319
 */
class HelloWorld {
    /**
     * 把实现了我们在Java code中声明的native方法的那个libraryload进来，或者load其他什么动态连接库
     * JNI Example (Mac OS) https://gist.github.com/DmitrySoshnikov/8b1599a5197b5469c8cc07025f600fdb
     */
    @Test
    @DisplayName("JNI机制，load&loadLibrary")
    void load(){
        String shortOsName = System.getProperty("os.name").substring(0,3);
        // 判断操作系统类型
        switch (shortOsName){
            case "Mac":
                System.out.println(shortOsName);
                break;
            default:
                System.load("");
                break;
        }
    }

    @Test
    void compile(){
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("user.name"));
    }
}
