package com.java.practice.patterns.behavioral;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 迭代器模式（Iterator Pattern）是 Java 和 .Net 编程环境中非常常用的设计模式。
 * 这种模式用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。
 */
class IteratorPatternTests {
    interface Iterator {
        boolean hasNext();
        Object next();
    }

    interface Container {
        Iterator getIterator();
    }

    static class NameRepository implements Container {

        String names[] = {"Robert", "John", "Julie", "Lora"};

        /**
         * 返回迭代器
         * @return
         */
        @Override
        public Iterator getIterator() {
            return new NameIterator();
        }

        private class NameIterator implements Iterator {

            int index;

            @Override
            public boolean hasNext() {
                if (index < names.length) {
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                if (this.hasNext()) {
                    return names[index++];
                }
                return null;
            }
        }
    }

    @Test
    @DisplayName("迭代打印")
    void test() {
        NameRepository namesRepository = new NameRepository();
        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
