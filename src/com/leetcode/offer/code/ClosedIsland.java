package com.leetcode.offer.code;

/**
 * @author duson
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * <p>
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * <p>
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * <p>
 * 请返回封闭岛屿的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 *              [1,0,0,0,0,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,1,0,1,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * 通过次数3,160提交次数5,348
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-closed-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClosedIsland {

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int numIslands = 0;
        for (int i = 0; i < n; i++) {
            fn(grid, n, m, i, 0);
            fn(grid, n, m, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            fn(grid, n, m, 0, j);
            fn(grid, n, m, n - 1, j);
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0) {
                    numIslands++;
                    fn(grid, n, m, i, j);
                }
            }
        }
        return numIslands;
    }


    public void fn(int[][] grid, int n, int m, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 0) {
            return;
        }
        grid[i][j] = 1;
        fn(grid, n, m, i + 1, j);
        fn(grid, n, m, i, j + 1);
        fn(grid, n, m, i - 1, j);
        fn(grid, n, m, i, j - 1);
    }
}
