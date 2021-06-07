package code.code;

/**
 * 给出一个二维整数网格grid，网格中的每个值表示该位置处的网格块的颜色。
 * <p>
 * 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
 * <p>
 * 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 * <p>
 * 给出位于(r0, c0)的网格块和颜色color，使用指定颜色color为所给网格块的连通分量的边界进行着色，并返回最终的网格grid 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * 输出：[[3, 3], [3, 2]]
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * 输出：[[1, 3, 3], [2, 3, 3]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * 输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 * <p>
 * <p>
 * 通过次数3,719提交次数8,689
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coloring-a-border
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ColorBorder {

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid == null || grid.length == 0) {
            return grid;
        }
        int oldColor = grid[r0][c0];
        dfs(grid, r0, c0, oldColor);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, int i, int j, int oldColor) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != oldColor) {
            return;
        }
        grid[i][j] = -oldColor;
        dfs(grid, i + 1, j, oldColor);
        dfs(grid, i - 1, j, oldColor);
        dfs(grid, i, j + 1, oldColor);
        dfs(grid, i, j - 1, oldColor);
        if (i > 0 && j > 0
                && i < grid.length - 1
                && j < grid[0].length - 1
                && oldColor == Math.abs(grid[i + 1][j])
                && oldColor == Math.abs(grid[i - 1][j])
                && oldColor == Math.abs(grid[i][j + 1])
                && oldColor == Math.abs(grid[i][j - 1])) {
            grid[i][j] = oldColor;
        }
    }

}
