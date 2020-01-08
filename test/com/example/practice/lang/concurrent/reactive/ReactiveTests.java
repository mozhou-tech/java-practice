package com.example.practice.lang.concurrent.reactive;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;

/**
 * Reactor 认为阻塞可能是浪费的，reactive意味着异步非阻塞
 *
 * 响应式编程，类似于Kafka的发布和订阅
 */
public class ReactiveTests {

    public class EndSubscriber<T> implements Flow.Subscriber<T> {
        private Flow.Subscription subscription;
        public List<T> consumedElements = new LinkedList<>();

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
        }

        /**
         * Method invoked with a Subscription's next item.  If this
         * method throws an exception, resulting behavior is not
         * guaranteed, but may cause the Subscription to be cancelled.
         *
         * @param item the item
         */
        @Override
        public void onNext(T item) {

        }

        /**
         * Method invoked upon an unrecoverable error encountered by a
         * Publisher or Subscription, after which no other Subscriber
         * methods are invoked by the Subscription.  If this method
         * itself throws an exception, resulting behavior is
         * undefined.
         *
         * @param throwable the exception
         */
        @Override
        public void onError(Throwable throwable) {

        }

        /**
         * Method invoked when it is known that no additional
         * Subscriber method invocations will occur for a Subscription
         * that is not already terminated by error, after which no
         * other Subscriber methods are invoked by the Subscription.
         * If this method throws an exception, resulting behavior is
         * undefined.
         */
        @Override
        public void onComplete() {

        }
    }

}
