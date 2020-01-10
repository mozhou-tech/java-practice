package com.java.practice.datastruc.queue;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 队列(queue),也是一种特殊的线性表，使用固定的一端来插入数据，另一端用于删除数据
 * 它是一个先进先出的集合（它存储于队列中），先进先出的意思也就是最先放进集合的数据，拿数据的时候从最初放进去的数据开始拿。
 * <p>
 * 先进先出，就像火车站排队买票一样！！！，整个队伍向前面移动。
 * 分为顺序队列结构和链式队列结构
 * 从JDK 5 开始，Java集合框架提供了Queue接口，实现该接口的类可以当成队列使用，如LinkedBlockingQueue，PriorityBlockingQueue。
 * 可以通过轮询和等待-通知机制实现阻塞队列。
 */
class SimpleQueueTests {

    static class SimpleQueue<T> implements Iterable<T> {
        private LinkedList<T> storage = new LinkedList<T>();

        public void add(T t) {
            storage.offer(t);
        }

        public T get() {
            return storage.poll();
        }

        public Iterator<T> iterator() {
            return storage.iterator();
        }
    }

    @Test
    void test() {
        SimpleQueue queue = new SimpleQueue();
        queue.add(5);
        queue.add(8);
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
    }

}
