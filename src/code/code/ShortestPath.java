package code.code;

/**
 * @author duson
 * 给你一个?m * n?的网格，其中每个单元格不是?0（空）就是?1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
 * <p>
 * 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * grid =
 * [[0,0,0],
 * ?[1,1,0],
 * [0,0,0],
 * ?[0,1,1],
 * [0,0,0]],
 * k = 1
 * 输出：6
 * 解释：
 * 不消除任何障碍的最短路径是 10。
 * 消除位置 (3,2) 处的障碍后，最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * ?
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * grid =
 * [[0,1,1],
 * ?[1,1,1],
 * ?[1,0,0]],
 * k = 1
 * 输出：-1
 * 解释：
 * 我们至少需要消除两个障碍才能找到这样的路径。
 * ?
 * <p>
 * 提示：
 * <p>
 * grid.length?== m
 * grid[0].length?== n
 * 1 <= m, n <= 40
 * 1 <= k <= m*n
 * grid[i][j] == 0 or 1
 * grid[0][0] == grid[m-1][n-1] == 0
 * 通过次数4,618提交次数12,915
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestPath {

    private int res = Integer.MAX_VALUE;

    public int shortestPath(int[][] grid, int k) {
        dfs(grid, 0, 0, k, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int[][] grid, int x, int y, int k, int step) {
        if (k < 0) {
            return;
        }
        if (res == grid.length - 1 + grid[0].length - 1) {
            return;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            res = Math.min(res, step);
            return;
        }
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 2) {
            if (grid[x][y] == 1) {
                grid[x][y] = 2;
                dfs(grid, x + 1, y, k - 1, step + 1);
                dfs(grid, x, y + 1, k - 1, step + 1);
                dfs(grid, x - 1, y, k - 1, step + 1);
                dfs(grid, x, y - 1, k - 1, step + 1);
                grid[x][y] = 1;
            } else if (grid[x][y] == 0) {
                grid[x][y] = 2;
                dfs(grid, x + 1, y, k, step + 1);
                dfs(grid, x, y + 1, k, step + 1);
                dfs(grid, x - 1, y, k, step + 1);
                dfs(grid, x, y - 1, k, step + 1);
                grid[x][y] = 0;
            }
        }
    }
}
