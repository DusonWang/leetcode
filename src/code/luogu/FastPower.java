package code.luogu;

/**
 * 求A^B 最后三位整数
 * http://acm.hdu.edu.cn/showproblem.php?pid=2035
 *
 * @author duson
 */
public class FastPower {

    /**
     * 普通的求幂函数
     *
     * @param base  底数
     * @param power 指数
     * @return 求幂结果的最后3位数表示的整数
     */
    public long normalPower(long base, long power) {
        long result = 1;
        for (int i = 1; i <= power; i++) {
            result *= base;
            result %= 1000;
        }
        return result % 1000;
    }

    public long normalPower2(long base, long power) {
        long result = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                result = (result * base) % 1000;
            }
            power >>= 1;
            base = (base * base) % 1000;
        }
        return result;
    }

    public static void main(String[] args) {
        FastPower fastPower = new FastPower();
        System.out.println(fastPower.normalPower2(2, 1000000000));
        System.out.println(fastPower.normalPower(2, 1000000000));
    }
}
