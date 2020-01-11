package com.java.practice.lang.datatype;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * 在Java中，由CPU原生提供的整型最大范围是64位long型整数。使用long型整数可以直接通过CPU指令进行计算，速度非常快。
 */
class BigIntegerTests {
    @Test
    void test() {
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 12345678902469135780
        System.out.println(sum);
    }
}
