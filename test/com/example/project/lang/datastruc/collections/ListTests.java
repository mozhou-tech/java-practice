package com.example.project.lang.datastruc.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        List<String> stringList = new ArrayList<>();
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


    /**
     * synchronizedList在迭代的时候，需要开发者自己加上线程锁控制代码，因为在整个迭代的过程中如果在循环外面不加同步代码，
     * 在一次次迭代之间，其他线程对于这个容器的add或者remove会影响整个迭代的预期效果，所以这里需要在整个循环外面加上synchronized(list);
     */
    @DisplayName(value = "ArrayList并不是线程安全的，需要线程安全的synchronizedList修饰")
    @Test
    void SynchronizedList(){
        // 创建一个List数组
        List<String> lists = new ArrayList<String>();
        // 添加元素
        lists.add("1");
        lists.add("2");
        lists.add("3");
        // 创建一个synchronizedList
        List<String> synlist = Collections.synchronizedList(lists);
        // 迭代集合元素
        synchronized (lists) {
            //获取迭代器
            Iterator<String> iterator = synlist.iterator();
            //遍历
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

    }
}
