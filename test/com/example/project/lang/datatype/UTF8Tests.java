package com.example.project.lang.datatype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 一个utf8数字占1个字节
 * 一个utf8英文字母占1个字节
 * 少数是汉字每个占用3个字节，多数占用4个字节。
 * 所以，UTF-8编码是变长编码
 * 万能编码
 */
public class UTF8Tests {

    @Test
    @DisplayName("汉字占几个字节，3或4个字节")
    void hanzi() {
        // https://blog.csdn.net/qiaqia609/article/details/8069678  UTF-8编码表
        String s = "一";
        System.out.println("一字符数: " + s.length());
        System.out.println("一字节数: " + s.getBytes().length);

        String s1 = "褶";
        System.out.println("褶字符数: " + s1.length());
        System.out.println("褶字节数: " + s1.getBytes().length);
        System.out.println("褶Byte " + s1.getBytes());
    }

    @Test
    @DisplayName("数字和字母占几个字节")
    void numeric() {
        System.out.println("数字字节数:" + "1".getBytes().length);
        System.out.println("字母字节数:" + "a".getBytes().length);
    }
}
