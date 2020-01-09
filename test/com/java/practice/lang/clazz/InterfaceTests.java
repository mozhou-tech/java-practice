package com.java.practice.lang.clazz;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

/**
 * 接口不能包含成员变量，除了 static 和 final 变量。
 * 接口不是被类继承了，而是要被类实现。
 * 接口支持多继承。
 * 接口没有构造方法。
 * 接口中所有的方法必须是抽象方法。
 *
 * 接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 public abstract（只能是 public abstract，其他修饰符都会报错）。
 * 接口中可以含有变量，但是接口中的变量会被隐式的指定为 public static final 变量（并且只能是 public，用 private 修饰会报编译错误）。
 * 接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法。
 */
class InterfaceTests {

    /**
     * 基础接口
     */
    interface People {

        int getAge();

        void setAge(int age);

        String getName();

        void setName(String name);
    }

    /**
     * 接口继承
     */
    interface Occupation extends People {

        void setCompany(String company);

        String getCompany();
    }

    interface Family {
        void setNum(int num);
        int getNum();
    }

    /**
     * 类可以继承多个接口
     */
    private static class One implements Occupation, Family {
        int age = 0;
        String name = "";
        int num = 1;
        String company = "";

        @Override
        public int getAge() {
            return age;
        }

        @Override
        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void setCompany(String company) {
            this.company = company;
        }

        @Override
        public String getCompany() {
            return this.company;
        }

        @Override
        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public int getNum() {
            return num;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

    @Test
    void test() {
        One one = new One();
        one.setCompany("Google Inc.");
        one.setNum(3);
        one.setAge(30);
        one.setName("Yates");
        System.out.println(one);
    }
}
