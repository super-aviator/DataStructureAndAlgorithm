package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 熊乾坤
 * @date 2020-10-28 17:32
 */
public class FindSum {
    private static final int[] INT_ARR = {2, 3, 5, 7, 9};

    public static void main(String[] args) {
        find(0, new ArrayList<>());
    }

    public static void find(int preNum, List<Integer> temp) {
        for (int i : INT_ARR) {
            if (i + preNum == 13) {
                temp.add(i);
                System.out.println(temp);
                temp.remove(temp.size() - 1);
            } else if (i + preNum < 13) {
                temp.add(i);
                find(i + preNum, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
