package com.java.practice.clazz;

/**
 * 泛型演示类
 *
 * @author jerrylau
 */
public class Generic<T,K> {

    private T t;

    private K k;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }
}
