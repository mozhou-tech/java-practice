package com.java.practice.patterns.behavioral;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    //常量
    interface Type {
        int UI_EFFECT = 0;
        int CODE_FORMAT = 1;
        int TEST_PROJECT = 2;
        int PUBLISH_APP = 3;
    }

    //Handler（抽象处理者）
    abstract static class Handler {
        private Handler mHandler;

        Handler getmHandler() {
            return mHandler;
        }

        void setmHandler(Handler mHandler) {
            this.mHandler = mHandler;
        }

        abstract String handleRequest(int type, String user);
    }

    //ConcreteHandler（具体处理者）
    static class ConcreteHandlerGUI extends Handler {
        @Override
        String handleRequest(int type, String user) {
            String ret = "";
            if (Type.UI_EFFECT == type) {
                ret = user + "’s App UI is Ok!";
            } else {
                if (getmHandler() != null) {
                    System.out.println("*********** ConcreteHandlerGUI **************");
                    ret = getmHandler().handleRequest(type, user);
                }
            }
            return ret;
        }
    }

    static class ConcreteHandlerTeamLeader extends Handler {
        @Override
        String handleRequest(int type, String user) {
            String ret = "";
            if (Type.CODE_FORMAT == type) {
                ret = user + "’s App code format is Ok!";
            } else {
                if (getmHandler() != null) {
                    System.out.println("*********** ConcreteHandlerTeamLeader **************");
                    ret = getmHandler().handleRequest(type, user);
                }
            }
            return ret;
        }
    }

    static class ConcreteHandlerPM extends Handler {
        @Override
        String handleRequest(int type, String user) {
            String ret = "";
            if (Type.PUBLISH_APP == type) {
                ret = user + "’s App can be publish!";
            } else {
                if (getmHandler() != null) {
                    System.out.println("*********** ConcreteHandlerPM **************");
                    ret = getmHandler().handleRequest(type, user);
                }
            }
            return ret;
        }
    }

    static class ConcreteHandlerTestEngineer extends Handler {
        @Override
        String handleRequest(int type, String user) {
            String ret = "";
            if (Type.TEST_PROJECT == type) {
                ret = user + "’s App test is Ok!";
            } else {
                if (getmHandler() != null) {
                    System.out.println("*********** ConcreteHandlerTestEngineer **************");
                    ret = getmHandler().handleRequest(type, user);
                }
            }
            return ret;
        }
    }

    //客户端
    @DisplayName("责任链模式")
    @Test
    void run() {
        Handler code = new ConcreteHandlerTeamLeader();
        Handler ui = new ConcreteHandlerGUI();
        Handler test = new ConcreteHandlerTestEngineer();
        Handler publish = new ConcreteHandlerPM();

        code.setmHandler(ui);
        ui.setmHandler(test);
        test.setmHandler(publish);
        //yanbo找team leader review代码
        System.out.println(code.handleRequest(Type.CODE_FORMAT, "YanBo"));
        //yanbo找team leader测试代码
        System.out.println(code.handleRequest(Type.TEST_PROJECT, "YanBo"));
    }
}
