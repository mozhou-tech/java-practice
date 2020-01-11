package com.java.practice.lang.datatype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

class StringTests {
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

    @Test
    @DisplayName("分隔符拼接数组的需求很常见")
    void StringJoiner(){
        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
        System.out.println("==================添加开头和结尾===============");
        String[] names1 = {"Bob", "Alice", "Grace"};
        var sj1 = new StringJoiner(", ", "Hello ", "!");
        for (String name : names1) {
            sj1.add(name);
        }
        System.out.println(sj1.toString());
        System.out.println("============String.join()静态方法，拼接String[]===============");

        String[] names2 = {"Bob", "Alice", "Grace"};
        var s = String.join(", ", names2);
        System.out.println(s);
    }

    /**
     * StringBuffer 处理线程
     */
    static class ThreadStrBuf implements Runnable {

        // 线程
        private Thread t;

        // 线程名称
        private String threadName;

        // 容器
        private StringBuffer stringBuffer;

        // 重复出现的字符
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
                // 使线程 从异步执行 变成同步执行; 阻塞主线程
                this.t.join();
                this.t.start();
            }
        }

        /**
         * 获得线程处理结果
         * @return
         */
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
        ThreadStrBuf threadStrBuf1 = new ThreadStrBuf("test1", stringBuffer, '1');
        ThreadStrBuf threadStrBuf2 = new ThreadStrBuf("test2", stringBuffer, '2');
        threadStrBuf1.start();
        threadStrBuf2.start();
        Thread.sleep(1000);
        Assertions.assertEquals(threadStrBuf1.getResultString(),threadStrBuf2.getResultString());
        System.out.println(threadStrBuf1.getResultString());
    }

}
