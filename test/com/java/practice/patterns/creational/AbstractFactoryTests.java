package com.java.practice.patterns.creational;

import org.junit.jupiter.api.Test;

/**
 * 工厂模式
 * 意图：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * 主要解决：主要解决接口选择的问题。
 * 何时使用：系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。
 * 如何解决：在一个产品族里面，定义多个产品。
 * 关键代码：在一个工厂里聚合多个同类产品。
 * 应用实例：工作了，为了参加一些聚会，肯定有两套或多套衣服吧，比如说有商务装（成套，一系列具体产品）、时尚装（成套，一系列具体产品），甚至对于一个家庭来说，可能有商务女装、商务男装、时尚女装、时尚男装，这些也都是成套的，即一系列具体产品。假设一种情况（现实中是不存在的，要不然，没法进入共产主义了，但有利于说明抽象工厂模式），在您的家中，某一个衣柜（具体工厂）只能存放某一种这样的衣服（成套，一系列具体产品），每次拿这种成套的衣服时也自然要从这个衣柜中取出了。用 OOP 的思想去理解，所有的衣柜（具体工厂）都是衣柜类的（抽象工厂）某一个，而每一件成套的衣服又包括具体的上衣（某一具体产品），裤子（某一具体产品），这些具体的上衣其实也都是上衣（抽象产品），具体的裤子也都是裤子（另一个抽象产品）。
 * 优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
 * 缺点：产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。
 * 使用场景： 1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。
 * 注意事项：产品族难扩展，产品等级易扩展。
 * <p>
 * https://blog.csdn.net/lmj623565791/article/details/24460585
 */
class AbstractFactoryTests {
    interface Shape {
        void draw();
    }

    interface Color {
        void fill();
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }

    static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }

    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Circle::draw() method.");
        }
    }

    static class Green implements Color {
        @Override
        public void fill() {
            System.out.println("Inside Green::fill() method.");
        }
    }

    static class Blue implements Color {
        @Override
        public void fill() {
            System.out.println("Inside Blue::fill() method.");
        }
    }

    static class Red implements Color {
        @Override
        public void fill() {
            System.out.println("Inside Red::fill() method.");
        }
    }

    abstract static class AbstractFactory {
        public abstract Color getColor(String color);
        public abstract Shape getShape(String shape);
    }

    static class ShapeFactory extends AbstractFactory {
        @Override
        public Shape getShape(String shapeType) {
            if (shapeType == null) {
                return null;
            }
            if (shapeType.equalsIgnoreCase("CIRCLE")) {
                return new Circle();
            } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
                return new Rectangle();
            } else if (shapeType.equalsIgnoreCase("SQUARE")) {
                return new Square();
            }
            return null;
        }

        @Override
        public Color getColor(String color) {
            return null;
        }
    }

    static class ColorFactory extends AbstractFactory {

        @Override
        public Shape getShape(String shapeType) {
            return null;
        }

        @Override
        public Color getColor(String color) {
            if (color == null) {
                return null;
            }
            if (color.equalsIgnoreCase("RED")) {
                return new Red();
            } else if (color.equalsIgnoreCase("GREEN")) {
                return new Green();
            } else if (color.equalsIgnoreCase("BLUE")) {
                return new Blue();
            }
            return null;
        }
    }

    static class FactoryProducer {
        static AbstractFactory getFactory(String choice) {
            if (choice.equalsIgnoreCase("SHAPE")) {
                return new ShapeFactory();
            } else if (choice.equalsIgnoreCase("COLOR")) {
                return new ColorFactory();
            }
            return null;
        }
    }

    @Test
    void test() {

        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");


        //获取形状为 Circle 的对象
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();
        //获取形状为 Rectangle 的对象
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //调用 Rectangle 的 draw 方法
        shape2.draw();
        //获取形状为 Square 的对象
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //调用 Square 的 draw 方法
        shape3.draw();

        //获取颜色为 Red 的对象
        Color color1 = colorFactory.getColor("RED");
        //调用 Red 的 fill 方法
        color1.fill();
        //获取颜色为 Green 的对象
        Color color2 = colorFactory.getColor("Green");
        //调用 Green 的 fill 方法
        color2.fill();
        //获取颜色为 Blue 的对象
        Color color3 = colorFactory.getColor("BLUE");
        //调用 Blue 的 fill 方法
        color3.fill();
    }
}
