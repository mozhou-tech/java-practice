package com.example.practice.lang.object;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotifyWaitTests {

    private final Object lock = new Object();

    {
        synchronized (lock){
            try {
                lock.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("NotifyAll")
    synchronized void  NotifyAll() throws InterruptedException {
        synchronized (lock) {
            Thread thread = new Thread(() -> {
                System.out.println("thread starting...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 对象解锁
                lock.notifyAll();
            });
            thread.setDaemon(true);
            thread.start();
        }
    }
}
