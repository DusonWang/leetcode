package code.code;

/**
 * 一个已排序好的表?A，其包含 1 和其他一些素数.? 当列表中的每一个 p<q 时，我们可以构造一个分数 p/q 。
 * <p>
 * 那么第?k?个最小的分数是多少呢?? 以整数数组的形式返回你的答案, 这里?answer[0] = p?且?answer[1] = q.
 * <p>
 * 示例:
 * 输入: A = [1, 2, 3, 5], K = 3
 * 输出: [2, 5]
 * 解释:
 * 已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * 很明显第三个最小的分数是 2/5.
 * <p>
 * 输入: A = [1, 7], K = 1
 * 输出: [1, 7]
 * 注意:
 * <p>
 * A 长度的取值范围在 2 — 2000.
 * 每个?A[i] 的值在 1 —30000.
 * K 取值范围为 1 —A.length * (A.length - 1) / 2
 * 通过次数1,390提交次数3,692
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] primes, int k) {
        double lo = 0, hi = 1;
        int[] ans = new int[]{0, 1};
        while (hi - lo > 1e-9) {
            double mi = lo + (hi - lo) / 2.0;
            int[] res = under(mi, primes);
            if (res[0] < k) {
                lo = mi;
            } else {
                ans[0] = res[1];
                ans[1] = res[2];
                hi = mi;
            }
        }
        return ans;
    }

    public int[] under(double x, int[] primes) {
        int numer = 0, denom = 1, count = 0, i = -1;
        for (int j = 1; j < primes.length; ++j) {
            while (primes[i + 1] < primes[j] * x) {
                ++i;
            }
            count += i + 1;
            if (i >= 0 && numer * primes[j] < denom * primes[i]) {
                numer = primes[i];
                denom = primes[j];
            }
        }
        return new int[]{count, numer, denom};
    }
}
