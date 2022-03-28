package xqk.learn.datastructurealgorithm.datastructure.linerlist;

import java.util.Arrays;

/**
 * MyStack
 *
 * @author xiongqiankun
 * @since 2022/3/28 9:29
 */
public class MyStack<E> {
    private final Object[] items;
    private final int capacity;
    private int count;

    public MyStack(int capacity) {
        this.items = new Object[capacity];
        this.capacity = capacity;
    }

    public boolean push(E e) {
        if (count == capacity) return false;
        items[count++] = e;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) return null;
        E e = (E) items[--count];
        items[count] = null;
        return e;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        String str = "abcdefghijklmn";
        MyStack<Character> stack = new MyStack<>(str.length());
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + (stack.isEmpty() ? "" : ","));
        }
    }
}
