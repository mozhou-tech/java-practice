package com.example.practice.lang.datatype.primitive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * boolean数据类型表示一位的信息
 *
 * boolean是基本数据类型
 * Boolean是它的封装类，和其他类一样，有属性有方法，可以new，
 * 因为boolean在堆栈中，所以更加高效一些。
 */
class BooleanTests {

    @Test
    @DisplayName("Boolean取值范围")
    void range(){
        System.out.println("SIZE: 1");
    }

    @Test
    @DisplayName("从Hash表中获取值时，不能用基本类型")
    void onlyBoolean(){

        boolean t = false;
        /**
         * 在hash表中，只能使用Object，不能使用基本类型
         */
        Map<String, Boolean> map = new HashMap<>();
        map.put("t", t);
        Boolean t1 = (Boolean) map.get("t");
        System.out.println(t1);
        Assertions.assertFalse(t1);
    }
}
