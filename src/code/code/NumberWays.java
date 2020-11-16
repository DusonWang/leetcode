package code.code;

import java.util.List;

/**
 * @author duson
 * 总共有 n?个人和 40 种不同的帽子，帽子编号从 1 到 40 。
 * <p>
 * 给你一个整数列表的列表?hats?，其中?hats[i]?是第 i?个人所有喜欢帽子的列表。
 * <p>
 * 请你给每个人安排一顶他喜欢的帽子，确保每个人戴的帽子跟别人都不一样，并返回方案数。
 * <p>
 * 由于答案可能很大，请返回它对?10^9 + 7?取余后的结果。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：hats = [[3,4],[4,5],[5]]
 * 输出：1
 * 解释：给定条件下只有一种方法选择帽子。
 * 第一个人选择帽子 3，第二个人选择帽子 4，最后一个人选择帽子 5。
 * 示例 2：
 * <p>
 * 输入：hats = [[3,5,1],[3,5]]
 * 输出：4
 * 解释：总共有 4 种安排帽子的方法：
 * (3,5)，(5,3)，(1,3) 和 (1,5)
 * 示例 3：
 * <p>
 * 输入：hats = [[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
 * 输出：24
 * 解释：每个人都可以从编号为 1 到 4 的帽子中选。
 * (1,2,3,4) 4 个帽子的排列方案数为 24 。
 * 示例 4：
 * <p>
 * 输入：hats = [[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]]
 * 输出：111
 * ?
 * <p>
 * 提示：
 * <p>
 * n == hats.length
 * 1 <= n <= 10
 * 1 <= hats[i].length <= 40
 * 1 <= hats[i][j] <= 40
 * hats[i]?包含一个数字互不相同的整数列表。
 * 通过次数1,068提交次数2,744
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-wear-different-hats-to-each-other
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberWays {

    public int numberWays(List<List<Integer>> hats) {
        int[] peoples = new int[40];
        int p = 1;
        for (List<Integer> hat : hats) {
            for (int h : hat) {
                peoples[h - 1] |= p;
            }
            p <<= 1;
        }
        int[] dp = new int[p];
        dp[0] = 1;
        for (int people : peoples) {
            if (people == 0) {
                continue;
            }
            for (int status = p; status > 0; status--) {
                for (int mask = people & status, pp; mask > 0; mask ^= pp) {
                    pp = (-mask) & mask;
                    dp[status] = (dp[status ^ pp] + dp[status]) % 1000000007;
                }
            }
        }
        return dp[p - 1];
    }
}
