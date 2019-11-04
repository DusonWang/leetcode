package com.leetcode.offer.code;

/**
 * @author duson
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalSquare {

    public int maximalSquare4(char[][] matrix) {
        final int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    public int maximalSquare3(char[][] matrix) {
        final int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        final int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                while (allOne(matrix, i, j, max + 1)) {
                    max = max + 1;
                }
            }
        }
        return max * max;
    }

    private boolean allOne(char[][] matrix, int x, int y, int len) {
        if (x + len > matrix.length || y + len > matrix[0].length) {
            return false;
        }
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (matrix[i][j] != '1') {
                    return false;
                }
            }
        }
        return true;
    }

    public int maximalSquare2(char[][] matrix) {
        final int row = matrix.length;
        final int col = row > 0 ? matrix[0].length : 0;
        int maxLen = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int qLen = 0;
                    boolean flag = true;
                    while (qLen + i < row && qLen + j < col && flag) {
                        for (int k = j; k <= qLen + j; k++) {
                            if (matrix[i + qLen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= qLen + i; k++) {
                            if (matrix[k][j + qLen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            qLen++;
                        }
                    }
                    if (maxLen <= qLen) {
                        maxLen = qLen;
                    }
                }
            }
        }
        return maxLen * maxLen;
    }

}
