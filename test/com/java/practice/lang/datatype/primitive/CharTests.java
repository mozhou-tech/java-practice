package com.java.practice.lang.datatype.primitive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * char类型是一个单一的 16 位 Unicode 字符
 * char 数据类型可以储存任何字符；
 */
class CharTests {
    @Test
    @DisplayName("取值范围")
    void range() {
        // 最小值是 \u0000（即为0）；
        System.out.println("MIN: " + Character.MIN_VALUE);
        // 最大值是 \uffff（即为65,535）；
        System.out.println("MAX: " + Character.MAX_VALUE);
        System.out.println("SIZE: " + Character.SIZE);
    }
}
