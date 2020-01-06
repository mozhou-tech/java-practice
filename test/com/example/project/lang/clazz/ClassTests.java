package com.example.project.lang.clazz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

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
}
