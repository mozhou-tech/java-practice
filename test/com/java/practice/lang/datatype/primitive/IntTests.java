package com.java.practice.lang.datatype.primitive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * int 数据类型是32位、有符号的以二进制补码表示的整数；默认值为0
 * 自动拆装类Integer 默认值为null
 */
class IntTests {

    @Test
    @DisplayName("Integer取值范围")
    void range() {
        System.out.println("MIN: " + Integer.MIN_VALUE);
        System.out.println("MAX: " + Integer.MAX_VALUE);
        System.out.println("SIZE: " + Integer.SIZE);
    }

    @Test
    @DisplayName("Integer的区别")
    void Integer() {
        Integer integer1 = 11;
        int integer2 = 11;
        Assertions.assertEquals(integer1, integer2);
    }

    @Test
    @DisplayName("引用地址问题(在JDK9中已过时)")
    void IntegerReference() {
        Integer integer1 = 1;
        Integer integer2 = 1;
        Integer integer3 = new Integer(1);
        System.out.println(integer1.hashCode());
        System.out.println(integer2.hashCode());
        System.out.println(integer3.hashCode());
        System.out.println(integer1.equals(integer2));
        /**
         * 返回False
         *
         * Integer变量实际上是对一个Integer对象的引用。当new一个Integer时，实际上是生成一个指针指向此对象，两次new Integer生成的是两个对象，
         * 其内存地址不同，所以两个new出来的Integer变量不等。
         */
        System.out.println(integer3.equals(integer1));
    }

    @Test
    @DisplayName("比较两个非new生成的Integer变量(该问题，在jdk9中已过时)")
    void Integer1(){
        Integer i1 = 127;
        Integer ji = 127;
        // java在编译Integer i1 = 127时，会翻译成Integer i1 = Integer.valueOf(127)。查看Interger源码：
        System.out.println(i1.equals(ji));//输出：true

        Integer i2 = 128;
        Integer j2 = 128;
        // Integer i2 = 128时，不会将128缓存，Integer j2 = 128时，会return new Integer(128)。所以结果为false。
        System.out.println(i2.equals(j2));//输出：false
    }

}
