package com.example.project.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * List是一个接口，不能直接实例化
 */
class ListTests {

    @DisplayName(value = "")
    @Test
    void LinkedList(){

    }

    @DisplayName(value = "字符串数组转换为List类型")
    @Test
    void StringArrayToList() {
        java.util.List<String> asList = Arrays.asList("a", "b");
        java.util.List<Integer> numList = Arrays.asList(1, 2, 3);
        System.out.println(asList);
        System.out.println(numList);
    }

    @DisplayName(value = "List增删改查")
    @Test
    void ArrayListCurd() {
        java.util.List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");
        stringList.remove(2);
        stringList.remove("e");
        stringList.set(0, "z");
        System.out.println(stringList);
        assert stringList.size() == 3 : "list元素数量";
    }
}
