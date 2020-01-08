package com.java.practice.jvm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

class RuntimeTests {

    @Test
    @DisplayName("打印JVM版本")
    void version() {
        System.out.println(Runtime.version());
    }

    @Test
    @DisplayName("执行JVM之外的程序：常见的几种陷阱")
    void exec() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("java -version");
        System.out.println(String.format("进程是否存活 %s", process.isAlive()));
        process.waitFor(1, TimeUnit.SECONDS);
        System.out.println(String.format("进程是否存活 %s", process.isAlive()));
        System.out.println(String.format("进程退出值 %s", process.exitValue()));
        System.out.println(String.format("进程PID %s", process.pid()));
        // 合并流
        SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(sis, StandardCharsets.UTF_8));
        String line;
        StringBuilder s = new StringBuilder();
        // 读取流
        while ((line = reader.readLine()) != null) {
            s.append(line).append("\n");
        }
        System.out.println(String.format("命令执行结果\n%s", s.toString()));
    }

    /**
     * -Xmx   Java Heap最大值，默认值为物理内存的1/4，最佳设值应该视物理内存大小及计算机内其他内存开销而定；
     * -Xms   Java Heap初始值，Server端JVM最好将-Xms和-Xmx设为相同值，开发测试机JVM可以保留默认值；
     * -Xmn   Java Heap Young区大小，不熟悉最好保留默认值；
     * -Xss   每个线程的Stack大小，不熟悉最好保留默认值；
     */
    @Test
    @DisplayName("获取JVM信息")
    void jvmInfo() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(String.format("JVM合计从操作系统获得的内存 %s MB", runtime.totalMemory()/1024/1024));
        System.out.println(String.format("JVM从操作系统获取的内存中剩余的内存 %s MB", runtime.freeMemory()/1024/1024));
        System.out.println(String.format("JVM能拿到的最大内存 %s MB", runtime.maxMemory()/1024/1024));
    }

}
