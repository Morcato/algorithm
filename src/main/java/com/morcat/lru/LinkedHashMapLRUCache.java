package com.morcat.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * linkedHashMap实现LRU
 *
 * @author shenzixing
 * @since 2020-12-06
 */
public class LinkedHashMapLRUCache implements LRUCache {

    private LinkedHashMap<String, Object> linkedHashMap;
    /**
     * 容量
     */
    private final int cacheSize;

    public LinkedHashMapLRUCache(int capacity) {
        this.cacheSize = capacity;
        // 三个构造函数的意义:
        // 第一个参数表示容量
        // 第二个参数表示负载因子
        // 第三个为linkedHashMap的排序模式.true代表根据最近访问顺序排序,false表示根据插入顺序排序.
        linkedHashMap = new LinkedHashMap<String, Object>(capacity, 0.75f, true) {
            /**
             * 钩子方法，通过put新增键值对的时候，若该方法返回true
             * 便移除该map中最老的键和值
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                // 当 map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
                return size() > cacheSize;
            }
        };
    }

    @Override
    public Object getKey(String key) {
        return linkedHashMap.get(key);
    }

    @Override
    public void putKey(String key, Object value) {
        System.out.println("===> putKey:" + key + ",value:" + value);
        linkedHashMap.put(key, value);
    }
}
