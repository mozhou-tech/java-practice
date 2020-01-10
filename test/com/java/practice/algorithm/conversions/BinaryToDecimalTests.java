package com.java.practice.algorithm.conversions;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

class BinaryToDecimalTests {

    /**
     * 二进制转10进制
     */
    @Test
    void test() {
        int binNum, binCopy, d, s = 0, power = 0;

        binNum = 101001010;

        System.out.print("Binary number: ");
        binCopy = binNum;
        while (binCopy != 0) {
            d = binCopy % 10;
            s += d * (int) Math.pow(2, power++);
            binCopy /= 10;
        }
        System.out.println("Decimal equivalent:" + s);
    }

}
