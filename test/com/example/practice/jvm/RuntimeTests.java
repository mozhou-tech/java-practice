package com.example.practice.jvm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
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
        process.waitFor();
        SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(sis, StandardCharsets.UTF_8));
        String line;
        StringBuilder s = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            s.append(line).append("\n");
        }
        System.out.println(String.format("命令执行结果\n%s", s.toString()));
    }

}
