package com.leetcode.offer.day46;

/**
 * @author duson
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 * <p>
 * 示例:
 * <p>
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 说明：
 * <p>
 * 矩阵内的矩形区域面积必须大于 0。
 * 如果行数远大于列数，你将如何解答呢？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumSubmatrix {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null
                || matrix.length == 0
                || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i - 1][j - 1] - sum[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                for (int h = 0; i + h <= row; h++) {
                    for (int w = 0; j + w <= col; w++) {
                        int area = sum[i + h][j + w] - sum[i - 1][j + w] - sum[i + h][j - 1] + sum[i - 1][j - 1];
                        if (area > max && area <= k) {
                            max = area;
                        }
                    }
                }
            }
        }
        return max;
    }
}
