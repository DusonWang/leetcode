package code.code;

/**
 * @author duson
 * 请你帮忙设计一个程序，用来找出第?n?个丑数。
 *
 * 丑数是可以被?a?或?b?或 c?整除的 正整数。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 * 示例 2：
 *
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 12... 其中第 4 个是 6。
 * 示例 3：
 *
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 * 示例 4：
 *
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 * ?
 *
 * 提示：
 *
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * 本题结果在?[1,?2 * 10^9]?的范围内
 * 通过次数2,367提交次数11,161
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumberIII {

    public int nthUglyNumber(int n, int A, int B, int C) {
        if (A == 1 || B == 1 || C == 1) {
            return n;
        }
        long res = 0;
        long a = A;
        long b = B;
        long c = C;
        long ab = a * b / gcd(a, b);
        long ac = a * c / gcd(a, c);
        long bc = b * c / gcd(b, c);
        long abc = a * bc / gcd(a, bc);
        long left = 0;
        long right = 2000000000;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long cnt = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (cnt == n) {
                res = mid;
                right = mid - 1;
            } else if (cnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) res;
    }

    private long gcd(long a, long b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
