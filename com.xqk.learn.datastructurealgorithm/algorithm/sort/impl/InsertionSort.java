package algorithm.sort.impl;

import algorithm.sort.interfaces.Sort;

/**
 * 插入排序：
 * 在右边未排序的数组中选择第一个,将其插入到左边已经排序的数组中去
 * 平均时间复杂度：O(N^2)
 * 最低时间复杂度：O(N)
 * <p>
 * 数据已有序时，时间复杂度为O(N)
 */
public class InsertionSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }
}
