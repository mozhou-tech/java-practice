package com.example.practice.jvm._jni;

/**
 * IDEA下的JNI编程
 * https://blog.csdn.net/i_am_yong_ge/article/details/97922319
 *
 * Mac上编译动态链接库
 * https://www.jianshu.com/p/ba1208dd5ba9
 */
class Hello {

    static {
        System.loadLibrary("libHello");
    }

    public native void hello();
    /**
     * 把实现了我们在Java code中声明的native方法的那个libraryload进来，或者load其他什么动态连接库
     * JNI Example (Mac OS) https://gist.github.com/DmitrySoshnikov/8b1599a5197b5469c8cc07025f600fdb
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.home"));
        String shortOsName = System.getProperty("os.name").substring(0,3);
        // 判断操作系统类型
        switch (shortOsName){
            case "Mac":
                System.out.println(shortOsName);
                break;
            default:
                break;
        }
    }
}
