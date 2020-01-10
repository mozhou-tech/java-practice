package com.java.practice.algorithm.conversions;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BinaryToHexadecimalTests {
    /**
     * This method converts a binary number to
     * a hexadecimal number.
     *
     * @param binary The binary number
     * @return The hexadecimal number
     */
    static String binToHex(int binary) {
        //hm to store hexadecimal codes for binary numbers within the range: 0000 to 1111 i.e. for decimal numbers 0 to 15
        HashMap<Integer, String> hm = new HashMap<>();
        //String to store hexadecimal code
        String hex = "";
        int i;
        for (i = 0; i < 10; i++) {
            hm.put(i, String.valueOf(i));
        }
        for (i = 10; i < 16; i++) hm.put(i, String.valueOf((char) ('A' + i - 10)));
        int currbit;
        while (binary != 0) {
            int code4 = 0;    //to store decimal equivalent of number formed by 4 decimal digits
            for (i = 0; i < 4; i++) {
                currbit = binary % 10;
                binary = binary / 10;
                code4 += currbit * Math.pow(2, i);
            }
            hex = hm.get(code4) + hex;
        }
        return hex;
    }

    @Test
    void test(){
        int binary = 1010101;
        String hex = binToHex(binary);
        System.out.println("Hexadecimal Code:" + hex);
    }
}
