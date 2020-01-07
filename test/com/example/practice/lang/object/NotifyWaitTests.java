package com.example.practice.lang.object;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * https://www.baeldung.com/java-wait-notify
 * <p>
 * wait()方法可以使线程进入等待状态，而notify()可以使等待的状态唤醒。这样的同步机制十分适合生产者、消费者模式：消费者消费某个资源，而生产者生产该资源。
 * 当该资源缺失时，消费者调用wait()方法进行自我阻塞，等待生产者的生产；生产者生产完毕后调用notify/notifyAll()唤醒消费者进行消费。
 */
class NotifyWaitTests {

    /**
     * 对象锁
     * 由于一个class不论被实例化多少次，其中的静态方法和静态变量在内存中都只有一份。所以，一旦一个静态的方法被申明为synchronized。
     * 此类所有的实例化对象在调用此方法，共用同一把锁，我们称之为类锁。
     * 对象锁是用来控制实例方法之间的同步，类锁是用来控制静态方法（或静态变量互斥体）之间的同步,
     */
    private static final Object obj = new Object();

    /**
     * 其中flag标志表示资源的有无。
     */
    //消费者线程
    private static class Consume implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("->进入消费者线程");
                try {
                    System.out.println("还没生产，进入wait");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费，收到生产者notify");
                System.out.println("->退出消费者线程");
            }
        }
    }

    // 生产者线程
    private static class Produce implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("->进入生产者线程");
                System.out.println("生产");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);  //模拟生产过程
                    obj.notify();  //通知消费者
                    TimeUnit.MILLISECONDS.sleep(1000);  //模拟其他耗时操作
                    System.out.println("->退出生产者线程");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    @DisplayName("NotifyAll")
    void NotifyAll() throws InterruptedException {
        Thread consume = new Thread(new Consume(), "Consume");
        Thread produce = new Thread(new Produce(), "Produce");
        consume.start();
        Thread.sleep(1000);
        produce.start();
        try {
            produce.join();
            consume.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
