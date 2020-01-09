package com.java.practice.patterns.behavioral;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 模板方法模式
 * <p>
 * https://blog.csdn.net/lmj623565791/article/details/26276093
 */
class TemplatePatternTests {
    abstract static class Game {
        abstract void initialize();

        abstract void startPlay();

        abstract void endPlay();

        //模板
        final void play() {
            //初始化游戏
            initialize();
            //开始游戏
            startPlay();
            //结束游戏
            endPlay();
        }
    }

    /**
     * 板球
     */
    static class Cricket extends Game {

        @Override
        void endPlay() {
            System.out.println("Cricket Game Finished!");
        }

        @Override
        void initialize() {
            System.out.println("Cricket Game Initialized! Start playing.");
        }

        @Override
        void startPlay() {
            System.out.println("Cricket Game Started. Enjoy the game!");
        }
    }

    /**
     * 足球
     */
    static class Football extends Game {

        @Override
        void endPlay() {
            System.out.println("Football Game Finished!");
        }

        @Override
        void initialize() {
            System.out.println("Football Game Initialized! Start playing.");
        }

        @Override
        void startPlay() {
            System.out.println("Football Game Started. Enjoy the game!");
        }
    }

    @Test
    void test() {
        Game game = new Cricket();
        game.play();
        System.out.println("--------分隔");
        game = new Football();
        game.play();
    }
}
