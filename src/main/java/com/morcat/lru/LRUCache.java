package com.morcat.lru;

/**
 * @author shenzixing
 * @since 2020-12-06
 */
public interface LRUCache {

    Object getKey(String key);

    void putKey(String key, Object value);


}
