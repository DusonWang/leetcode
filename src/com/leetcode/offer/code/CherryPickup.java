package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
 * <p>
 * 0 表示这个格子是空的，所以你可以穿过它。
 * 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 * -1 表示这个格子里有荆棘，挡着你的路。
 * 你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
 * <p>
 * 从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
 * 当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
 * 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
 * 如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
 * 示例 1:
 * <p>
 * 输入: grid =
 * [[0, 1, -1],
 * [1, 0, -1],
 * [1, 1,  1]]
 * 输出: 5
 * 解释：
 * 玩家从（0,0）点出发，经过了向下走，向下走，向右走，向右走，到达了点(2, 2)。
 * 在这趟单程中，总共摘到了4颗樱桃，矩阵变成了[[0,1,-1],[0,0,-1],[0,0,0]]。
 * 接着，这名玩家向左走，向上走，向上走，向左走，返回了起始点，又摘到了1颗樱桃。
 * 在旅程中，总共摘到了5颗樱桃，这是可以摘到的最大值了。
 * 说明:
 * <p>
 * grid 是一个 N * N 的二维数组，N的取值范围是1 <= N <= 50。
 * 每一个 grid[i][j] 都是集合 {-1, 0, 1}其中的一个数。
 * 可以保证起点 grid[0][0] 和终点 grid[N-1][N-1] 的值都不会是 -1。
 * 通过次数1,059提交次数3,544
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cherry-pickup
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CherryPickup {

    private int[][][] dp;
    private int n;

    public int cherryPickup(int[][] grid) {
        if (grid.length == 1) {
            return grid[0][0];
        }
        n = grid.length;
        dp = new int[n][n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dpDfs(grid, 0, 0, 0));
    }

    private int dpDfs(int[][] g, int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (r1 < r2 || r1 > n - 1 || c2 > n - 1 || g[r1][c1] == -1 || g[r2][c2] == -1) {
            return -9999;
        }
        if (r1 == r2 && r1 == n - 1 && c1 == n - 1) {
            return g[r1][c1];
        }
        if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
            return dp[r1][c1][c2];
        }
        int cur = r1 == r2 ? g[r1][c1] : g[r1][c1] + g[r2][c2];
        int ret = cur + Math.max(
                Math.max(dpDfs(g, r1 + 1, c1, c2), dpDfs(g, r1 + 1, c1, c2 + 1)),
                Math.max(dpDfs(g, r1, c1 + 1, c2), dpDfs(g, r1, c1 + 1, c2 + 1)));
        dp[r1][c1][c2] = ret;
        return ret;
    }

    /**
     * 给你一个 rows x cols 的矩阵 grid 来表示一块樱桃地。 grid 中每个格子的数字表示你能获得的樱桃数目。
     * <p>
     * 你有两个机器人帮你收集樱桃，机器人 1 从左上角格子 (0,0) 出发，机器人 2 从右上角格子 (0, cols-1) 出发。
     * <p>
     * 请你按照如下规则，返回两个机器人能收集的最多樱桃数目：
     * <p>
     * 从格子 (i,j) 出发，机器人可以移动到格子 (i+1, j-1)，(i+1, j) 或者 (i+1, j+1) 。
     * 当一个机器人经过某个格子时，它会把该格子内所有的樱桃都摘走，然后这个位置会变成空格子，即没有樱桃的格子。
     * 当两个机器人同时到达同一个格子时，它们中只有一个可以摘到樱桃。
     * 两个机器人在任意时刻都不能移动到 grid 外面。
     * 两个机器人最后都要到达 grid 最底下一行。
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
     * 输出：24
     * 解释：机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
     * 机器人 1 摘的樱桃数目为 (3 + 2 + 5 + 2) = 12 。
     * 机器人 2 摘的樱桃数目为 (1 + 5 + 5 + 1) = 12 。
     * 樱桃总数为： 12 + 12 = 24 。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
     * 输出：28
     * 解释：机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
     * 机器人 1 摘的樱桃数目为 (1 + 9 + 5 + 2) = 17 。
     * 机器人 2 摘的樱桃数目为 (1 + 3 + 4 + 3) = 11 。
     * 樱桃总数为： 17 + 11 = 28 。
     * 示例 3：
     * <p>
     * 输入：grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
     * 输出：22
     * 示例 4：
     * <p>
     * 输入：grid = [[1,1],[1,1]]
     * 输出：4
     *  
     * <p>
     * 提示：
     * <p>
     * rows == grid.length
     * cols == grid[i].length
     * 2 <= rows, cols <= 70
     * 0 <= grid[i][j] <= 100 
     * 通过次数869提交次数1,638
     * 在真实的面试中遇到过这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cherry-pickup-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int cherryPickup2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];
        return dfs(grid, m, n, 0, 0, n - 1, dp);
    }

    private int dfs(int[][] grid, int m, int n, int r, int c1, int c2, Integer[][][] dp) {
        if (r == m) {
            return 0;
        }
        if (dp[r][c1][c2] != null) {
            return dp[r][c1][c2];
        }
        int ans = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nc1 = c1 + i, nc2 = c2 + j;
                if (nc1 >= 0 && nc1 < n && nc2 >= 0 && nc2 < n) {
                    ans = Math.max(ans, dfs(grid, m, n, r + 1, nc1, nc2, dp));
                }
            }
        }
        int cherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        return dp[r][c1][c2] = ans + cherries;
    }
}
