package com.example.practice.lang.coroutine;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 基于quasar的协程
 */
class QuasarTests {

    @Test
    @DisplayName("协程")
    void test() {
        new Fiber<Void>(()-> {
            System.out.println("test");
        }).start();
    }
}
