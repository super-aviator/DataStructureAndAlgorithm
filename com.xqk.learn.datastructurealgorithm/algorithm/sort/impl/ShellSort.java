package algorithm.sort.impl;

import algorithm.sort.interfaces.Sort;

/**
 * 希尔排序：
 * 与选择排序和插入排序不同，希尔排序适用于大数组
 * 平均时间复杂度：小于O(N^2)
 */
public class ShellSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        int le=arr.length,h=1;

        //首先生成1、4、13递增序列
        while(h<le/3){
            h=h*3+1;
        }
        while(h>=1) {
            for (int i = h; i < le; i++) {
                for (int j = i; j >= h && arr[j].compareTo(arr[j - h]) < 0; j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h/=3;
        }
    }
}
