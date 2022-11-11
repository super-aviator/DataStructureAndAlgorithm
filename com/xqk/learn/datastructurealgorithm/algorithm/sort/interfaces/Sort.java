package xqk.learn.datastructurealgorithm.algorithm.sort.interfaces;

import java.util.Arrays;

public interface Sort<T extends Comparable<? super T>> {
    void sort(T[] arr);

    default void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    default boolean isSorted(T[] arr) {
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    default boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
}
