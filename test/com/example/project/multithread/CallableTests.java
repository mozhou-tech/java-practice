package com.example.project.multithread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * call有返回值, run返回void
 * call方法可以抛出异常，run方法不可以
 * 运行Callable任务可以拿到一个Future对象，表示异步计算的结果。
 */
class CallableTests {

    /**
     * 定义一个Callable实现类
     */
    static class CallableImpl implements Callable<Integer> {
        @Override
        public Integer call() throws InterruptedException {
            Thread.sleep(1000);
            return 1;
        }
    }

    @Test
    @DisplayName(value = "callable 返回值")
    void call() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        CallableImpl callable = new CallableImpl();
        // 获得进程返回结果
        Integer result = callable.call();
        Assertions.assertEquals(result,1);
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        Assertions.assertTrue((endTime - startTime) > 1000);
    }

}
