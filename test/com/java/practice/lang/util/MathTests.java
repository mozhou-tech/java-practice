package com.java.practice.lang.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;

class MathTests {

    @Test
    @DisplayName("数学工具")
    void math() {
        // 绝对值
        Math.abs(-100); // 100
        Math.abs(-7.8); // 7.8
        // 最大值或最小值
        Math.max(100, 99); // 100
        Math.min(1.2, 2.3); // 1.2
        // 2的10次方
        Math.pow(2, 10); // 2的10次方=1024
        // 根号2
        Math.sqrt(2); // 1.414...
        // e的2次方
        Math.exp(2); // 7.389...
        // e为底4的对数
        Math.log(4); // 1.386...
        // 以10为底，100的对数
        Math.log10(100); // 2
        // 三角函数
        Math.sin(3.14); // 0.00159...
        Math.cos(3.14); // -0.9999...
        Math.tan(3.14); // -0.0015...
        Math.asin(1.0); // 1.57079...
        Math.acos(1.0); // 0.0
        // 随机数
        Math.random(); // 0.53907... 每次都不一样
    }

    @Test
    @DisplayName("生成伪随机数")
    void random() {
        Random r = new Random();
        r.nextInt(); // 2071575453,每次都不一样
        r.nextInt(10); // 5,生成一个[0,10)之间的int
        r.nextLong(); // 8811649292570369305,每次都不一样
        r.nextFloat(); // 0.54335...生成一个[0,1)之间的float
        r.nextDouble(); // 0.3716...生成一个[0,1)之间的double
    }

    /**
     * 无法指定种子，它使用RNG（random number generator）算法
     */
    @Test
    @DisplayName("生成真随机数")
    void SecureRandom(){
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt(100));
    }
}
