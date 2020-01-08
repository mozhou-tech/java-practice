package com.example.practice.lang.system.jni.cython;

import java.io.File;

/**
 * IDEA下的JNI编程
 * https://blog.csdn.net/i_am_yong_ge/article/details/97922319
 * <p>
 * Mac上编译动态链接库
 * https://www.jianshu.com/p/ba1208dd5ba9
 */
class JNIExample {

    // This loads the library at runtime. NOTICE: on *nix/Mac the extension of the
    // lib should exactly be `.jnilib`, not `.so`, and have `lib` prefix, i.e.
    // the library file should be `libjniexample.jnilib`.
    static {
        /**
         *  绝对路径，直接加载
         */
        System.load(getCurrentAbsolutePath() + "/JNITest.jnilib");
    }

    public native int returnInt(int length);

    public native void sayHello();

    /**
     * 把实现了我们在Java code中声明的native方法的那个libraryload进来，或者load其他什么动态连接库
     * JNI Example (Mac OS) https://gist.github.com/DmitrySoshnikov/8b1599a5197b5469c8cc07025f600fdb
     */
    public static void main(String args[]) {
        System.out.println("================returnInt================");
        String str = "Hello, world asdf!";
    }

    /**
     * 获取当前文件的绝对路径
     *
     * @return
     */
    private static String getCurrentAbsolutePath() {
        File directory = new File("");
        return directory.getAbsolutePath();
    }
}

