package xqk.learn.datastructurealgorithm.algorithm.sort.impl;

import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;

/**
 * 选择排序：对于p，每次从p~length-1中选择最小的数插入到p-1位置
 * 平均时间复杂度：O(N^2)
 */
public class SelectionSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }
}
