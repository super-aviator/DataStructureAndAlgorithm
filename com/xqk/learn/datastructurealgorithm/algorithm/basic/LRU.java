package xqk.learn.datastructurealgorithm.algorithm.basic;

import java.util.HashMap;

/**
 * LRU-最近最少使用算法
 *
 * @author xiongqiankun
 * @since 2022/4/21 15:04
 */
@SuppressWarnings("unused")
public class LRU {
    private final Node<Integer> head;
    private final Node<Integer> tail;
    private final Integer capacity;
    private final HashMap<Integer, Node<Integer>> map;

    private static class Node<T> {
        private T key;
        private T val;
        private Node<T> prev;
        private Node<T> next;

        public Node() {
        }

        public Node(T key, T val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        var node = map.get(key);
        //移动到链表前面
        if (node != null && head.next != node) {
            //断链
            node.prev.next = node.next;
            node.next.prev = node.prev;
            insertHead(node);
        }
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        var node = map.get(key);
        if (node != null) {
            //断链
            node.prev.next = node.next;
            node.next.prev = node.prev;
            //插入
            insertHead(node);
            node.val = value;
            return;
        }
        if (map.size() - capacity >= 0) removeTail();
        var newNode = new Node<>(key, value);
        insertHead(newNode);
        map.put(key, newNode);
    }

    //将节点插入链表头
    private void insertHead(Node<Integer> node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    //从链表尾删除过期节点
    private void removeTail() {
        if (map.size() == 0) return;
        var node = tail.prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }
}
