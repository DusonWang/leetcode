package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * 输出：9
 * 示例 2：
 * <p>
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-1-bordered-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Largest1BorderedSquare {

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] top = new int[m][n];
        int[][] left = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    top[i][j] = grid[i][j];
                } else {
                    top[i][j] = grid[i][j] == 0 ? 0 : top[i - 1][j] + 1;
                }

                if (j == 0) {
                    left[i][j] = grid[i][j];
                } else {
                    left[i][j] = grid[i][j] == 0 ? 0 : left[i][j - 1] + 1;
                }
                for (int l = Math.min(left[i][j], top[i][j]); l > 0; l--) {
                    if (left[i - l + 1][j] >= l && top[i][j - l + 1] >= l) {
                        max = Math.max(max, l * l);
                        break;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Largest1BorderedSquare largest1BorderedSquare = new Largest1BorderedSquare();
        int[][] grid = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        largest1BorderedSquare.largest1BorderedSquare(grid);
    }
}
