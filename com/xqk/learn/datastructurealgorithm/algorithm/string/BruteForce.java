package xqk.learn.datastructurealgorithm.algorithm.string;

/**
 * BruteForce-BF算法
 *
 * @author xiongqiankun
 * @since 2022/5/9 14:40
 */
public class BruteForce {
    public static int find(String des, String pattern) {
        if (des == null || des.isEmpty() || pattern == null || pattern.isEmpty()) return -1;
        if (des.length() < pattern.length()) return -1;
        char[] arr = des.toCharArray();
        char[] pat = pattern.toCharArray();
        for (int i = 0; i <= arr.length - pat.length; i++) {
            int t = i, c = 0;
            while (arr[t++] == pat[c++]) {
                if (c == pat.length) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BruteForce.find("abccba", "bcca"));
    }
}
