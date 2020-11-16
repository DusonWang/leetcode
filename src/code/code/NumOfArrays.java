package code.code;

/**
 * @author duson
 * 给你三个整数 n、m 和 k 。下图描述的算法用于找出正整数数组中最大的元素。
 * <p>
 * <p>
 * <p>
 * 请你生成一个具有下述属性的数组 arr ：
 * <p>
 * arr 中有 n 个整数。
 * 1 <= arr[i] <= m 其中 (0 <= i < n) 。
 * 将上面提到的算法应用于 arr ，search_cost 的值等于 k 。
 * 返回上述条件下生成数组 arr 的 方法数 ，由于答案可能会很大，所以 必须 对 10^9 + 7 取余。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, m = 3, k = 1
 * 输出：6
 * 解释：可能的数组分别为 [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
 * 示例 2：
 * <p>
 * 输入：n = 5, m = 2, k = 3
 * 输出：0
 * 解释：没有数组可以满足上述条件
 * 示例 3：
 * <p>
 * 输入：n = 9, m = 1, k = 1
 * 输出：1
 * 解释：可能的数组只有 [1, 1, 1, 1, 1, 1, 1, 1, 1]
 * 示例 4：
 * <p>
 * 输入：n = 50, m = 100, k = 25
 * 输出：34549172
 * 解释：不要忘了对 1000000007 取余
 * 示例 5：
 * <p>
 * 输入：n = 37, m = 17, k = 7
 * 输出：418930126
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * 1 <= m <= 100
 * 0 <= k <= n
 * 通过次数1,380提交次数2,428
 * 在真实的面试中遇到过这道题？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumOfArrays {

    public int numOfArrays(int n, int m, int k) {
        if (k == 0 || m < k) {
            return 0;
        }
        int mod = 1000_000_007;
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i][1][1] = 1;
        }
        for (int j = 1; j <= m; ++j) {
            dp[1][j][1] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int p = 1; p <= k; ++p) {
                int sum = 0;
                for (int j = 2; j <= m; ++j) {
                    sum = (sum + dp[i - 1][j - 1][p - 1]) % mod;
                    int temp = (int) (((long) dp[i - 1][j][p] * j) % mod);
                    dp[i][j][p] = (sum + temp) % mod;
                }
            }
        }
        int result = 0;
        for (int j = 1; j <= m; ++j) {
            result = (result + dp[n][j][k]) % mod;
        }
        return result % mod;
    }
}
