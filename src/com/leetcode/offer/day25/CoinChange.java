package com.leetcode.offer.day25;

import java.util.Arrays;

/**
 * @author duson
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {

    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        helper(coins, amount, coins.length - 1, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int result = Integer.MAX_VALUE;

    private void helper(int[] coins, int target, int idx, int cur) {
        if (idx < 0) {
            return;
        }
        if (target % coins[idx] == 0) {
            result = Math.min(result, cur + target / coins[idx]);
            return;
        }

        for (int i = target / coins[idx]; i >= 0; --i) {
            if (cur + i >= result - 1) {
                return;
            }
            helper(coins, target - i * coins[idx], idx - 1, cur + i);
        }
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
