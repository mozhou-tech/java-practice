package com.java.practice.patterns.behavioral;

import org.junit.jupiter.api.Test;

import javax.naming.Context;
import java.util.List;

/**
 * 解释器模式
 * 解释器模式（Interpreter Pattern）提供了评估语言的语法或表达式的方式，它属于行为型模式。这种模式实现了一个表达式接口，该接口解释一个特定的上下文。
 * 这种模式被用在 SQL 解析、符号处理引擎等。
 * <p>
 * 关键代码：构建环境类，包含解释器之外的一些全局信息，一般是 HashMap。
 * 应用实例：编译器、运算表达式计算。
 * <p>
 * 优点： 1、可扩展性比较好，灵活。 2、增加了新的解释表达式的方式。 3、易于实现简单文法。
 * 缺点： 1、可利用场景比较少。 2、对于复杂的文法比较难维护。 3、解释器模式会引起类膨胀。 4、解释器模式采用递归调用方法。
 *
 * 当我们可以为已有的语法创建语法树时，可以使用解释器模式。
 * 解释器设计模式需要进行大量的错误检查，并需要大量的表达式和代码来对其进行评估。当语法变得更加复杂，因此难以维护和提供效率时，它将变得复杂。
 * java.util.Pattern和的子类java.text.Format是JDK中使用的解释器模式的一些示例。
 */
class InterpreterPatternTests {

    /**
     * 编写解释器上下文类，该类将进行实际的解释。
     */
    static class InterpreterContext {

        String getBinaryFormat(int i) {
            return Integer.toBinaryString(i);
        }

        String getHexadecimalFormat(int i) {
            return Integer.toHexString(i);
        }
    }

    /**
     * 创建不同类型的表达式，这些表达式将使用解释器上下文类
     */
    interface Expression {
        String interpret(InterpreterContext ic);
    }

    /**
     * 我们将有两种表达式实现，一种将int转换为二进制，另一种将int转换为十六进制格式
     */
    static class IntToBinaryExpression implements Expression {

        private int i;

        IntToBinaryExpression(int c) {
            this.i = c;
        }

        @Override
        public String interpret(InterpreterContext ic) {
            return ic.getBinaryFormat(this.i);
        }

    }

    /**
     * 我们将有两种表达式实现，一种将int转换为二进制，另一种将int转换为十六进制格式
     */
    static class IntToHexExpression implements Expression {

        private int i;

        IntToHexExpression(int c) {
            this.i = c;
        }

        @Override
        public String interpret(InterpreterContext ic) {
            return ic.getHexadecimalFormat(i);
        }

    }

    /**
     * 客户端
     */
    static class InterpreterClient {

        InterpreterContext ic;

        InterpreterClient(InterpreterContext i) {
            this.ic = i;
        }

        String interpret(String str) {
            Expression exp = null;
            //create rules for expressions
            if (str.contains("Hexadecimal")) {
                exp = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
            } else if (str.contains("Binary")) {
                exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
            } else return str;

            return exp.interpret(ic);
        }
    }

    @Test
    void test() {
        String str1 = "28 in Binary";
        String str2 = "28 in Hexadecimal";
        InterpreterClient ec = new InterpreterClient(new InterpreterContext());
        System.out.println(str1 + "= " + ec.interpret(str1));
        System.out.println(str2 + "= " + ec.interpret(str2));
    }
}
