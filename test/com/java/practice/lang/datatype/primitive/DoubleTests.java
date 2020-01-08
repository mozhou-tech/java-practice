package com.java.practice.lang.datatype.primitive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；
 * 浮点数的默认类型为double类型；
 * double类型同样不能表示精确的值，如货币；
 * 默认值是 0.0d；
 * 1bit（符号位） 11bits（指数位） 52bits（尾数位）
 */
class DoubleTests {

    @Test
    @DisplayName("Double取值范围")
    void range() {
        System.out.println("MIN: " + Double.MIN_VALUE);
        System.out.println("MAX: " + Double.MAX_VALUE);
        System.out.println("SIZE: " + Double.SIZE);
    }

}
