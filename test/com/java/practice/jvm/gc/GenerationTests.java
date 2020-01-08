package com.java.practice.jvm.gc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 虚拟机中的共划分为三个代：年轻代（Young Generation）、老年代（Old Generation）和持久代（Permanent Generation）。
 * 其中持久代主要存放的是Java类的类信息，与垃圾收集要收集的Java对象关系不大。
 * 年轻代和年老代的划分是对垃圾收集影响比较大的。
 *
 * 分代收集算法
 *
 * https://zhuanlan.zhihu.com/p/33783873
 */
class GenerationTests {

    /**
     * 新生代的目标就是尽可能快速的收集掉那些生命周期短的对象，一般情况下，所有新生成的对象首先都是放在新生代的。
     * 新生代内存按照 8:1:1 的比例分为一个eden区和两个survivor(survivor0，survivor1)区，大部分对象在Eden区中生成。
     * 在进行垃圾回收时，先将eden区存活对象复制到survivor0区，然后清空eden区，当这个survivor0区也满了时，
     * 则将eden区和survivor0区存活对象复制到survivor1区，然后清空eden和这个survivor0区，此时survivor0区是空的，
     * 然后交换survivor0区和survivor1区的角色（即下次垃圾回收时会扫描Eden区和survivor1区），
     * 即保持survivor0区为空，如此往复。特别地，当survivor1区也不足以存放eden区和survivor0区的存活对象时，
     * 就将存活对象直接存放到老年代。如果老年代也满了，就会触发一次FullGC，也就是新生代、老年代都进行回收。
     * 注意，新生代发生的GC也叫做MinorGC，MinorGC发生频率比较高，不一定等 Eden区满了才触发。
     *
     * 经常被分为 Eden 和 Survivor
     *
     * Minor GC 会清理年轻代的内存
     */
    @Test
    @DisplayName("新生代")
    void young(){
        // 运行垃圾收集，触发FullGC
        System.gc();
    }

    /**
     * 老年代存放的都是一些生命周期较长的对象，就像上面所叙述的那样，在新生代中经历了N次垃圾回收后仍然存活的对象就会被放到老年代中。
     * 此外，老年代的内存也比新生代大很多(大概比例是1:2)，当老年代满时会触发Major GC(Full GC)，老年代对象存活时间比较长，因此FullGC发生的频率比较低。
     *
     * Major GC 是清理老年代
     */
    @Test
    @DisplayName("老年代")
    void old(){

    }

    /**
     * 永久代主要用于存放静态文件，如Java类、方法等。永久代对垃圾回收没有显著影响，
     * 但是有些应用可能动态生成或者调用一些class，例如使用反射、动态代理、CGLib等bytecode框架时，
     * 在这种时候需要设置一个比较大的永久代空间来存放这些运行过程中新增的类。
     */
    @Test
    @DisplayName("永久代")
    void permanent(){

    }



}
