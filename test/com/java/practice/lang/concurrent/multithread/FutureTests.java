package com.java.practice.lang.concurrent.multithread;

import org.junit.jupiter.api.Assertions;
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
class FutureTests {

    /**
     * 定义一个Callable实现类
     */
    static class CallableImpl implements Callable<Integer> {

        @Override
        public Integer call() throws InterruptedException {
            Thread.sleep(5000);
            return 1;
        }

    }

    // 准备线程池, ExecutorService是一个线程池管理工具
    private static ExecutorService threadPool = Executors.newFixedThreadPool(3);

    private ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();

    @Test
    @DisplayName("直接打印")
    void syncPrintString() throws InterruptedException {
        // execute Runnable
        threadPool.execute(() -> {
            System.out.println("Hello World!");
        });
        threadPool.shutdown();
        System.out.println(threadPool.isTerminated());
        // awaitTermination方法：接收人timeout和TimeUnit两个参数，用于设定超时时间及单位。当等待超过设定时间时，
        // 会监测ExecutorService是否已经关闭，若关闭则返回true，否则返回false。一般情况下会和shutdown方法组合使用。
        while (!threadPool.awaitTermination(1,TimeUnit.SECONDS));
        System.out.println(threadPool.isTerminated());
    }

    @Test
    @DisplayName(value = "调用futureRunnable，非阻塞等待执行完成")
    void runnableFutureThreadPool() throws ExecutionException, InterruptedException {
        // submit Callable 到线程池异步执行
        Future<?> future = threadPool.submit(new CallableImpl());
        // 等待执行完成，不阻塞
        while (true) {
            // 表示任务是否已经完成，若任务完成，则返回true
            if (future.isDone()) {
                System.out.println(future.get());
                Assertions.assertEquals(1,future.get());
                break;
            }
            Thread.sleep(1);
        }
        // 表示任务是否被取消成功，如果在任务正常完成前被取消成功，则返回 true
        future.isCancelled();
        System.out.println("isCancelled: "+future.isCancelled());
        // 关闭线程池
        threadPool.shutdown();
        // 等待线程池关闭
        while (!threadPool.awaitTermination(1,TimeUnit.SECONDS)){
            System.out.println("等待线程池关闭");
        }
        System.out.println("isShutdown: "+threadPool.isShutdown());
        System.out.println("isTerminated: "+threadPool.isTerminated());
    }

    @Test
    @DisplayName("test")
    void submitCallableReturn() throws ExecutionException, InterruptedException {
        // Lambda 函数提交到线程池异步执行
        Future future3 = threadPool.submit(() -> {
            return 1;
        });
        // 方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回；
        // 带参数可限制等待时间
        System.out.println(future3.get());
    }

}
