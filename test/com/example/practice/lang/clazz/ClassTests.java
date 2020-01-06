package com.example.practice.lang.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClassTests {

    @Test
    @DisplayName("按名称加载class")
    void ClassStaticMethod() throws ClassNotFoundException {
        Class clazz = Class.forName("java.util.HashMap");
        System.out.println("getSimpleClassName " + clazz.getSimpleName());
        System.out.println("getAnnotations " + clazz.getAnnotations().length);
        System.out.println("getPackage " + clazz.getPackage());
        System.out.println("getConstructors " + clazz.getConstructors().length);
        System.out.println("getFields " + clazz.getFields().length);
        try {
            Class.forName("java.util.HashMap1");
        } catch (ClassNotFoundException e) {
            System.out.println("class java.util.HashMap1 not found.");
        } finally {
            System.out.println("finally");
        }
    }

    @Test
    @DisplayName("其它")
    void ClassType() {
        Assertions.assertEquals(char.class, Character.TYPE);
        Assertions.assertEquals(int.class, Integer.TYPE);
        System.out.println(Integer.class);
        System.out.println(Void.TYPE);
        System.out.println(void.class);
    }

    @Test
    @DisplayName("判断对象是否是某Class的实例")
    void instance() {
        String s = "1";
        System.out.println("是否是字符串 " + s instanceof String);
        if (String.class.isInstance(s)) {
            System.out.println("确实是个字符串");
        }
    }
}
