package com.morcat.lru;

/**
 * @author shenzixing
 * @since 2020-12-06
 */
public class Main {

    public static void main(String[] args) {
        // 测试LRUCache
        LRUCache cache = getLRUCache("CustomLRUCache", 3);
        cache.putKey("k1", "v1");
        cache.putKey("k2", "v2");
        cache.putKey("k3", "v3");

        System.out.println("==> 获取k2, value=" + cache.getKey("k2"));
        System.out.println("==> 获取k1, value=" + cache.getKey("k1"));
        System.out.println("==> 获取k3, value=" + cache.getKey("k3"));
        System.out.println("====================================");
        // 此时插入k4,应该淘汰最先使用的k2
        cache.putKey("k4", "v4");
        System.out.println("=============此时插入k4,应该淘汰最先使用的k2==================");
        System.out.println();
        System.out.println("==> 获取k1, value=" + cache.getKey("k1"));
        System.out.println("==> 获取k2, value=" + cache.getKey("k2"));
        System.out.println("==> 获取k3, value=" + cache.getKey("k3"));
        System.out.println("==> 获取k4, value=" + cache.getKey("k4"));


    }

    private static LRUCache getLRUCache(String mode, Integer capacity) {
        switch (mode) {
            case "LinkedHashMapLRUCache":
                return new LinkedHashMapLRUCache(capacity);
            case "CustomLRUCache":
                return new CustomLRUCache(capacity);
            default:
                throw new RuntimeException("参数错误");
        }
    }


}
