package com.leetcode.offer.day46;

/**
 * @author duson
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * <p>
 * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 * <p>
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 * <p>
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 * <p>
 * 示例:
 * <p>
 * n = 10, 我选择了8.
 * <p>
 * 第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
 * 第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
 * 第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。
 * <p>
 * 游戏结束。8 就是我选的数字。
 * <p>
 * 你最终要支付 5 + 7 + 9 = 21 块钱。
 * 给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetMoneyAmount {

    private int[][] dp;

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return helper(1, n);
    }

    private int helper(int start, int end) {
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        if (start >= end) {
            return 0;
        }
        if (start >= end - 2) {
            return dp[start][end] = end - 1;
        }
        int mid = (start + end) / 2 - 1, min = Integer.MAX_VALUE;
        while (mid < end) {
            int left = helper(start, mid - 1);
            int right = helper(mid + 1, end);
            min = Math.min(min, mid + Math.max(left, right));
            if (right <= left) {
                break;
            }
            mid++;
        }
        return dp[start][end] = min;
    }

    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[start][start + len - 1] = minres;
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmount3(int n) {
        int[][] table = new int[n + 1][n + 1];
        return dp(table, 1, n);
    }

    private int dp(int[][] t, int s, int e) {
        if (s >= e) {
            return 0;
        }
        if (t[s][e] != 0) {
            return t[s][e];
        }
        int res = Integer.MAX_VALUE;
        for (int x = s; x <= e; x++) {
            int tmp = x + Math.max(dp(t, s, x - 1), dp(t, x + 1, e));
            res = Math.min(res, tmp);
        }
        t[s][e] = res;
        return res;
    }
}
