package com.example.project.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTests {
    /**
     * 不是线程安全，速度快，常用
     */
    @Test
    @DisplayName(value = "字符串拼接，高性能")
    void StringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(i);
        }
        // 删除部分char
        stringBuilder.delete(0, 3);
        // 逆序
        stringBuilder.reverse();
        // 设置新长度
        stringBuilder.setLength(5);
        System.out.println(stringBuilder.toString());
        // 字符串截取
        System.out.println(stringBuilder.substring(0, 2));
        Assertions.assertEquals(stringBuilder.substring(0, 2), "99");
        stringBuilder.setCharAt(0, 'a');
        System.out.println(stringBuilder.toString());
        // 替换特定位置的char
        Assertions.assertEquals("a9989", stringBuilder.toString());
    }

    /**
     * StringBuffer 处理线程
     */
    static class ThreadStrBuf implements Runnable {

        private Thread t;

        private String threadName;

        private StringBuffer stringBuffer;

        private Character character;

        ThreadStrBuf(String threadName, StringBuffer stringBuffer, Character character) {
            this.threadName = threadName;
            this.stringBuffer = stringBuffer;
            this.character = character;
        }

        public void run() {
            System.out.println("Theard " + this.threadName + " started.");
            for (int i = 0; i < 1000; i++) {
                stringBuffer.append(this.character);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        void start() throws InterruptedException {
            if (t == null) {
                this.t = new Thread(this, this.threadName);
                // 使线程 从异步执行 变成同步执行
                this.t.join();
                this.t.start();
            }
        }

        String getResultString() {
            return stringBuffer.toString();
        }
    }

    /**
     * StringBuffer线程安全
     */
    @Test
    @DisplayName(value = "字符串拼接，线程安全")
    void StringBuffer() throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer();
        ThreadStrBuf threadStrBuf1 = new ThreadStrBuf("test", stringBuffer, '1');
        ThreadStrBuf threadStrBuf2 = new ThreadStrBuf("test", stringBuffer, '2');
        threadStrBuf1.start();
        threadStrBuf2.start();
        Thread.sleep(1000);
        System.out.println(threadStrBuf1.getResultString());
        System.out.println(threadStrBuf2.getResultString());
    }
}
