package com.example.practice.jvm;

import com.example.practice.clazz.Pojo;
import jdk.internal.loader.ClassLoaders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * classloader是用来加载 Class 的。它负责将Class 的字节码形式转换成内存形式的 Class 对象。
 * 字节码可以来自于磁盘文件 .class，也可以是 jar 包里的 .class，也可以来自远程服务器提供的字节流，字节码的本质就是一个字节数组 []byte，它有特定的复杂的内部格式。
 * <p>
 * JVM结构与Java内存模型 https://www.jianshu.com/p/7cdbf69f297f
 * 理解JVM ClassLoader https://juejin.im/post/5c04892351882516e70dcc9b
 */
class ClassLoaderTests {

    /**
     * 自定义ClassLoader
     */
    private static class CustomClassLoader extends ClassLoader {

        @Override
        public Class findClass(String name) throws ClassNotFoundException {
            System.out.println("load class with CustomClassLoader.");
            byte[] b = loadClassFromFile(name);
            return defineClass(name, b, 0, b.length);
        }

        private byte[] loadClassFromFile(String fileName) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                    fileName.replace('.', File.separatorChar) + ".class");
            byte[] buffer;
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int nextValue = 0;
            try {
                while ((nextValue = inputStream.read()) != -1) {
                    byteStream.write(nextValue);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer = byteStream.toByteArray();
            return buffer;
        }
    }

    /**
     * 内置Classloader  AppClassLoader
     */
    @Test
    @DisplayName("打印类加载器")
    void printClassLoaders() {
        System.out.println("Classloader of this class:" + Pojo.class.getClassLoader());
        System.out.println("Classloader of Logging:" + Field.class.getClassLoader());
        System.out.println("Classloader of System:" + System.class.getClassLoader());
        try {
            System.out.println(ClassLoaders.class.getName());
        } catch (IllegalAccessError e) {
            System.out.println("cannot access class jdk.internal.loader.ClassLoaders.");
        }
        System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
    }

    /**
     * 自定义类加载器，可用于java代码混淆加密
     */
    @Test
    @DisplayName("使用自定义类加载器")
    void customClassLoaders() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class aClass = customClassLoader.loadClass("com.example.practice.clazz.Generic");
        var generic = aClass.getDeclaredConstructor().newInstance();
        System.out.println(generic.getClass().getClassLoader());
        System.out.println(CustomClassLoader.class.getClassLoader());
    }

}
