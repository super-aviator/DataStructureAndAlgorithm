package xqk.learn.datastructurealgorithm.algorithm.sort.impl;

import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;

/**
 * 冒泡排序：从左到右，每次交换相邻两个元素的位置，将最大的数据冒泡到最右边
 * 平均时间复杂度：O(N^2)
 * 最高时间复杂度：O(N^2)
 * 最低时间复杂度：O(N) 数组有序时
 * <p>
 * 通过设置标志位，当排序过程中无交换时，表示已经有序，可以减少数组元素比较的次数
 */
public class BubbleSort implements Sort<Integer> {

    @Override
    public void sort(Integer[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean hasSwap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    hasSwap = true;
                }
            }
            if (!hasSwap) return;
        }
    }
}
