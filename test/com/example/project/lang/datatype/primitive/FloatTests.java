package com.example.project.lang.datatype.primitive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
 * float 在储存大型浮点数组的时候可节省内存空间；
 * 认值是 0.0f
 * 不能用来表示精确的值，如：货币
 * 数值 =尾数× 底数 ^ 指数
 * 1bit（符号位） 8bits（指数位） 23bits（尾数位）
 */
 class FloatTests {

    @Test
    @DisplayName("取值范围")
    void range() {
        System.out.println("MIN: " + Float.MIN_VALUE);
        System.out.println("MAX: " + Float.MAX_VALUE);
        System.out.println("SIZE: " + Float.SIZE);
    }

}
