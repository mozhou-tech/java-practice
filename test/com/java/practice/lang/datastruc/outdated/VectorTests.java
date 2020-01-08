package com.java.practice.lang.datastruc.outdated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Vector;

/**
 * 线程安全，类似ArrayList但有许多传统的方法
 */
public class VectorTests {
    @Test
    @DisplayName(value = "capacity")
    void capacity(){
        Vector vector = new Vector(2,3);
        vector.add(1);
        vector.add("b");
        System.out.println(vector.capacity());
    }
}
