package com.example.project.datastruc.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 哈希算法也称为散列算法，是将数据依特定算法直接指定到一个地址上。这样一来，当集合要添加新的元素时，先调用这个元素的HashCode方法，就一下子能定位到它应该放置的物理位置上。
 * HashCode是用于查找使用的，而equals是用于比较两个对象是否相等的。
 *
 * （1）HashCode的存在主要是用于查找的快捷性，如Hashtable，HashMap等，HashCode经常用于确定对象的存储地址；
 * （2）如果两个对象相同， equals方法一定返回true，并且这两个对象的HashCode一定相同；
 * （3）两个对象的HashCode相同，并不一定表示两个对象就相同，即equals()不一定为true，只能说明这两个对象在一个散列存储结构中。
 * （4）如果对象的equals方法被重写，那么对象的HashCode也尽量重写。
 */
public class HashCodeTests {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Test
    @DisplayName("test")
    void test(){
        System.out.println(hashCode());
    }
}
