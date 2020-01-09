package com.java.practice.patterns.behavioral;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * 中介者模式（Mediator Pattern）是用来降低多个对象和类之间的通信复杂性。
 * 这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。中介者模式属于行为型模式。
 * <p>
 * 优点： 1、降低了类的复杂度，将一对多转化成了一对一。 2、各个类之间的解耦。 3、符合迪米特原则。
 * 缺点：中介者会庞大，变得复杂难以维护。
 * <p>
 * 使用场景：
 * 1、系统中对象之间存在比较复杂的引用关系，导致它们之间的依赖关系结构混乱而且难以复用该对象。
 * 2、想通过一个中间类来封装多个类中的行为，而又不想生成太多的子类。
 */
class MediatorPatternTests {

    @AllArgsConstructor
    static class User {

        @Getter
        @Setter
        private String name;

        public void sendMessage(String message) {
            ChatRoom.showMessage(this, message);
        }
    }

    /**
     * 中介类
     */
    static class ChatRoom {
        static void showMessage(User user, String message) {
            System.out.println(new Date().toString()
                    + " [" + user.getName() + "] : " + message);
        }
    }

    @Test
    @DisplayName("中介者")
    void test() {
        User robert = new User("Robert");
        User john = new User("John");
        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
