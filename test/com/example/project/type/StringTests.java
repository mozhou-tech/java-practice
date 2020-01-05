package com.example.project.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTests {
    /**
     * 不是线程安全，速度快，常用
     */
    @Test
    @DisplayName(value = "字符串拼接，高性能")
    void StringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(i);
        }
        // 删除部分char
        stringBuilder.delete(0, 3);
        // 逆序
        stringBuilder.reverse();
        // 设置新长度
        stringBuilder.setLength(5);
        System.out.println(stringBuilder.toString());
        // 字符串截取
        System.out.println(stringBuilder.substring(0, 2));
        Assertions.assertEquals(stringBuilder.substring(0, 2), "99");
        stringBuilder.setCharAt(0, 'a');
        System.out.println(stringBuilder.toString());
        // 替换特定位置的char
        Assertions.assertEquals("a9989", stringBuilder.toString());
    }

    /**
     * 线程安全
     */
    @Test
    @DisplayName(value = "字符串拼接，线程安全")
    void StringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        class ThreadStr extends Thread {

        }
        for (int i = 0; i < 1000; i++) {
            stringBuffer.append(1);
        }
        System.out.println(stringBuffer.toString());
    }
}
