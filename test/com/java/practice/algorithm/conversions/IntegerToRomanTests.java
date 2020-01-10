package com.java.practice.algorithm.conversions;

import org.junit.jupiter.api.Test;

/**
 * 整型转罗马数字
 */
class IntegerToRomanTests {

    private static int[] allArabianRomanNumbers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] allRomanNumbers = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    //Value must be > 0

    static String integerToRoman(int num) {
        if (num <= 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (int a = 0; a < allArabianRomanNumbers.length; a++) {
            int times = num / allArabianRomanNumbers[a];
            for (int b = 0; b < times; b++) {
                builder.append(allRomanNumbers[a]);
            }

            num -= times * allArabianRomanNumbers[a];
        }

        return builder.toString();
    }

    @Test
    void test() {
        System.out.println(integerToRoman(2131));
    }
}
