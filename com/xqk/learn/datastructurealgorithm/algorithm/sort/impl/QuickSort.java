package xqk.learn.datastructurealgorithm.algorithm.sort.impl;

import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;

/**
 * 快速排序：
 * 平均运行时间：O(NlogN)
 * 最坏运行时间：O(N^2)
 * <p>
 * 当切分的元素每次都是数组中最小的元素时，算法的时间复杂度为O(N^2)，此时可以通过随机打乱数组避免此种情况
 */
public class QuickSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Integer[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    public int partition(Integer[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo + 1, j = hi;
        while (i <= j) {
            if (arr[i].compareTo(pivot) > 0) {
                swap(arr, i--, j--);
            }
            i++;
        }
        swap(arr, lo, j);
        return j;
    }

    // private int partition(Integer[] arr, int lo, int hi) {
    //     int mid = arr[lo], i = lo, j = hi + 1;
    //     while (true) {
    //         while (arr[++i].compareTo(mid) < 0) {
    //             if (i >= hi) {
    //                 break;
    //             }
    //         }
    //         while (arr[--j].compareTo(mid) > 0) {
    //             if (j <= lo) {
    //                 break;
    //             }
    //         }
    //         if (i >= j) {
    //             break;
    //         }
    //         swap(arr, i, j);
    //     }
    //     swap(arr, lo, j);
    //     return j;
    // }
}
