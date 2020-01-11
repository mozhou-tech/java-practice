package com.java.practice.framework.spring.beans;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

/**
 * bean是对象，一个或者多个不限定
 * bean由Spring中一个叫IoC的东西管理
 * 我们的应用程序由一个个bean构成
 * bean是一个Java对象，根据bean规范编写出来的类，并由bean容器生成的对象就是一个bean。
 * <p>
 * 所有的类都会在spring容器中登记，告诉spring你是个什么东西，你需要什么东西，然后spring会在系统运行到适当的时候，把你要的东西主动给你，
 * 同时也把你交给其他需要你的东西。所有的类的创建、销毁都由 spring来控制，也就是说控制对象生存周期的不再是引用它的对象，而是spring。对于某个具体的对象而言，
 * 以前是它控制其他对象，现在是所有对象都被spring控制，所以这叫控制反转。
 * <p>
 * 让Spring控制对象的创建过程
 * https://www.awaimai.com/2596.html
 */
class IoCTests {

    /**
     * 符合控制IoC的实例
     */
    static class Computer implements Serializable {
        @Getter
        @Setter
        private String cpu;     // CPU型号
        @Setter
        @Getter
        private int ram;        // RAM大小，单位GB

        Computer(String cpu, int ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

    }

    static class Person {
        @Getter
        @Setter
        private Computer computer;

        /**
         * 通过构造函数传入依赖，不直接在构造方法内实例化
         *
         * @param computer
         */
         Person(Computer computer) {
            this.computer = computer;
        }
    }

    @Test
    void test() {
        Person person = new Person(new Computer("intel", 4));
        System.out.println(person.getComputer().getCpu());
    }
}
