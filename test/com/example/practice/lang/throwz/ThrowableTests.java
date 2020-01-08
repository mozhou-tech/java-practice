package com.example.practice.lang.throwz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ThrowableTests {

    @Test
    @DisplayName("处理文件异常")
    void test() {
        String fileName = System.getProperty("user.dir") + "/test/com/example/practice/lang/throwz/a.txt";
        FileInputStream file;
        byte x;
        try {
            file = new FileInputStream(fileName);
            x = (byte) file.read();
        } catch (FileNotFoundException f) { // Not valid!
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            // 释放资源等操作
        }
    }
}
