package xqk.learn.datastructurealgorithm.algorithm.basic;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 二分查找：底层必须依赖数组，并且还要求数据是有序的。
 * 时间复杂度：O(logN)
 */
public class BinarySearch {
    private static final int[] intArr = {100, 67, 51, 3, 56, -1, 4, 29, 9, 90, 100, 789, -100};

    /**
     * 二分查找的非递归实现
     *
     * @param intArr intArr
     * @param num    num
     * @return int
     */
    public static int binarySearch(int[] intArr, int num) {
        Arrays.sort(intArr);
        int lo = 0, hi = intArr.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (intArr[mid] > num) {
                hi = mid - 1;
            } else if (intArr[mid] < num) {
                lo = mid + 1;
            } else {
                return intArr[mid];
            }
        }
        return -1;
    }

    /**
     * 二分查找的递归实现
     *
     * @param intArr intArr
     * @param num    num
     * @return int
     */
    public static int binarySearchRecursion(int[] intArr, int num) {
        return binarySearchRecursion(intArr, num, 0, intArr.length);
    }

    private static int binarySearchRecursion(int[] intArr, int num, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + ((hi - lo) >> 1);
        if (intArr[mid] > num) {
            return binarySearchRecursion(intArr, num, lo, mid - 1);
        } else if (intArr[mid] < num) {
            return binarySearchRecursion(intArr, num, mid + 1, hi);
        } else {
            return intArr[mid];
        }
    }

    /**
     * 二分查找第一个等于某个值的元素位置
     *
     * @param intArr intArr
     * @param num    num
     * @return int
     */
    public static int binarySearchFirst(int[] intArr, int num) {
        // 方法一
        // int lo = 0, hi = intArr.length - 1;
        // while (lo <= hi) {
        //     int mid = lo + ((hi - lo) >> 1);
        //     if (intArr[mid] < num) {
        //         lo = mid + 1;
        //     } else if (intArr[mid] > num) {
        //         hi = mid - 1;
        //     } else {
        //         if (mid == 0 || intArr[mid - 1] != num) return mid;
        //         hi = mid - 1;
        //     }
        // }
        // return -1;

        //方法二
        int lo = 0, hi = intArr.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (intArr[mid] >= num) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * 二分查找最后一个等于某个值的元素位置
     *
     * @param intArr intArr
     * @param num    num
     * @return int
     */
    public static int binarySearchLast(int[] intArr, int num) {
        //方法一
        // int lo = 0, hi = intArr.length - 1, ans = -1;
        // while (lo <= hi) {
        //     int mid = lo + ((hi - lo) >> 1);
        //     if (intArr[mid] < num) {
        //         lo = mid + 1;
        //     } else if (intArr[mid] > num) {
        //         hi = mid - 1;
        //     } else {
        //         if (mid == intArr.length - 1 || intArr[mid + 1] != num) return mid;
        //         lo = mid + 1;
        //     }
        // }
        // return ans;

        //方法二
        int lo = 0, hi = intArr.length - 1;
        while (lo < hi) {
            //这里加1是因为(2+3)/2=2而不是3，需要手动加1
            int mid = lo + ((hi - lo) >> 1) + 1;
            if (intArr[mid] <= num) {
                lo = mid;
            } else if (intArr[mid] > num) {
                hi = mid - 1;
            }
        }
        return lo;
    }

    /**
     * 二分查找第一个大于等于给定值的元素
     *
     * @param intArr intArr
     * @param num    num
     * @return int
     */
    public static int binarySearchFirstGreaterThan(int[] intArr, int num) {
        int lo = 0, hi = intArr.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (intArr[mid] < num) {
                lo = mid + 1;
            } else if (intArr[mid] >= num) {
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 二分查找最后一个小于等于给定值的元素
     *
     * @param intArr intArr
     * @param num    num
     * @return int
     */
    public static int binarySearchLastLessThan(int[] intArr, int num) {
        int lo = 0, hi = intArr.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (intArr[mid] <= num) {
                ans = mid;
                lo = mid + 1;
            } else if (intArr[mid] > num) {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.binarySearch(intArr, 90));
        System.out.println(BinarySearch.binarySearch(intArr, 5));
        System.out.println(BinarySearch.binarySearch(intArr, 3));
        System.out.println("-------------------------------------------------------------");
        System.out.println(BinarySearch.binarySearchRecursion(intArr, 90));
        System.out.println(BinarySearch.binarySearchRecursion(intArr, 5));
        System.out.println(BinarySearch.binarySearchRecursion(intArr, 3));
        System.out.println("----------------------------binarySearchFirstLast---------------------------------");
        int[] arr = {1, 1, 1, 8, 8, 8, 8, 3, 5, 6, 7, 1, 10, 10, 10, 8, 9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(IntStream.range(0, arr.length).boxed().collect(Collectors.toList()));
        System.out.println(BinarySearch.binarySearchFirst(arr, 10));
        System.out.println(BinarySearch.binarySearchLast(arr, 10));
        System.out.println(BinarySearch.binarySearchFirst(arr, 8));
        System.out.println(BinarySearch.binarySearchLast(arr, 8));
        System.out.println(BinarySearch.binarySearchFirst(arr, 1));
        System.out.println(BinarySearch.binarySearchLast(arr, 1));
        System.out.println("----------------------binarySearchFirstLastGreaterLessThan-------------------------");
        System.out.println(Arrays.toString(arr));
        System.out.println(BinarySearch.binarySearchFirstGreaterThan(arr, 11));
        System.out.println(BinarySearch.binarySearchLastLessThan(arr, 11));

    }
}
