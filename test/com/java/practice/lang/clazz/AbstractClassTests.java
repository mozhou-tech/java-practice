package com.java.practice.lang.clazz;

import lombok.*;
import org.junit.jupiter.api.Test;

/**
 * 抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。
 * 由于抽象类不能实例化对象，所以抽象类必须被继承，才能被使用。也是因为这个原因，通常在设计阶段决定要不要设计抽象类。
 * <p>
 * 抽象类
 */
class AbstractClassTests {

    @AllArgsConstructor
    @NoArgsConstructor
    abstract static class Employee {

        @Getter
        @Setter
        private String name;

        @Getter
        @Setter
        private String address;

        @Getter
        @Setter
        private int number;
    }
    @NoArgsConstructor
    private static class Salary extends Employee {

        @Setter
        @Getter
        private double salary; //Annual salary

        Salary(String name,String address,int number,double salary){
            super(name, address, number);
        }
    }

    @Test
    void instantClass() {
        // 抽象对象无法被实例化
//        Employee e = new Employee("George W.", "Houston, TX", 43);
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
    }
}
