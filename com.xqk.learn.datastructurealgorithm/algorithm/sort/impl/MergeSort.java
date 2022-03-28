package algorithm.sort.impl;

import algorithm.sort.interfaces.Sort;

/**
 * 归并排序：
 * 定义数组的中间位置，然后递归的将数组的前半部分排序，然后对数组的后半部分排序最后将两个排序后的数组合并到一个数组中
 * <p>
 * 最好最差时间复杂度均为：O(NlogN)
 * 空间复杂度：O(1)
 */
public class MergeSort implements Sort<Integer> {
    private Integer[] temp;

    @Override
    public void sort(Integer[] arr) {
        temp = new Integer[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Integer[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public void merge(Integer[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > hi) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[i].compareTo(temp[j]) > 0 ? temp[j++] : temp[i++];
            }
        }
    }
}
