package code.code;

/**
 * @author duson
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 示例 1: 
 * <p>
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: [0,1]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeBitwiseAnd {

    public int rangeBitwiseAnd(int m, int n) {
        int and = m;
        for (int k = m + 1; k <= n; k++) {
            and = and & k;
        }
        return and;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return n << count;
    }

    public static void main(String[] args) {
        RangeBitwiseAnd rangeBitwiseAnd = new RangeBitwiseAnd();
        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(5, 7));

        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(0, 1));

    }
}
