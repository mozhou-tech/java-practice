package com.example.practice.jni.c;

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
        System.load("/Users/jerrylau/IdeaProjects/java-practice/test/com/example/practice/jni/c/JNITest.jnilib");
        /**
         * 指定动态库的名字即可，不需要前缀后缀，java 会去 java.library.path 系统属性指定的目录下查找动态库文件，一劳永逸；
         */
//        System.loadLibrary("JNITest");
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
        int length = (new JNIExample()).returnInt(str.length());
        System.out.println(String.format("Return string length %s.", length));
        System.out.println("================printString================");
        (new JNIExample()).sayHello();
    }
}
