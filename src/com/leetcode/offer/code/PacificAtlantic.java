package com.leetcode.offer.code;

import java.util.ArrayList;
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

    private int row, col;
    private int[][] grid;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        row = matrix.length;
        if (row == 0) {
            return result;
        }
        col = matrix[0].length;
        grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            helper(matrix, i, 0, 1);
        }
        for (int j = 0; j < col; j++) {
            helper(matrix, 0, j, 1);
        }
        for (int i = 0; i < row; i++) {
            helper(matrix, i, col - 1, 2);
        }
        for (int j = 0; j < col; j++) {
            helper(matrix, row - 1, j, 2);
        }
        return result;
    }

    private void helper(int[][] matrix, int i, int j, int v) {
        if (grid[i][j] == v || grid[i][j] == 3) {
            return;
        }
        grid[i][j] += v;
        if (grid[i][j] == 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(j);
            result.add(temp);
        }
        if (i != 0 && matrix[i - 1][j] >= matrix[i][j]) {
            helper(matrix, i - 1, j, v);
        }
        if (j != 0 && matrix[i][j - 1] >= matrix[i][j]) {
            helper(matrix, i, j - 1, v);
        }
        if (i != row - 1 && matrix[i + 1][j] >= matrix[i][j]) {
            helper(matrix, i + 1, j, v);
        }
        if (j != col - 1 && matrix[i][j + 1] >= matrix[i][j]) {
            helper(matrix, i, j + 1, v);
        }
    }
}
