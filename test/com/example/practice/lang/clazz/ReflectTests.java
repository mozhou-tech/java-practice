package com.example.practice.lang.clazz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;


/**
 * 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性，
 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 */
class ReflectTests {

    @Test
    @DisplayName("Constructor 获取class中的信息")
    void test() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("java.util.HashMap");
        Constructor constructor = clazz.getConstructor();
        System.out.println("HashMap中的构造方法 " + constructor);
    }

}
