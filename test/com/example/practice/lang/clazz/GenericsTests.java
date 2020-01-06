package com.example.practice.lang.clazz;

import com.example.practice.clazz.Generic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 泛型
 */
class GenericsTests {

    private static Generic generic;

    @BeforeAll
    static void before(){
        generic = new Generic();
    }

    @Test
    @DisplayName("获取泛型变量的数据类型")
    void test() throws ClassNotFoundException {
        // 泛型传入Integer
        generic.setT(1);
        System.out.println(generic.getT());
        System.out.println(generic.getT().getClass().getSimpleName());
        // 泛型传入 String
        generic.setK("a");
        System.out.println(generic.getK());
        String typeName = Class.forName(generic.getK().getClass().getName()).getName();
        System.out.println(String.format("传入参数的数据类型：%s",typeName));
    }
}
