package code.code;

/**
 * 有 n 根长度互不相同的木棍，长度为从 1 到 n 的整数。请你将这些木棍排成一排，并满足从左侧 可以看到恰好 k 根木棍。从左侧 可以看到 木棍的前提是这个木棍的 左侧 不存在比它 更长的 木棍。
 * <p>
 * 例如，如果木棍排列为 [1,3,2,5,4] ，那么从左侧可以看到的就是长度分别为 1、3 、5 的木棍。
 * 给你 n 和 k ，返回符合题目要求的排列 数目 。由于答案可能很大，请返回对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 2
 * 输出：3
 * 解释：[1,3,2], [2,3,1] 和 [2,1,3] 是仅有的能满足恰好 2 根木棍可以看到的排列。
 * 可以看到的木棍已经用粗体+斜体标识。
 * 示例 2：
 * <p>
 * 输入：n = 5, k = 5
 * 输出：1
 * 解释：[1,2,3,4,5] 是唯一一种能满足全部 5 根木棍可以看到的排列。
 * 可以看到的木棍已经用粗体+斜体标识。
 * 示例 3：
 * <p>
 * 输入：n = 20, k = 11
 * 输出：647427950
 * 解释：总共有 647427950 (mod 109 + 7) 种能满足恰好有 11 根木棍可以看到的排列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 1 <= k <= n
 * 通过次数1,889提交次数3,157
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RearrangeSticks {

    private final int[][] dp = new int[1001][1001];
    private final int mod = 1000000007;

    public int rearrangeSticks(int n, int k) {
        if (n == k) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[n][k] == 0) {
            dp[n][k] = (int) (((long) rearrangeSticks(n - 1, k - 1) + (long) rearrangeSticks(n - 1, k) * (n - 1)) % mod);
        }
        return dp[n][k];
    }

}
