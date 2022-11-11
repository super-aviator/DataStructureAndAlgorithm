package xqk.learn.datastructurealgorithm.algorithm.sort.impl;

import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;

/**
 * 归并排序：
 * 定义数组的中间位置，然后递归的将数组的前半部分排序，然后对数组的后半部分排序最后将两个排序后的数组合并到一个数组中
 * <p>
 * 最好最差时间复杂度均为：O(NlogN)
 * 空间复杂度：O(N)
 */
public class MergeSort implements Sort<Integer> {
    private Integer[] temp;

    @Override
    public void sort(Integer[] arr) {
        temp = new Integer[arr.length];
        int lo = 0, hi = arr.length - 1;
        sort(arr, lo, hi);
    }

    public void sort(Integer[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        var mid = lo + ((hi - lo) >> 1);
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public void merge(Integer[] arr, int lo, int mid, int hi) {
        //优化：当左右数组已经有序时不用再归并
        if (arr[mid].compareTo(arr[mid + 1]) <= 0) {
            return;
        }
        System.arraycopy(arr, lo, temp, lo, hi - lo + 1);
        int k = lo, i = lo, j = mid + 1;
        while (i <= mid && j <= hi) {
            arr[k++] = less(temp[i], temp[j]) ? temp[i++] : temp[j++];
        }
        while (i <= mid) arr[k++] = temp[i++];
        while (j <= hi) arr[k++] = temp[j++];
    }
}
