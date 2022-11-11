package xqk.learn.datastructurealgorithm.datastructure.heap;

import java.util.Arrays;

import xqk.learn.datastructurealgorithm.utils.ArrayUtils;

/**
 * Heap-堆
 * 我们知道，一个包含 n 个节点的完全二叉树，树的高度不会超过 log2^n。堆化的过程是顺着节点所在路径比较交换的，
 * 所以堆化的时间复杂度跟树的高度成正比，也就是 O(logn)。
 * 插入数据和删除堆顶元素的主要逻辑就是堆化，
 * 所以往堆中插入一个元素和删除堆顶元素的时间复杂度都是 O(logn)。
 *
 * @author xiongqiankun
 * @since 2022/5/1 6:47
 */
public class MaxHeap<E extends Comparable<E>> {
    private final int capacity;
    private int count;
    private final Object[] data;

    public MaxHeap(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("非法参数");
        this.capacity = capacity;
        data = new Object[capacity + 1];
    }

    @SuppressWarnings("unchecked")
    public void insert(E e) {
        if (count < capacity) data[++count] = e;
        else if (((E) data[count]).compareTo(e) > 0) return;
        else if (((E) data[count]).compareTo(e) < 0) data[count] = e;
        //从下往上堆化（heapify）
        int idx = count;
        while (idx / 2 >= 1 && ((E) data[idx / 2]).compareTo((E) data[idx]) < 0) {
            ArrayUtils.swap(data, idx, idx / 2);
            idx /= 2;
        }
    }

    @SuppressWarnings("unchecked")
    public E delete() {
        if (count == 0) return null;
        var res = data[1];
        if (count == 1) {
            data[1] = null;
            count--;
        } else {
            var temp = data[count];
            data[count--] = null;
            data[1] = temp;
            //从上往下堆化（heapify）
            int idx = 1;
            while (idx * 2 <= count || idx * 2 + 1 <= count) {
                int des = idx * 2;
                if (((E) data[des]).compareTo((E) data[des + 1]) < 0) des++;
                if (((E) data[idx]).compareTo((E) data[des]) < 0) ArrayUtils.swap(data, idx, des);
                idx = des;
            }
        }
        return (E) res;
    }

    public void print() {
        System.out.println("data:" + Arrays.toString(data));
        System.out.println("count:" + count);
    }

    public static void main(String[] args) {
        var heap = new MaxHeap<Integer>(15);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        heap.insert(9);
        heap.insert(16);
        heap.insert(15);
        heap.insert(13);
        heap.insert(17);
        heap.insert(21);
        heap.insert(33);
        heap.insert(22);
        heap.print();
        System.out.println(heap.delete());
        heap.print();
    }
}

//                         33
//          16                              22
//    9           15                  17            21
// 5     7     1       13          2     8      6
