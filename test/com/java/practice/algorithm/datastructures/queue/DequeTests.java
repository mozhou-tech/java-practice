package com.java.practice.algorithm.datastructures.queue;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 既可以添加到队尾，也可以添加到队首；
 * 既可以从队首获取，又可以从队尾获取。
 * 双端队列
 *
 * 可见面向抽象编程的一个原则就是：尽量持有接口，而不是具体的实现类。
 */
 class DequeTests {

    @Test
    void test(){
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A
        deque.offerLast("B"); // B -> A
        deque.offerFirst("C"); // B -> A -> C
        System.out.println(deque.pollFirst()); // C, 剩下B -> A
        System.out.println(deque.pollLast()); // B
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null
    }
}
