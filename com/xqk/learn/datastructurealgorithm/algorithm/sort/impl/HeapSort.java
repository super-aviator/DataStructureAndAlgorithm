package xqk.learn.datastructurealgorithm.algorithm.sort.impl;

import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;
import xqk.learn.datastructurealgorithm.utils.ArrayUtils;

/**
 * HeapSort-堆排序
 * 原地排序，时间复杂度为O(nlogn)，空间复杂度为O(1)
 *
 * @author xiongqiankun
 * @since 2022/5/1 13:03
 */
public class HeapSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        buildHeap(arr);
        //排序
        int idx = arr.length;
        while (idx > 1) {
            ArrayUtils.swap(arr, 0, --idx);
            heapify(arr, idx, 0);
        }
    }

    private void buildHeap(Integer[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    private void heapify(Integer[] arr, int length, Integer idx) {
        while ((idx * 2 + 1) < length) {
            int des = idx * 2 + 1;
            if ((des + 1) < length && arr[des + 1] > arr[des]) {
                des++;
            }
            if (arr[des] > arr[idx]) {
                ArrayUtils.swap(arr, idx, des);
                idx = des;
                continue;
            }
            break;
        }
    }
}
