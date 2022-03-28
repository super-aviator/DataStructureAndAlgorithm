package xqk.learn.datastructurealgorithm.algorithm.sort;

import xqk.learn.datastructurealgorithm.algorithm.sort.impl.BubbleSort;
import xqk.learn.datastructurealgorithm.algorithm.sort.impl.InsertionSort;
import xqk.learn.datastructurealgorithm.algorithm.sort.impl.MergeSort;
import xqk.learn.datastructurealgorithm.algorithm.sort.impl.QuickSort;
import xqk.learn.datastructurealgorithm.algorithm.sort.impl.SelectionSort;
import xqk.learn.datastructurealgorithm.algorithm.sort.impl.ShellSort;
import xqk.learn.datastructurealgorithm.algorithm.sort.interfaces.Sort;

public class SortTest {
    private final Integer[] NUMS = {67, 1, 50, 99, 4, 20, 324, 23, 999};

    private final Sort<Integer> sort;

    public SortTest(Sort<Integer> sort) {
        this.sort = sort;
    }

    public void test() {
        long start = System.currentTimeMillis();
        sort.sort(NUMS);
        System.out.println("耗时：[" + (System.currentTimeMillis() - start) + "] ms");
    }


    public static void main(String[] args) {
        SortTest test = new SortTest(new InsertionSort());
        SortTest test1 = new SortTest(new SelectionSort());
        SortTest test2 = new SortTest(new BubbleSort());
        SortTest test3 = new SortTest(new ShellSort());
        SortTest test4 = new SortTest(new MergeSort());
        SortTest test5 = new SortTest(new QuickSort());

        test4.test();
    }
}
