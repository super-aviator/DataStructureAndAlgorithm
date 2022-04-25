package xqk.learn.datastructurealgorithm.algorithm.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * sqrt函数实现：
 * 二分查找
 *
 * @author 熊乾坤
 * @since 2021-05-18 19:20
 */
public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(9));
        System.out.println(sqrt.sqrtWithDecimal(147));
        System.out.println(sqrt.sqrtWithDecimal(2));
        System.out.println(Math.pow(3, 40));
    }

    /**
     * 给你一个非负整数 x ，计算并返回x的算术平方根 。
     * <p>
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * <p>
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num num
     * @return 算数平方根
     */
    public int sqrt(int num) {
        int hi = num, ans = -1, lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ((long) mid * mid <= num) {
                ans = hi;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 如何编程实现“求一个数的平方根”？要求精确到小数点后 6 位。
     *
     * @param num num
     * @return int
     */
    public double sqrtWithRoundDecimal(int num, int precision) {

        return 0;
    }

    // Java 实现
    /**
     * 求一个数的平方根，并保留指定精度
     *
     * @param n         给定数字，支持任意正数
     * @param precision 保留精度
     * @return 计算结果
     */
    public double sqrt(double n, int precision) {
        if (n < 0) return Double.NaN;

        double low = 0;
        double high = n;
        double ret = 0;

        // 保留 precision 位小数
        DecimalFormat df = new DecimalFormat("0." + "0".repeat(Math.max(0, precision)));

        // 计算整数位和小数位，并考虑到四舍五入
        for (int i = 0; i < precision + 2; i++) {
            if (i > 0) {
                low = 1;
                high = 9;
            }
            while (low <= high) {
                double mid = (low + high) / 2;
                double tmp = BigDecimal.valueOf(ret).add(BigDecimal.valueOf(mid * Math.pow(10, -i))).doubleValue();
                if (Math.pow(tmp, 2) == n) {
                    return Double.parseDouble(df.format(tmp));
                } else if (Math.pow(tmp, 2) < n) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            ret += high * Math.pow(10, -i);
        }

        return Double.parseDouble(df.format(ret));
    }

    /**
     * 如何编程实现“求一个数的平方根”？要求精确到小数点后 6 位。
     *
     * @param num num
     */
    public double sqrtWithDecimal(int num) {
        return sqrtWithDecimal(BigDecimal.ZERO, BigDecimal.valueOf(num), num);
    }

    private double sqrtWithDecimal(BigDecimal low, BigDecimal high, int num) {
        BigDecimal mid = low.add(high).divide(BigDecimal.valueOf(2));
        BigDecimal product = mid.pow(2);
        if (product.doubleValue() == num) {
            DecimalFormat format = new DecimalFormat(".######");
            format.setRoundingMode(RoundingMode.DOWN);
            return Double.parseDouble(format.format(mid));
        } else if (product.doubleValue() < num) {
            return sqrtWithDecimal(mid, high, num);
        } else {
            return sqrtWithDecimal(low, mid, num);
        }
    }
}
