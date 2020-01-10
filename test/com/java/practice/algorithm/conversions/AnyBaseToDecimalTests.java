package com.java.practice.algorithm.conversions;

import org.junit.jupiter.api.Test;

/**
 * 任何进制转换为10进制
 */
class AnyBaseToDecimalTests {

    // Driver program
    static class AnyBaseToDecimal {

        /**
         * Convert any radix to decimal number
         *
         * @param s     the string to be convert
         * @param radix the radix
         * @return decimal of bits
         * @throws NumberFormatException if {@code bits} or {@code radix} is invalid
         */
        static int convertToDecimal(String s, int radix) {
            int num = 0;
            int pow = 1;

            for (int i = s.length() - 1; i >= 0; i--) {
                int digit = valOfChar(s.charAt(i));
                if (digit >= radix) {
                    throw new NumberFormatException("For input string " + s);
                }
                num += valOfChar(s.charAt(i)) * pow;
                pow *= radix;
            }
            return num;
        }

        /**
         * Convert character to integer
         *
         * @param c the character
         * @return represented digit of given character
         * @throws NumberFormatException if {@code ch} is not UpperCase or Digit character.
         */
        static int valOfChar(char c) {
            if (!(Character.isUpperCase(c) || Character.isDigit(c))) {
                throw new NumberFormatException("invalid character :" + c);
            }
            return Character.isDigit(c) ? c - '0' : c - 'A' + 10;
        }
    }

    @Test
    void test() {
        System.out.println(AnyBaseToDecimal.convertToDecimal("1010", 2));
        assert AnyBaseToDecimal.convertToDecimal("1010", 2) == Integer.valueOf("1010", 2);
        assert AnyBaseToDecimal.convertToDecimal("777", 8) == Integer.valueOf("777", 8);
        assert AnyBaseToDecimal.convertToDecimal("999", 10) == Integer.valueOf("999", 10);
        assert AnyBaseToDecimal.convertToDecimal("ABCDEF", 16) == Integer.valueOf("ABCDEF", 16);
        assert AnyBaseToDecimal.convertToDecimal("XYZ", 36) == Integer.valueOf("XYZ", 36);
    }
}
