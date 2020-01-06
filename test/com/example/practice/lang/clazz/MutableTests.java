package com.example.practice.lang.clazz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MutableTests {

    /**
     * 可变类：当你获得这个类的一个实例引用时，你可以改变这个实例的内容。
     * 例如String和StringBuilder，String每次都会生成一个新的对象, StringBuilder就不会
     */
    @Test
    @DisplayName("可变类")
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
    @Test
    @DisplayName("不可变类")
    void  Immutable(){

    }
}
