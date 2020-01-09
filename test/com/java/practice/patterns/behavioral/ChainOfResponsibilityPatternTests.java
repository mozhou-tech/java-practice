package com.java.practice.patterns.behavioral;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Handler;

/**
 * 顾名思义，责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。
 * 这种模式给予请求的类型，对请求的发送者和接收者进行解耦。这种类型的设计模式属于行为型模式。
 * <p>
 * 职责链可以是一条直线、一个环或者一个树形结构，最常见的职责链是直线型，即沿着一条单向的链来传递请求。
 * 链上的每一个对象都是请求处理者，职责链模式可以将请求的处理者组织成一条链，并让请求沿着链传递，由链上的处理者对请求进行相应的处理，
 * 客户端无须关心请求的处理细节以及请求的传递，只需将请求发送到链上即可，实现请求发送者和请求处理者解耦。
 * <p>
 * https://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html
 */
class ChainOfResponsibilityPatternTests {

    /**
     * 常量  默认final
     * 需要保持一个递+的关系
     */
    interface Type {
        int UI_DESIGN = 2;
        int CODE_DEVELOP = 3;
        int CODE_TEST = 4;
        int APP_PUBLISH = 5;
        int REQUIREMENTS = 1;
    }

    //Handler（抽象处理者）
    abstract static class Handler {

        protected int type = 0;

        private Handler nextHandler;

        Handler getNextHandler() {
            return nextHandler;
        }

        void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        /**
         * 抽象方法，必须被重写
         *
         * @param type
         * @param user
         * @return
         */
        abstract String handleRequest(int type, String user);
    }

    /**
     * 启动方法
     */
    static class TaskBoard {
        Handler uiDesignHandler = new UIDesignHandler(Type.UI_DESIGN);
        Handler codeDevelopHandler = new CodeDevelopHandler(Type.CODE_DEVELOP);
        Handler codeTestHandler = new CodeTestHandler(Type.CODE_TEST);
        Handler requirementsHandler = new RequirementsHandler(Type.REQUIREMENTS);
        Handler appPublishHandler = new AppPublishHandler(Type.APP_PUBLISH);

        /**
         * 初始化
         */
        TaskBoard() {
            requirementsHandler.setNextHandler(uiDesignHandler);
            uiDesignHandler.setNextHandler(codeDevelopHandler);
            codeDevelopHandler.setNextHandler(codeTestHandler);
            codeTestHandler.setNextHandler(appPublishHandler);
        }

        /**
         * 启动一个任务
         *
         * @param type
         * @param user
         */
        void sendTask(int type, String user) {
            System.out.println(String.format("----> User %s init a task", user));
            this.requirementsHandler.handleRequest(type, user);
        }
    }

    static class CodeDevelopHandler extends Handler {

        CodeDevelopHandler(int type) {
            this.type = type;
        }
        @Override
        String handleRequest(int type, String user) {
            String ret = "";
            if (this.type >= type) {
                System.out.println("*********** CodeDevelopHandler **************");
            }
            if (getNextHandler() != null) {
                ret = getNextHandler().handleRequest(type, user);
            } else {
                System.out.println("chain exited.");
            }
            return ret;
        }
    }

    static class UIDesignHandler extends Handler {

        UIDesignHandler(int type) {
            this.type = type;
        }

        @Override
        String handleRequest(int type, String user) {
            String ret = "";
            if (this.type >= type) {
                System.out.println("*********** UIDesignHandler **************");
            }
            if (getNextHandler() != null) {

                ret = getNextHandler().handleRequest(type, user);
            } else {
                System.out.println("chain exited.");
            }
            return ret;
        }
    }

    static class RequirementsHandler extends Handler {
        RequirementsHandler(int type) {
            this.type = type;
        }

        @Override
        String handleRequest(int type, String user) {
            if (this.type >= type) {
                System.out.println("*********** RequirementsHandler **************");
            }
            String ret = "";
            if (getNextHandler() != null) {

                ret = getNextHandler().handleRequest(type, user);
            } else {
                System.out.println("chain exited.");
            }
            return ret;
        }
    }

    static class CodeTestHandler extends Handler {
        CodeTestHandler(int type) {
            this.type = type;
        }

        @Override
        String handleRequest(int type, String user) {
            String ret = "";
            if (this.type >= type) {
                System.out.println("*********** CodeTestHandler **************");
            }
            if (getNextHandler() != null) {

                ret = getNextHandler().handleRequest(type, user);
            } else {
                System.out.println("chain exited.");
            }
            return ret;
        }
    }

    static class AppPublishHandler extends Handler {

        AppPublishHandler(int type) {
            this.type = type;
        }

        @Override
        String handleRequest(int type, String user) {
            String ret = "";
            if (this.type >= type) {
                System.out.println("*********** AppPublishHandler **************");
            }
            if (getNextHandler() != null) {
                ret = getNextHandler().handleRequest(type, user);
            } else {
                System.out.println("chain exited.");
            }
            return ret;
        }
    }

    //客户端
    @DisplayName("责任链模式")
    @Test
    void run() {
        TaskBoard taskBoard = new TaskBoard();
        taskBoard.sendTask(Type.REQUIREMENTS, "Yates");
    }
}
