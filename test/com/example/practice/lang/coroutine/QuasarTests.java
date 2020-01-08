package com.example.practice.lang.coroutine;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.fibers.Suspendable;
import co.paralleluniverse.strands.SuspendableRunnable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 基于quasar的协程
 */
class QuasarTests {

    @Suspendable
    void SuspendableFunc(){
        System.out.println("test");
    }

    /**
     * quasar的方法与Thread类似
     */
    @Test
    @DisplayName("协程")
    void test() {
        new Fiber<Void>(()-> {
            System.out.println("test");
        }).start();
    }

    @Test
    @DisplayName("协程")
    void test1() {
        new Fiber<Void>(this::SuspendableFunc).start();
    }
}
