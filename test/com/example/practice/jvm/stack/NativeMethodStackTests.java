package com.example.practice.jvm.stack;

/**
 * 并非所有的 JVM 实现都支持本地（native）方法，那些提供支持的 JVM 一般都会为每个线程创建本地方法栈。
 * 如果 JVM 用 C-linkage 模型实现 JNI（Java Native Invocation），那么本地栈就是一个 C 的栈。
 * 在这种情况下，本地方法栈的参数顺序、返回值和典型的 C 程序相同。本地方法一般来说可以（依赖 JVM 的实现）反过来调用 JVM 中的 Java 方法。
 * 这种 native 方法调用 Java 会发生在栈（一般是 Java 栈）上；线程将离开本地方法栈，并在 Java 栈上开辟一个新的栈帧。
 */
public class NativeMethodStackTests {
}
