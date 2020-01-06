package com.example.project.datatype.primitive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * byte 数据类型是8位、有符号的，以二进制补码表示的整数
 */
class ByteTests {

    @Test
    @DisplayName("取值范围")
    void range() {
        System.out.println("MIN: " + Byte.MIN_VALUE);
        System.out.println("MAX: " + Byte.MAX_VALUE);
        System.out.println("SIZE: " + Byte.SIZE);
    }
}
