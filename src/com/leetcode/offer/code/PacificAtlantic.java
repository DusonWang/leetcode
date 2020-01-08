package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * <p>
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * <p>
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *  
 * <p>
 * 示例：
 * <p>
 *  
 * <p>
 * 给定下面的 5x5 矩阵:
 * <p>
 * 太平洋 ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * 大西洋
 * <p>
 * 返回:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] buffer1 = new boolean[m][n];
        boolean[][] buffer2 = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            buffer1[i][0] = true;
            traverse(matrix, buffer1, i, 0);
        }
        for (int j = 0; j < n; ++j) {
            buffer1[0][j] = true;
            traverse(matrix, buffer1, 0, j);
        }
        for (int i = 0; i < m; ++i) {
            buffer2[i][n - 1] = true;
            traverse(matrix, buffer2, i, n - 1);
        }
        for (int j = 0; j < n; ++j) {
            buffer2[m - 1][j] = true;
            traverse(matrix, buffer2, m - 1, j);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (buffer1[i][j] && buffer2[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void traverse(int[][] matrix, boolean[][] buffer, int i, int j) {
        if (i > 0 && !buffer[i - 1][j] && matrix[i - 1][j] >= matrix[i][j]) {
            buffer[i - 1][j] = true;
            traverse(matrix, buffer, i - 1, j);
        }
        if (j > 0 && !buffer[i][j - 1] && matrix[i][j - 1] >= matrix[i][j]) {
            buffer[i][j - 1] = true;
            traverse(matrix, buffer, i, j - 1);
        }
        if (i < matrix.length - 1 && !buffer[i + 1][j] && matrix[i + 1][j] >= matrix[i][j]) {
            buffer[i + 1][j] = true;
            traverse(matrix, buffer, i + 1, j);
        }
        if (j < matrix[0].length - 1 && !buffer[i][j + 1] && matrix[i][j + 1] >= matrix[i][j]) {
            buffer[i][j + 1] = true;
            traverse(matrix, buffer, i, j + 1);
        }
    }
}
