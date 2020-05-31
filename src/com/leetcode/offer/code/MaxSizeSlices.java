package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨：
 * <p>
 * 你挑选 任意?一块披萨。
 * Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。
 * Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。
 * 重复上述过程直到没有披萨剩下。
 * 每一块披萨的大小按顺时针方向由循环数组 slices?表示。
 * <p>
 * 请你返回你可以获得的披萨大小总和的最大值。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：slices = [1,2,3,4,5,6]
 * 输出：10
 * 解释：选择大小为 4 的披萨，Alice 和 Bob 分别挑选大小为 3 和 5 的披萨。然后你选择大小为 6 的披萨，Alice 和 Bob 分别挑选大小为 2 和 1 的披萨。你获得的披萨总大小为 4 + 6 = 10 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：slices = [8,9,8,6,1,1]
 * 输出：16
 * 解释：两轮都选大小为 8 的披萨。如果你选择大小为 9 的披萨，你的朋友们就会选择大小为 8 的披萨，这种情况下你的总和不是最大的。
 * 示例 3：
 * <p>
 * 输入：slices = [4,1,2,5,8,3,1,9,7]
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：slices = [3,1,2]
 * 输出：3
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= slices.length <= 500
 * slices.length % 3 == 0
 * 1 <= slices[i] <= 1000
 * 通过次数927提交次数2,136
 * 在真实的面试中遇到过这道题？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pizza-with-3n-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSizeSlices {

    public int maxSizeSlices(int[] slices) {
        int m = slices.length, n = m / 3;
        int[] slices1 = Arrays.copyOfRange(slices, 0, m - 1);
        int[] slices2 = Arrays.copyOfRange(slices, 1, m);
        return Math.max(maxSum(slices1, n), maxSum(slices2, n));
    }

    private int maxSum(int[] arr, int n) {
        int m = arr.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == 1) {
                    dp[i][j] = arr[0];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + arr[i - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
