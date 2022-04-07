package xqk.learn.datastructurealgorithm.algorithm.sort.impl;

import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;

/**
 * 插入排序：
 * 在右边未排序的数组中选择第一个,将其插入到左边已经排序的数组中去
 * 平均时间复杂度：O(N^2)
 * 最低时间复杂度：O(N)
 * 最高时间复杂度：O(N^2)
 * <p>
 * 数据已有序时，时间复杂度为O(N)，相比于冒泡排序，插入排序交换数组元素的操作耗费较少，性能更好一些
 */
public class InsertionSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            var temp = arr[i];
            for (; j > 0; j--) {
                if (temp.compareTo(arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = temp;
        }
    }
}
