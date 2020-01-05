package com.example.project.datastruc.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * set继承于Collections，不允许重复元素的无序集合
 * 在判断重复元素的时候，Set集合会调用hashCode()和equal()方法来实现。
 */
class SetTests {

    @Test
    @DisplayName(value = "HashSet 哈希表结构，使用HashMap的Key存储元素，")
    void HashSet(){

    }

    @Test
    @DisplayName(value = "TreeSet 红黑树结构，每个元素都是树中的一个节点，插入的元素都会排序")
    void TreeSet(){

    }

    /**
     * 该构造方法内部调用的是 LinkedHashMap 的构造方法，比HashMap多维护了一个双向链表来维护元素的添加顺序
     */
    @Test
    @DisplayName("LinkedHashSet ")
    void LinkedHashSet(){

    }
}
