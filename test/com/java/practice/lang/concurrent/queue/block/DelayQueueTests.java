package com.java.practice.lang.concurrent.queue.block;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 缓存系统: 当能够从 DelayQueue 中获取元素时，说该缓存已过期
 * 定时任务调度
 */
class DelayQueueTests {

    static class Cache implements Runnable {

        private boolean stop = false;
        private Map<String, String> itemMap = new HashMap<>();

        /**
         * 延迟队列，用于删除过期元素
         */
        private DelayQueue<CacheItem> delayQueue = new DelayQueue<>();

        Cache() {
            // 开启内部线程检测是否过期
            new Thread(this).start();
        }

        /**
         * 添加缓存
         */
        void put(String key, String value, long expireTime) {
            CacheItem cacheItem = new CacheItem(key, expireTime);
            // 此处忽略添加重复 key 的处理
            delayQueue.add(cacheItem);
            itemMap.put(key, value);
        }

        String get(String key) {
            return itemMap.get(key);
        }

        void shutdown() {
            stop = true;
        }

        @Override
        public void run() {
            while (!stop) {
                CacheItem cacheItem = delayQueue.poll();
                if (cacheItem != null) {
                    // 元素过期, 从缓存中移除
                    itemMap.remove(cacheItem.getKey());
                    System.out.println("Cache.class 内部进程，key : " + cacheItem.getKey() + " 过期并移除");
                }
            }
            System.out.println("Cache.class 内部进程，cache stop");
        }
    }

    static class CacheItem implements Delayed {
        private String key;
        /**
         * 过期时间(单位秒)
         */
        private long expireTime;
        private long currentTime;

        CacheItem(String key, long expireTime) {
            this.key = key;
            this.expireTime = expireTime;
            this.currentTime = System.currentTimeMillis();
        }

        /**
         * 剩余缓存有效期
         *
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            // 计算剩余的过期时间
            // 大于 0 说明未过期
            return expireTime - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - currentTime);
        }

        @Override
        public int compareTo(Delayed o) {
            // 过期时间长的放置在队列尾部
            if (this.getDelay(TimeUnit.MICROSECONDS) > o.getDelay(TimeUnit.MICROSECONDS)) {
                return 1;
            }
            // 过期时间短的放置在队列头
            if (this.getDelay(TimeUnit.MICROSECONDS) < o.getDelay(TimeUnit.MICROSECONDS)) {
                return -1;
            }
            return 0;
        }

        String getKey() {
            return key;
        }
    }

    @Test
    void test() throws InterruptedException {
        Cache cache = new Cache();
        // 添加缓存元素
        cache.put("a", "1", 5);
        cache.put("b", "2", 4);
        cache.put("c", "3", 3);
        while (true) {
            String a = cache.get("a");
            String b = cache.get("b");
            String c = cache.get("c");
            // 元素均过期后退出循环
            if (a == null && b == null && c == null) {
                break;
            }
            System.out.println("a : " + a + ", b : " + b + ", c : " + c);
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        cache.shutdown();
    }

}
