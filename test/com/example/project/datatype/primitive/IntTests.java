package com.example.project.datatype.primitive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * int 数据类型是32位、有符号的以二进制补码表示的整数；
 */
class IntTests {

    @Test
    @DisplayName("Integer取值范围")
    void range() {
        System.out.println("MIN: " + Integer.MIN_VALUE);
        System.out.println("MAX: " + Integer.MAX_VALUE);
        System.out.println("SIZE: " + Integer.SIZE);
    }

}
