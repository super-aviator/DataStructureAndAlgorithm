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
        for (int i = 0; i < arr.length - 1; i++) {
            var j = i + 1;
            var temp = arr[j];
            for (; j > 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
