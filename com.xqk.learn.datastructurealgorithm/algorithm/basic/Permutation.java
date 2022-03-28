package algorithm.basic;

import java.util.Arrays;

/**
 * 全排列算法
 *
 * @author 熊乾坤
 * @since 2021-04-09 12:26
 */
public class Permutation {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permutation(new int[]{1, 2, 3}, 0);
    }

    public void permutation(int[] arr, int start) {
        if (start == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permutation(arr, start + 1);
            swap(arr, start, i);
        }
    }

    /**
     * 这里不能用两数相加的技巧来交换数组的两个位置的数据,因为当x、y两个下标一样时，数据会变成0。
     *
     * @param arr 数组
     * @param x   下标x
     * @param y   下标y
     */
    public void swap(int[] arr, int x, int y) {
        int i = arr[y];
        arr[y] = arr[x];
        arr[x] = i;
    }
}
