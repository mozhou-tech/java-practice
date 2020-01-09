package com.java.practice.lang.collections.outdated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 这种传统接口已被迭代器取代，已很少被使用
 */
public class EnumerationTests {

    @Test
    @DisplayName("元素操作")
    void test() {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        //  测试此枚举是否包含更多的元素。
        while (days.hasMoreElements()) {
        //  如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。
            System.out.println(days.nextElement());
        }
    }
}
