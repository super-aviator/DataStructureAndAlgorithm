package xqk.learn.datastructurealgorithm.algorithm.sort.impl;

import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;

/**
 * 冒泡排序：从左到右，将最大的数据冒泡到最右边
 * 平均时间复杂度：O(N^2)
 * 最高时间复杂度：O(N^2)
 */
public class BubbleSort implements Sort<Integer> {

    @Override
    public void sort(Integer[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
