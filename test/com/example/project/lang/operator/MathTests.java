package com.example.project.lang.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MathTests {

    @DisplayName("数学运算")
    @Test
    void main(){
        int a = 10;
        int b = 20;
        int c = 25;
        int d = 25;
        System.out.println("a + b = " + (a + b) );
        System.out.println("a - b = " + (a - b) );
        System.out.println("a * b = " + (a * b) );
        System.out.println("b / a = " + (b / a) );
        System.out.println("b % a = " + (b % a) );
        System.out.println("c % a = " + (c % a) );
        System.out.println("a++   = " +  (a++) );
        System.out.println("a--   = " +  (a--) );
        // 查看  d++ 与 ++d 的不同
        System.out.println("d++   = " +  (d++) );
        System.out.println("++d   = " +  (++d) );
    }

    @Test
    @DisplayName("关系运算")
    void relation(){
        int a = 10;
        int b = 20;
        System.out.println("a == b = " + (a == b) );
        System.out.println("a != b = " + (a != b) );
        System.out.println("a > b = " + (a > b) );
        System.out.println("a < b = " + (a < b) );
        System.out.println("b >= a = " + (b >= a) );
        System.out.println("b <= a = " + (b <= a) );
    }

    @Test
    @DisplayName("位数运算")
    void bit(){
        int a = 60; /* 60 = 0011 1100 */
        int b = 13; /* 13 = 0000 1101 */
        int c = 0;
        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c );

        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c );

        c = a ^ b;       /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c );

        c = ~a;          /*-61 = 1100 0011 */
        System.out.println("~a = " + c );

        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c );

        c = a >> 2;     /* 15 = 1111 */
        System.out.println("a >> 2  = " + c );

        c = a >>> 2;     /* 15 = 0000 1111 */
        System.out.println("a >>> 2 = " + c );
    }
}
