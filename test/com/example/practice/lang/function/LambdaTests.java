package com.example.practice.lang.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * eta-conversion
 * Math::max等效于(a, b)->Math.max(a, b)
 * String::startWith等效于(s1, s2)->s1.startWith(s2)
 * s::isEmpty等效于()->s.isEmpty()
 */
class LambdaTests {

    @Test
    @DisplayName("双冒号的用法")
    void doubleQuota() {
        List list = Arrays.asList(1, 3, 4, 5, "a", "asdfasdf");
        list.forEach(System.out::println);
    }

    @Test
    @DisplayName("匿名函数用法")
    void func() {
        int a = 1;
        int b = -1;
        Predicate<Integer> predicate = i -> i >= 0;
        System.out.println(predicate.test(a));  //true
        System.out.println(predicate.test(b));  //false
    }
}
