package com.java.practice.algorithm.conversions;

import org.junit.jupiter.api.Test;

class BinaryToOctalTests {

    /**
     * This method converts a binary number to
     * an octal number.
     *
     * @param binary The binary number
     * @return The octal number
     */
    static String convertBinaryToOctal(int binary) {
        String octal = "";
        int currBit = 0, j = 1;
        while (binary != 0) {
            int code3 = 0;
            for (int i = 0; i < 3; i++) {
                currBit = binary % 10;
                binary = binary / 10;
                code3 += currBit * j;
                j *= 2;
            }
            octal = code3 + octal;
            j = 1;
        }
        return octal;
    }

    @Test
    void test() {
        int b = 10101010;
        System.out.println("Octal equivalent: " + convertBinaryToOctal(b));
    }
}
