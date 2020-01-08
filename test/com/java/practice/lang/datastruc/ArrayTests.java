package com.java.practice.lang.datastruc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组对于每一门编程语言来说都是重要的数据结构之一，当然不同语言对数组的实现及处理也不尽相同。
 * Java 语言中提供的数组是用来存储固定大小的同类型元素。
 */
class ArrayTests {

    @Test
    @DisplayName("一个数组结构的处理")
    void anIntArray() {
        // 创建一个int数组
        int[] arrayRefVar = new int[100];
        // 指定范围遍历
        for (int i = 0; i < 100; i++) {
            arrayRefVar[i] = i;
        }
        int sum = 0;
        // 遍历数组，forEach循环
        for (int j : arrayRefVar) {
            sum += j;
        }
        System.out.println(sum);
    }

    @Test
    @DisplayName("初始化一个数组")
    void initArray() {
        char[] chars = {'a', 'b', 'c', 'd'};
        StringBuilder s = new StringBuilder();
        for (char c : chars) {
            s.append(c);
        }
        Assertions.assertEquals(s.toString(), "abc");
        System.out.println(s);
        System.out.println(chars.hashCode());
    }

    @Test
    @DisplayName("多维数组处理")
    void multiArray() {
        char[][] chars = new char[2][2];
        chars[0][0] = 'a';
        chars[0][1] = 'b';
        chars[1][0] = 'c';
        chars[1][1] = 'd';
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] c1 : chars) {
            for (char c2 : c1) {
                stringBuilder.append(c2);
            }
        }
        System.out.println(stringBuilder.toString().equals("abcd"));
    }

    @Test
    @DisplayName("Arrays工具类")
    void ArraysUtil() {
        // 快速建立一个ArrayList
        List<Integer> integers = Arrays.asList(1, 3, 4);
        System.out.println(integers);
        List<String> strings = Arrays.asList("a","b","c");
        System.out.println(strings);

        // 自然顺序排序
        char[] chars = {'z','x','a','1','0'};
        Arrays.sort(chars);
        System.out.println(chars);
        /**
         * 用二分查找算法在给定数组中搜索给定值的对象(Byte,Int,double等)。数组在调用前必须排序好的。
         * 如果查找值包含在数组中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。
         */
        int index = Arrays.binarySearch(chars,'a');
        System.out.println("字符所在位置：" + index);
        int indexNotFound = Arrays.binarySearch(chars,'q');
        System.out.println("如果找不到，则返回-（插入点）： "+indexNotFound);
        int[] ints = {1,3,4,5};
        /**
         * 填充数组
         */
        Arrays.fill(ints,0);
        List<Integer> integerList = new ArrayList<>();
        for (Integer in : ints) integerList.add(in);
        System.out.println(integerList);
        /**
         * 比较两个数组
         */
        boolean equal = Arrays.equals(ints, new int[]{0,0,0,0});
        System.out.println(equal);
    }
}
