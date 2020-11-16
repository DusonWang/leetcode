package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个整数数组 A ，考虑 A 的所有非空子序列。
 * <p>
 * 对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。
 * <p>
 * 返回 A 的所有子序列的宽度之和。
 * <p>
 * 由于答案可能非常大，请返回答案模 10^9+7。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：[2,1,3]
 * 输出：6
 * 解释：
 * 子序列为 [1]，[2]，[3]，[2,1]，[2,3]，[1,3]，[2,1,3] 。
 * 相应的宽度是 0，0，0，1，1，2，2 。
 * 这些宽度之和是 6 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 20000
 * 通过次数1,382提交次数4,825
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subsequence-widths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumSubseqWidths {

    public int sumSubseqWidths(int[] a) {
        Arrays.sort(a);
        long c = 1, res = 0, mod = (long) 1e9 + 7;
        for (int i = 0, n = a.length; i < n; ++i, c = c * 2 % mod) {
            res = (res + a[i] * c - a[n - i - 1] * c) % mod;
        }
        return (int) ((res + mod) % mod);
    }
}
