package com.example.practice.lang.object;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotifyWaitTests {

    private final Object lock = new Object();

    {
        synchronized (lock){
            Thread thread = new Thread(()->{
                try {
                    lock.wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            Thread thread1 = new Thread(() -> {
                System.out.println("thread starting...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 对象解锁
                lock.notifyAll();
            });
            thread1.start();
        }
    }

    @Test
    @DisplayName("NotifyAll")
    void  NotifyAll() throws InterruptedException {

    }
}
