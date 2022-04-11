package xqk.learn.datastructurealgorithm.algorithm.sort;

import xqk.learn.datastructurealgorithm.algorithm.sort.impl.liner.CountingSort;
import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;

public class SortTest {
    private final Integer[] NUM_ARR = {67, 1, 50, 99, 4, -20, 20, 324, 23, 110, 999, 54, 211, 23, 90, 674, 319, 985, 2342, 234, 1, 324, 23456, 223, 78, 11};
    private final Integer[] SMALLER_NUM_ARR = {67, 1, 50, 99, 4, 20, 20, 34, 23, 10, 99, 54, 21, 23, 90, 64, 31, 95, 22, 34, 1, 32, 26, 22, 78, 11};

    private final Sort<Integer> sort;

    public SortTest(Sort<Integer> sort) {
        this.sort = sort;
    }

    public void test() {
        long start = System.currentTimeMillis();
        sort.sort(SMALLER_NUM_ARR);
        System.out.println("耗时：[" + (System.currentTimeMillis() - start) + "] ms");
        if (!sort.isSorted(SMALLER_NUM_ARR)) {
            throw new RuntimeException("排序结果错误");
        }
    }


    public static void main(String[] args) {
        // SortTest test = new SortTest(new InsertionSort());
        // SortTest test = new SortTest(new SelectionSort());
        // SortTest test = new SortTest(new BubbleSort());
        // SortTest test = new SortTest(new ShellSort());
        // SortTest test = new SortTest(new MergeSort());
        // SortTest test = new SortTest(new QuickSort());
        SortTest test = new SortTest(new CountingSort());
        test.test();
    }
}
