package com.java.practice.algorithm.datastructures.queue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。
 * <p>
 * 要使用PriorityQueue，我们就必须给每个元素定义“优先级”
 */
class PriorityQueueTests {

    /**
     * 比较器
     */
    static class UserComparator implements Comparator<User> {
        public int compare(User u1, User u2) {
            if (u1.number.charAt(0) == u2.number.charAt(0)) {
                // 如果两人的号都是A开头或者都是V开头,比较号的大小:
                return u1.number.compareTo(u2.number);
            }
            if (u1.number.charAt(0) == 'V') {
                // u1的号码是V开头,优先级高:
                return -1;
            } else {
                return 1;
            }
        }
    }

    static class User {
        public final String name;
        public final String number;

        User(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public String toString() {
            return name + "/" + number;
        }
    }

    @Test
    void test() {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}
