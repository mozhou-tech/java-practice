package com.java.practice.lang.annotate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by liuyuancheng on 2020/5/25  <br/>
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MarkerAnno {
}
public class MarkerTest {

    /**
     * 标记注解不包含成员，它存在的唯一目的就是标记声明。可以使用由AnnotatedElement接口定义的isAnnotationPresent()方法确定标记注解是否存在。
     */
    @Test
    @DisplayName("注解（标记）")
    @MarkerAnno
    public void test() {
        MarkerTest mt = new MarkerTest();
        try {
            Method m = mt.getClass().getMethod("test");
            if (m.isAnnotationPresent(MarkerAnno.class)) {
                System.out.println("MarkerAnno is present.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("Method Not Found.");
        }
    }
}
