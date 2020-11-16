package code.code;

/**
 * @author duson
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        final int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; ++i) {
            int min = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
            if (min == ugly[p2] * 2) {
                p2++;
            }
            if (min == ugly[p3] * 3) {
                p3++;
            }
            if (min == ugly[p5] * 5) {
                p5++;
            }
            ugly[i] = min;
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        System.out.println(nthUglyNumber.nthUglyNumber(10));
    }
}
