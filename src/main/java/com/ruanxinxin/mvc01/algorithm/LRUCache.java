package com.ruanxinxin.mvc01.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache {

    private int size;//当前缓存大小

    private int capacity;//缓存最大容量

    private Map<Integer, DNode> map;

    private DNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        //先判断是否已经存在此key
        DNode node = map.get(key);
        //不存在此key：加入map，加入头。如果超出容量，删除尾结点
        if (node == null) {
            node = new DNode(key, value);
            map.put(key, node);
            addToHead(node);
            if (size == capacity) {
                DNode last = removeTail();
                map.remove(last.key);
            } else {
                size++;
            }
        } else {//已经存在此key:更新map，移动到头
            node.val = value;
            moveToHead(node);
        }
    }


    private void moveToHead(DNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DNode removeTail() {
        DNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void addToHead(DNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    class DNode {
        int key;
        int val;
        DNode prev;
        DNode next;

        public DNode() {
        }

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
