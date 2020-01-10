package com.java.practice.datastruc.stack;

import org.junit.jupiter.api.Test;

/**
 * 栈(Stack),是一种特殊的线性表，只能在固定的一端(线性表的尾端)进行插入、删除操作。
 * 它是一个后进先出的集合（它存储于栈中），后进先出的意思顾名思义，也就是说取数据只能从最后放进去的那个数据开始取。
 * <p>
 * 允许进行插入、删除操作的一端为栈顶(top),另一端，你猜？(bottom)
 * <p>
 * 进栈：将一个元素插入栈的过程，栈的长度+1，(压入子弹)
 * 出栈：删除一个元素的过程，栈的长度-1.(弹出发射...)
 * <p>
 * 先进后出，或者说后进先出。
 * 常用操作：初始化，(随着栈帧的移除，方法在执行。可能出现stackoverflow.com/),++i,i++,
 * 在Java中继承关系，Stack继承自Vector，List，(abstractList?)
 */
class StackTests {

    /**
     * 链表的实现
     * @param <T>
     */
    static class LinkedStack<T> {

        private static class Node<U> {
            U item;
            Node<U> next;

            Node() {
                item = null;
                next = null;
            }

            Node(U item, Node<U> next) {
                this.item = item;
                this.next = next;
            }

            boolean end() {
                return item == null && next == null;
            }
        }

        private Node<T> top = new Node<T>();

        public void push(T item) {
            top = new Node<T>(item, top);
        }

        public T pop() {
            T result = top.item;
            if (!top.end()) {
                top = top.next;
            }
            return result;
        }
    }

    @Test
    void test() {
        LinkedStack<String> lss = new LinkedStack<String>();

        // 入栈
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        String s;
        // 出栈
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}
