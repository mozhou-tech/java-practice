package com.java.practice.algorithm.datastructures.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * Stack测试
 */
class StackTests {

    private Stack<String> stack = new Stack<String>();

    @Test
    void test() {
        stack.push("1");
        stack.push("2");
        System.out.println(String.format("返回但不从stack删除 %s", stack.peek()));
        System.out.println(String.format("返回并从stack删除 %s", stack.pop()));
        System.out.println(String.format("stack长度 %s", stack.size()));
        System.out.println(stack.isEmpty());
    }
}
