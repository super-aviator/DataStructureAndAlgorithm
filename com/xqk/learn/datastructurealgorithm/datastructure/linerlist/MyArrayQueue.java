package xqk.learn.datastructurealgorithm.datastructure.linerlist;

import java.util.Arrays;

/**
 * MyQueue
 *
 * @author xiongqiankun
 * @since 2022/3/29 9:17
 */
public class MyArrayQueue<T> {
    private final Object[] items;
    private final int capacity;
    private int head;
    private int tail;

    public MyArrayQueue(int capacity) {
        items = new Object[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(T t) {
        if (tail == capacity) {
            if (head == 0) return false;
            System.arraycopy(items, head, items, 0, tail - head);
            tail = tail - head;
            head = 0;
        }
        items[tail++] = t;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (tail == head) return null;
        T res = (T) items[head];
        items[head++] = null;
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(items) + " :" + head + " :" + tail;
    }

    public static void main(String[] args) {
        String str = "abcdefghi";
        var queue = new MyArrayQueue<>(str.length());
        for (char ch : str.toCharArray())
            queue.enqueue(ch);
        System.out.println(queue);
        for (int i = 0; i < 5; i++)
            queue.enqueue(queue.dequeue());
        System.out.println(queue);
        for (int i = 0; i < 5; i++)
            queue.enqueue(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.enqueue('z'));
    }
}
