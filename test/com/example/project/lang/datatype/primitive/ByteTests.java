package com.example.project.lang.datatype.primitive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * byte 数据类型是8位、有符号的，以二进制补码表示的整数
 * 字节 Byte 和比特 bit 的换算关系是 1 Byte = 8 bit
 * 通常用作计算机信息计量单位，不分数据类型。一个字节代表八个比特
 */
class ByteTests {

    @Test
    @DisplayName("取值范围")
    void range() {
        System.out.println("MIN: " + Byte.MIN_VALUE);
        System.out.println("MAX: " + Byte.MAX_VALUE);
        System.out.println("SIZE: " + Byte.SIZE);
    }

    @Test
    @DisplayName("字符串用字节表示，互相转换，字节是个桥梁")
    void convert(){
        String s = "fs123$fdsa是";//String变量
        byte b[] = s.getBytes();//String转换为byte[]
        String t = new String(b);//bytep[]转换为String
        System.out.println(t);
    }
}
