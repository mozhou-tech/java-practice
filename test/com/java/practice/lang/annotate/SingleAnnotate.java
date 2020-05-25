package com.java.practice.lang.annotate;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by liuyuancheng on 2020/5/25  <br/>
 */
@Retention(RetentionPolicy.RUNTIME)
@interface SingleAnno {

    int value();

}
public class SingleAnnotate {

    @SingleAnno(100)
    public void test() {}

    @Test
    void test1() throws NoSuchMethodException {
        System.out.println(Arrays.toString(this.getClass().getMethods()));
        Method m = this.getClass().getMethod("test");
        if (m.isAnnotationPresent(SingleAnno.class)) {
            System.out.println("MarkerAnno is present.");
        }else {
            System.out.println("no MarkerAnno");
        }
    }
}
