package algorithm.basic;


/**
 * pow函数的实现：
 * 采用，
 */
public class Pow {
    public double pow(double x, int n) {
        return powRecursion(x,n);
    }

    private double powRecursion(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = powRecursion(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        Pow pow=new Pow();
        // Assertions.assertEquals(Math.pow(56,4),pow.pow(56,4));
        // Assertions.assertEquals(Math.pow(17,5),pow.pow(17,5));
    }
}
