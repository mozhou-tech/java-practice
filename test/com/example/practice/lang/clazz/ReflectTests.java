package com.example.practice.lang.clazz;

import com.example.practice.clazz.Generic;
import com.example.practice.clazz.Pojo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;


/**
 * Java语言中 一种 动态（运行时）访问、检测 & 修改它本身的能力
 *
 * 优点：灵活性高。因为反射属于动态编译，即只有到运行时才动态创建 &获取对象实例。
 * 缺点：因为反射的操作 主要通过JVM执行，所以时间成本会 高于 直接执行相同操作
 * 应用：常用的需求场景有：动态代理、工厂模式优化、Java JDBC数据库操作等
 */
class ReflectTests {
    private static Class classForTest;

    private static Class genericClassForTest;

    @BeforeAll
    static void init() {
        Pojo pojo = new Pojo();
        classForTest = pojo.getClass();
        Generic generic = new Generic();
        genericClassForTest = generic.getClass();
    }

    @Test
    @DisplayName("Constructor 获取class中的信息")
    void ClassInfo() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("ClassName " + classForTest.getName());
        Class clazz = Class.forName("com.example.practice.clazz.Pojo");
        // 获取class中的构造方法
        Constructor constructor = clazz.getConstructor();
        System.out.println("HashMap中的构造方法 " + constructor);
        // 获取class中的Field
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(String.format("class中定义了%s个字段如下：%s", fields.length, Arrays.asList(fields)));
        // 获取class的方法
        Method[] methods = clazz.getMethods();
        System.out.println(String.format("class中定义了%s个方法如下：%s", methods.length, Arrays.asList(methods)));

    }

    @Test
    @DisplayName("泛型class info")
    void genericClassInfo(){
        TypeVariable[] typeVariables = genericClassForTest.getTypeParameters();
        System.out.println(String.format("%s", Arrays.asList(typeVariables)));
    }

    @Test
    @DisplayName("java.lang.reflect.Type是 Java中所有类型的父接口")
    void Type(){

    }

}
