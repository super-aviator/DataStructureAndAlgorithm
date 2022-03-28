package algorithm.basic;


import java.util.Arrays;

import utils.arrays.ArrayUtils;

/**
 * 快速排序：
 * 时间复杂度为：O(N)
 */
public class FindK {
    private static final Integer[] nums = {67, 1, 50, 99, 4, 20, 324, 23, 999};

    public static void main(String[] args) {
        FindK findK = new FindK();
        int lo = 0, hi = nums.length - 1, k = 5;
        while (lo <= hi) {
            int j = findK.partition(nums, lo, hi);
            if (j > k) {
                hi = j - 1;
            } else if (j < k) {
                lo = j + 1;
            } else {
                System.out.println("排名第" + k + "结果是：" + nums[k]);
                System.out.println(Arrays.toString(nums));
                return;
            }
        }
    }

    public int partition(Integer[] arr, int lo, int hi) {
        int num = arr[lo], i = lo, j = hi + 1;
        while (true) {
            while (arr[++i].compareTo(num) < 0) {
                if (i >= hi) {
                    break;
                }
            }

            while (arr[--j].compareTo(num) > 0) {
                if (j <= lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            ArrayUtils.swap(arr, i, j);
        }
        ArrayUtils.swap(arr, lo, j);
        return j;
    }
}
