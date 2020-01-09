package com.java.practice.patterns.creational;

import org.junit.jupiter.api.Test;

/**
 * 单实例模式
 * <p>
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 何时使用：当您想控制实例数目，节省系统资源的时候。
 * 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
 * 关键代码：构造函数是私有的。
 * <p>
 * 应用实例：
 * 1、一个班级只有一个班主任。
 * 2、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。
 * 3、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印机打印同一个文件。
 * 优点：
 * 1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。
 * 2、避免对资源的多重占用（比如写文件操作）。
 * 缺点：没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
 * <p>
 * 使用场景：
 * 1、要求生产唯一序列号。
 * 2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。
 * 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
 * 注意事项：getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。
 * <p>
 * https://www.runoob.com/design-pattern/singleton-pattern.html
 */
class SingletonPatternTests {

    /**
     * 懒汉式，线程安全
     */
    static class Singleton0 {
        private static Singleton0 instance;

        private Singleton0() {
        }

        public static synchronized Singleton0 getInstance() {
            if (instance == null) {
                instance = new Singleton0();
            }
            return instance;
        }
    }

    /**
     * 懒汉式，线程不安全
     */
    static class Singleton1 {
        private static Singleton1 instance;

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

    /**
     * 懒汉式，线程安全，加锁影响效率
     */
    static class Singleton2 {
        private static Singleton2 instance;

        private Singleton2() {
        }

        public static synchronized Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }

    /**
     * 推荐用法，没有加锁，容易产生垃圾对象，线程安全
     */
    static class Singleton3 {
        private static Singleton3 instance = new Singleton3();

        private Singleton3() {
        }

        public static Singleton3 getInstance() {
            return instance;
        }
    }

    /**
     * 推荐用法，登记式/静态内部类，线程安全
     */
    static class Singleton4 {
        private static class SingletonHolder {
            private static final Singleton4 INSTANCE = new Singleton4();
        }

        private Singleton4() {
        }

        public static final Singleton4 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    static class SingleObject {

        //创建 SingleObject 的一个对象
        private static SingleObject instance = new SingleObject();

        //让构造函数为 private，这样该类就不会被实例化
        private SingleObject() {
        }

        //获取唯一可用的对象
        static SingleObject getInstance() {
            return instance;
        }

        void showMessage() {
            System.out.println("Hello World!");
        }
    }

    @Test
    void test() {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        //显示消息
        object.showMessage();
    }
}
