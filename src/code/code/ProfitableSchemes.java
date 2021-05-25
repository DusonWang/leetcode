package code.code;

/**
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第?i?种工作会产生?profit[i]?的利润，它要求?group[i]?名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生?minProfit 利润的子集称为盈利计划。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模?10^9 + 7?的值。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * 示例 2：
 * <p>
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 * 通过次数3,068提交次数7,755
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/profitable-schemes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProfitableSchemes {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_000 + 7;
        int N = group.length;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            int g = group[i];
            int p = profit[i];
            for (int j = n; j >= g; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] += dp[j - g][Math.max(k - p, 0)];
                    dp[j][k] %= MOD;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += dp[i][minProfit];
            sum %= MOD;
        }
        return sum;
    }
}
