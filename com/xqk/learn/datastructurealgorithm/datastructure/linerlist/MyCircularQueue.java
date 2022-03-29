package xqk.learn.datastructurealgorithm.datastructure.linerlist;

import java.util.Arrays;

/**
 * MyQueue
 *
 * @author xiongqiankun
 * @since 2022/3/29 9:17
 */
public class MyCircularQueue<T> {
    private final Object[] items;
    private final int capacity;
    private int head;
    private int tail;

    public MyCircularQueue(int capacity) {
        items = new Object[capacity + 1];
        this.capacity = capacity + 1;
    }

    public boolean enqueue(T t) {
        if ((tail + 1) % capacity == head) return false;
        items[tail++] = t;
        tail %= capacity;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (tail == head) return null;
        T res = (T) items[head];
        items[head++] = null;
        head %= capacity;
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(items) + " :" + head + " :" + tail;
    }

    public static void main(String[] args) {
        String str = "abcdefghi";
        var queue = new MyCircularQueue<>(str.length());
        for (char ch : str.toCharArray())
            queue.enqueue(ch);
        System.out.println(queue);
        for (int i = 0; i < 5; i++)
            queue.enqueue(queue.dequeue());
        System.out.println(queue);
        for (int i = 0; i < 6; i++)
            queue.enqueue(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.enqueue('z'));
    }
}
