package com.java.practice.spring.core.beans;

/**
 * 依赖注入(Dependency Injection)：这就是DI，字面上理解，依赖注入就是将服务注入到使用它的地方。对象只提供普通的方法让容器去决定依赖关系，
 * 容器全权负责组件的装配，它会把符合依赖关系的对象通过属性（JavaBean中的setter）或者是构造子传递给需要的对象。
 * 相对于IoC而言，依赖注入(DI)更加准确地描述了IoC的设计理念。所谓依赖注入，即组件之间的依赖关系由容器在应用系统运行期来决定，
 * 也就是由容器动态地将某种依赖关系的目标对象实例注入到应用系统中的各个关联的组件之中。
 *
 * 那么DI是如何实现的呢？ Java 1.3之后一个重要特征是反射（reflection），它允许程序在运行的时候动态的生成对象、执行对象的方法、改变对象的属性，spring就是通过反射来实现注入的。
 */
public class DependencyInjectionTests {
}
