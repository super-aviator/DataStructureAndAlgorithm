package algorithm.leetcode;

/**
 * 二进制间隙
 *
 * @author 熊乾坤
 * @since 2021-04-02 10:31
 */
public class BinaryGap_868 {
    public static void main(String[] args) {
        BinaryGap_868 binaryGap868 = new BinaryGap_868();
        System.out.println(binaryGap868.binaryGap(10));
    }

    public int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) > 0) {
                if (last > -1) {
                    ans = (int) Math.max(ans, i - last);
                }
                last = i;
            }
        }
        return ans;
    }
}
