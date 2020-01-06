package com.example.project.lang.datatype.primitive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * short 数据类型是 16 位、有符号的以二进制补码表示的整数
 * 默认值 0
 */
 class ShortTests {

    @Test
    @DisplayName("Short取值范围")
    void range() {
        System.out.println("MIN: " + Short.MIN_VALUE);
        System.out.println("MAX: " + Short.MAX_VALUE);
        System.out.println("SIZE: " + Short.SIZE);
    }

}
