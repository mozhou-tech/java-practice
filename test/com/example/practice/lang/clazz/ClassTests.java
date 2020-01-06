package com.example.practice.lang.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * java.lang.Class类是反射机制(Reflection)的基础
 */
class ClassTests {

    /**
     * 它是随着类的加载而执行，只执行一次，并优先于主函数。具体说，静态代码块是由类调用的。类调用时，先执行静态代码块，然后才执行主函数的。
     * 静态代码块其实就是给类初始化的，而构造代码块是给对象初始化的。
     * 静态代码块中的变量是局部变量，与普通函数中的局部变量性质没有区别。
     * 一个类中可以有多个静态代码块
     */
    static {
        System.out.println("执行静态代码块");
    }

    /**
     * 1.对象一建立，就会调用与之相应的构造函数，也就是说，不建立对象，构造函数时不会运行的。
     * 2.构造函数的作用是用于给对象进行初始化。
     * 3.一个对象建立，构造函数只运行一次，而一般方法可以被该对象调用多次。
     */
    ClassTests(){
        System.out.println("执行了构造方法");
    }

    /**
     * 构造代码块的作用是给对象进行初始化。
     * 对象一建立就运行构造代码块了，而且优先于构造函数执行。这里要强调一下，有对象建立，才会运行构造代码块，类不能调用构造代码块的，而且构造代码块与构造函数的执行顺序是前者先于后者执行。
     *
     * 构造代码块与构造函数的区别是：构造代码块是给所有对象进行统一初始化，而构造函数是给对应的对象初始化，因为构造函数是可以多个的，
     * 运行哪个构造函数就会建立什么样的对象，但无论建立哪个对象，都会先执行相同的构造代码块。也就是说，构造代码块中定义的是不同对象共性的初始化内容。
     */
    {
        System.out.println("执行了对象初始化块");
    }

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
