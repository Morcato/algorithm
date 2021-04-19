package com.morcat.leetcode;


import java.util.HashMap;

/**
 *
 *  Q146_LRU 缓存机制
 *
 *  运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 *
 *  @author shenzixing
 *  @since 2021-04-19
 */
public class Q146 {

    private HashMap<String, Node> hashMap;
    // 头节点
    private Node head;
    // 尾节点
    private Node tail;

    /**
     * 容量
     */
    private final int cacheSize;

    public Q146(int cacheSize) {
        hashMap = new HashMap<>(cacheSize);
        this.cacheSize = cacheSize;
    }

    /**
     * 双向链表的节点
     */
    public class Node {
        // 前驱节点
        private Node prev;
        // 后驱节点
        private Node next;
        // key值
        private String key;
        // value值
        private Object value;

        public Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }

    }


    public Object getKey(String key) {
        Node node = hashMap.get(key);

        //如果为空则返回空
        if (node == null) {
            return null;
        }

        //如果不为空则更新Node位置
        refreshNode(node);
        // 返回数据
        return node.value;

    }

    public void putKey(String key, Object value) {
        Node node = hashMap.get(key);

        if (node == null) {
            // node 不存在,则需要插入数据

            // 如果数据量大于等于阈值,则删除表头节点
            if (hashMap.size() >= cacheSize) {
                String headKey = head.key;
                deleteNode(head);
                hashMap.remove(headKey);
            }
            // 表尾插入新节点
            Node newNode = new Node(key, value);
            addNode(newNode);
            hashMap.put(key, newNode);

        } else {
            // node 存在,则更新节点
            node.value = value;
            refreshNode(node);
        }
    }

    /**
     * 更新Node位置
     */
    private void refreshNode(Node node) {
        // 如果访问的是尾节点，无需移动节点
        if (node == tail) {
            return;
        }
        // 移除节点
        deleteNode(node);
        // 重新插入节点
        addNode(node);
    }

    /**
     * 移除节点
     */
    private void deleteNode(Node node) {
        if (node == tail) {
            // 如果该节点是尾结点,则移除尾节点
            tail = tail.prev;
        } else if (node == head) {
            // 如果该节点是头结点,则移除头节点
            head = head.next;
        } else {
            // 如果该节点是中间结点
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     * 插入一个节点
     */
    private void addNode(Node node) {
        if (tail != null) {
            tail.next = node;
            node.prev = tail;
            node.next = null;
        }
        // 该节点为尾节点
        tail = node;
        if (head == null) {
            head = node;
        }
    }

}
