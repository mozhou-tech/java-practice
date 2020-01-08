package com.example.practice.lang.datastruc.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 */
class StreamTests {

    @Test
    @DisplayName("统计元素数量，lambda按条件过滤")
    void CountAndFilter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println(String.format("空字符串的数量：%s", count));
        count = strings.stream().filter(string -> string.contains("j")).count();
        System.out.println(String.format("含有字符串的数量：%s", count));
    }


}
