package com.example.project.datatype.primitive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * long 数据类型是 64 位、有符号的以二进制补码表示的整数；
 */
class LongTests {

    @Test
    @DisplayName("Long取值范围")
    void range() {
        System.out.println("MIN: " + Long.MIN_VALUE);
        System.out.println("MAX: " + Long.MAX_VALUE);
        System.out.println("SIZE: "+Long.SIZE);
    }
}
