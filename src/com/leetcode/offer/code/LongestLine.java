package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * <p>
 * 给定一个01矩阵 M，找到矩阵中最长的连续1线段。这条线段可以是水平的、垂直的、对角线的或者反对角线的。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [[0,1,1,0],
 * [0,1,1,0],
 * [0,0,0,1]]
 * 输出: 3
 * 提示: 给定矩阵中的元素数量不会超过 10,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-line-of-consecutive-one-in-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestLine {

    public int longestLine(int[][] m) {
        int ans = 0;
        int rows = m.length;
        int cols = (rows > 0) ? m[0].length : 0;
        if (rows * cols == 0) {
            return 0;
        }
        int[][][] dp = new int[rows + 1][cols + 2][4];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (m[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                    dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
                    dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
                    ans = Math.max(ans, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }
        return ans;
    }
}
