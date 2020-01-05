package com.example.project.datastruc.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StreamTests {

    @Test
    @DisplayName("统计元素数量")
    void count(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println(count);
        count = strings.stream().filter(string -> string.contains("j")).count();
        System.out.println(count);
    }

}
