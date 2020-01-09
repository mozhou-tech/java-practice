package com.java.practice.patterns.behavioral;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-serialNo/index.html
 *
 * 在软件系统中，行为请求者与行为实现者之间通常呈现一种紧耦合的关系。但在某些场合，比如要对行为进行记录撤销重做事务等处理，
 * 这种无法抵御变化的紧耦合是不合适的。这种情况下，使用 command 模式将行为请求者与行为实现者进行解耦。
 *
 * 命令模式使新的命令很容易被加入到系统里。
 * 允许接受请求的一方决定是否要否决请求。
 * 能较容易的设计一个命令队列。
 * 可以容易的实现对请求的撤销和恢复。
 * 在需要的情况下，可以较容易的将命令记入日志。
 *
 * 客户端角色(Client)：创建一个具体命令ConcreteCommand对象并确定其接收者。
 * 命令角色(Command)： 声明一个给所有具体命令类的抽象接口。
 * 具体命令角色(ConcreteCommand)：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。execute()方法通常叫做执行方法。
 * 请求者角色(Invoker)：负责调用命令对象执行请求，相关的方法叫做行动方法。
 * 接收者角色(Receiver)：负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。
 */
class CommandPatternTests {

    /**
     * 负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法为行动方法。
     */
    public static class Receiver {
        {
            System.out.println("---->初始化命令接收&操作者");
        }
        /**
         * 真正执行命令相应的操作
         */
        void action() {
            System.out.println("！最终要执行的操作");
        }
    }

    /**
     * 定义一个给所有命令类的抽象接口，定义了统一的 execute() 接口方法。
     */
    public interface Command {
        /**
         * 执行方法
         */
        void execute();
    }

    /**
     * 定义一个接受者和行为之间的弱耦合；实现 Command 接口，并实现 execute() 方法，负责调用接收者的相应操作。
     */
    public static class ConcreteCommand implements Command {
        /**
         * 持有相应的接收者对象
         */
        private Receiver receiver = null;

        /**
         * 构造方法
         *
         * @param receiver
         */
        ConcreteCommand(Receiver receiver) {
            {
                System.out.println("---->初始化持有接受者的命令");
            }
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            //通常会转调接收者的形影方法，让接收者来真正执行功能
            receiver.action();
        }
    }

    /**
     * 负责调用由 Client 下达的对象执行请求。
     */
    public static class Invoker {
        /**
         * 持有命令对象
         */
        private Command command = null;

        /**
         * 构造方法
         *
         * @param command
         */
        Invoker(Command command) {
            {
                System.out.println("---->初始化持有命令的调用者，命令需要实现execute方法");
            }
            this.command = command;
        }

        /**
         * 行动方法
         */
        void action() {
            command.execute();
        }
    }

    /**
     * 创建一个具体命令（ConcreteCommand）对象，并设置命令的接收者。
     */
    @Test
    @DisplayName("调用命令的客户端")
    void client() {
        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令对象，设定其接收者
        Command concreteCommand = new ConcreteCommand(receiver);
        //创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(concreteCommand);
        //执行方法
        invoker.action();
    }
}
