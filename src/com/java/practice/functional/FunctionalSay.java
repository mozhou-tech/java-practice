package com.java.practice.functional;

/**
 * 函数式接口
 *
 * @author jerrylau
 */
@FunctionalInterface
public interface FunctionalSay<T> {
    /**
     * @param info
     * @return
     */
    String say(T info);
}
