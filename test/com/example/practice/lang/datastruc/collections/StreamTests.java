package com.example.practice.lang.datastruc.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    @Test
    @DisplayName("打印随机数，遍历")
    void PrintLimitString() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        System.out.println("======sorted=====");
        random.ints().limit(10).sorted().forEach(System.out::println);
    }


    @Test
    @DisplayName("统计整形数组中元素的最大值，最小值，平均值，个数，元素总和等等")
    void statics(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    @Test
    @DisplayName("顶点印务")
    void output(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);
    }
}
