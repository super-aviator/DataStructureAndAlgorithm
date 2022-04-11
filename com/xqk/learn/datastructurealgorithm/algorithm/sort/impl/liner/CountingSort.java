package xqk.learn.datastructurealgorithm.algorithm.sort.impl.liner;

import java.util.Arrays;

import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;

/**
 * CountingSort-计数排序
 * 适用于需要排序的数都是正数，并且需要排序的数最大值不大的情况
 *
 * 时间复杂度：O(N)
 *
 * @author xiongqiankun
 * @since 2022/4/7 14:30
 */
public class CountingSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        if (arr.length < 2) return;
        //找到数组最大值
        int max = Arrays.stream(arr).max(Integer::compareTo).orElse(0);
        int[] c = new int[max+1];
        //进行计数
        Arrays.stream(arr).forEach(i -> c[i]++);
        //对计数值累加
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] + c[i];
        }
        //生成结果数组
        Integer[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.stream(temp).forEach(i -> {
            int index = c[i] - 1;
            arr[index] = i;
            c[i]--;
        });
    }
}
