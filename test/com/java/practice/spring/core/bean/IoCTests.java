package com.java.practice.spring.core.bean;

/**
 * bean是对象，一个或者多个不限定
 * bean由Spring中一个叫IoC的东西管理
 * 我们的应用程序由一个个bean构成
 *
 * 让Spring控制对象的创建过程
 */
public class IoCTests {

    static class Computer {

        private String cpu;     // CPU型号
        private int ram;        // RAM大小，单位GB

        public Computer(String cpu, int ram) {
            this.cpu = cpu;
            this.ram = ram;
        }
    }

    static class Person {

        private Computer computer;

        public Person(Computer computer) {
            this.computer = computer;
        }
    }
}
