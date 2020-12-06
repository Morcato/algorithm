package com.morcat.lru;

import java.util.HashMap;

/**
 * 自定义LRU算法实现(HashMap+链表)
 * 当然是线程不安全的,如果想线程安全,需加锁
 *
 * @author shenzixing
 * @since 2020-12-06
 */
public class CustomLRUCache implements LRUCache {

    private HashMap<String, Node> hashMap;
    // 头节点
    private Node head;
    // 尾节点
    private Node tail;

    /**
     * 容量
     */
    private final int cacheSize;

    public CustomLRUCache(int cacheSize) {
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


    @Override
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

    @Override
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
