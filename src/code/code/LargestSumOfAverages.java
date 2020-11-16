package code.code;

/**
 * @author duson
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
 * <p>
 * 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * <p>
 * 示例:
 * 输入:
 * A = [9,1,2,3,9]
 * K = 3
 * 输出: 20
 * 解释:
 * A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 A 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 * 说明:
 * <p>
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * 答案误差在 10^-6 内被视为是正确的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-sum-of-averages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestSumOfAverages {

    public double largestSumOfAverages2(int[] A, int K) {
        int N = A.length;
        double[] sum = new double[N + 1];
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp = tmp + A[i];
            sum[i] = tmp;
        }
        double[] dp = new double[N];
        for (int i = 0; i < N; i++) {
            dp[i] = sum[i] / (i + 1);
        }
        for (int k = 0; k < K - 1; k++) {
            for (int i = N - 2; i >= k; i--) {
                for (int j = i + 1; j < N; j++) {
                    dp[j] = Math.max(dp[j], dp[i] + (sum[j] - sum[i]) / (j - i));
                }
            }
        }
        return dp[N - 1];
    }

    public double largestSumOfAverages(int[] a, int k) {
        final int len = a.length;
        double[][] dp = new double[k + 1][len + 1];
        double sum = 0.0;
        for (int j = 1; j <= a.length; j++) {
            sum += a[j - 1];
            dp[1][j] = sum / j;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= len; j++) {
                sum = 0;
                for (int m = j - 1; m >= 0; m--) {
                    sum += a[m];
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][m] + sum / (j - m));
                }
            }
        }
        return dp[k][len];
    }
}
