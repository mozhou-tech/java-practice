package com.example.project.lang.concurrent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 改为局部变量
 * 对共享变量加同步锁
 * private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat> 让每个线程都有独立的变量
 */
public class ThreadSafeTests {

    /**
     * 互斥性：同一时间只允许一个线程持有某个对象锁，确保对象操作的原子性
     * 可见性：必须确保在锁被释放之前，对共享变量所做的修改，对于随后获得该锁的另一个线程是可见的，否则可能引起不一致
     * 有序性：如果在本线程内观察，所有操作都是天然有序的。如果在一个线程中观察另一个线程，所有操作都是无序的。
     *
     * 修饰代码块 synchronized(this|object) {}，synchronized(类.class) {}
     * 修饰方法 静态方法和非静态方法
     * 分为：类锁，对象锁
     */
    @Test
    @DisplayName("同步锁")
    void Synchronized(){

    }

    /**
     * 面试官重点喜欢的关键字 [ˈvɑːlətl]
     * 程度较轻的 synchronized，比使用锁 速度更快
     * Volatile 变量具有 synchronized 的可见性特性，但是<b>不具备原子特性</b>。这就是说线程能够自动发现 volatile 变量的最新值
     * Volatile 变量可用于提供线程安全，但是只能应用于非常有限的一组用例：多个变量之间或者某个变量的当前值与修改后值之间没有约束。
     * 因此，单独使用 volatile 还不足以实现计数器、互斥锁或任何具有与多个变量相关的不变式（Invariants）的类（例如 “start <=end”)
     * volatile 变量不会像锁那样造成线程阻塞，因此也很少造成可伸缩性问题。在某些情况下，如果读操作远远大于写操作，volatile 变量还可以提供优于锁的性能优势。
     * volatile的用法比较简单，只需要在声明一个可能被多线程同时访问的变量时，使用volatile修饰就可以了。private volatile static Singleton singleton;
     * volatile是Java虚拟机提供的一种轻量级同步机制，他是基于内存屏障实现
     * https://www.ibm.com/developerworks/cn/java/j-jtp06197.html
     */
    @Test
    @DisplayName("")
    void Volatile(){

    }

    /**
     * 可变类：当你获得这个类的一个实例引用时，你可以改变这个实例的内容。
     * 例如String和StringBuilder，String每次都会生成一个新的对象, StringBuilder就不会
     */
    void Mutable(){

    }

    /**
     * 不可变类
     * 不可变对象可以提高String Pool的效率和安全性。
     * 不可变对象对于多线程是安全的，因为在多线程同时进行的情况下，一个可变对象的值很可能被其他进程改变，这样会造成不可预期的结果，而使用不可变对象就可以避免这种情况。
     * 如果字符串是可变的，那么会引起很严重的安全问题。譬如，数据库的用户名、密码都是以字符串的形式传入来获得数据库的连接，或者在socket编程中，主机名和端口都是以字符串的形式传入。
     * 因为字符串是不可变的，所以它的值是不可改变的，否则黑客们可以钻到空子，改变字符串指向的对象的值，造成安全漏洞。
     *
     * 什么方法：（强不可变类）final Class,（弱不可变类）所有成员都是private final,不提供成员方法setXXX,
     */
    void  Immutable(){

    }
}
