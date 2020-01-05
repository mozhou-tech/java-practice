package com.example.project.concurrent;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * 集Runnable、Callable、Future于一身，它首先实现了Runnable与Future接口，然后在构造函数中还要注入Callable对象（或者变形的Callable对象：Runnable + Result），
 * 所以FutureTask类既可以使用new Thread(Runnable r)放到一个新线程中跑，也可以使用ExecutorService.submit(Runnable r)放到线程池中跑，
 * 而且两种方式都可以获取返回结果，但实质是一样的.
 * <p>
 * 常见的两种创建线程的方式。一种是直接继承Thread，另外一种就是实现Runnable接口。这两种方式都有一个缺陷就是：在执行完任务之后无法获取执行结果。
 */
public class FutureTests {

    /**
     * 定义一个Callable实现类
     */
    static class CallableImpl implements Callable<Integer> {

        @Override
        public Integer call() throws InterruptedException {
            System.out.println("test");
            Thread.sleep(1000);
            return 1;
        }

    }

    // 准备线程池, ExecutorService是一个线程池管理工具
    private static ExecutorService threadPool = Executors.newFixedThreadPool(3);

    private ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();

    /**
     * 定义FutureTask
     * <p>
     * FunctionalInterface
     */
    private FutureTask<Integer> input2_futuretask = new FutureTask<>(new CallableImpl());

    @Test
    @DisplayName("直接打印")
    void print() {
        threadPool.execute(() -> {
            System.out.println("Hello World!");
        });
    }

    @Test
    @DisplayName(value = "调用futureRunnable")
    void runnableFutureThreadPool() throws ExecutionException, InterruptedException {
        Future future = threadPool.submit(input2_futuretask);
        while (true) {
            if (future.isDone()) {
                System.out.println(future.get());
                break;
            }
            Thread.sleep(1);
        }
    }

    void shutdown() {
        threadPool.shutdown();
    }
}
