package code.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duson
 * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
 * <p>
 * 1 表示连接左单元格和右单元格的街道。
 * 2 表示连接上单元格和下单元格的街道。
 * 3?表示连接左单元格和下单元格的街道。
 * 4 表示连接右单元格和下单元格的街道。
 * 5 表示连接左单元格和上单元格的街道。
 * 6 表示连接右单元格和上单元格的街道。
 * <p>
 * <p>
 * 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
 * <p>
 * 注意：你 不能 变更街道。
 * <p>
 * 如果网格中存在有效的路径，则返回 true，否则返回 false 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[2,4,3],[6,5,2]]
 * 输出：true
 * 解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,1],[1,2,1]]
 * 输出：false
 * 解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,2]]
 * 输出：false
 * 解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
 * 示例 4：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,3]]
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
 * 输出：true
 * ?
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * 1 <= grid[i][j] <= 6
 * 通过次数2,969提交次数7,675
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasValidPath {

    private final int[][] dirs = {{0, 1, 1, 3, 5}, {1, 0, 2, 5, 6}, {0, -1, 1, 4, 6}, {-1, 0, 2, 3, 4}};
    private final int[][] cs = {{}, {0, 2}, {1, 3}, {1, 2}, {0, 1}, {2, 3}, {0, 3}};

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] reach = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return true;
            }
            int[] rds = cs[grid[cur[0]][cur[1]]];
            for (int rd : rds) {
                int[] d = dirs[rd];
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x >= m || x < 0 || y >= n || y < 0 || reach[x][y]) {
                    continue;
                }
                if (grid[x][y] == d[2] || grid[x][y] == d[3] || grid[x][y] == d[4]) {
                    queue.add(new int[]{x, y, 1});
                    reach[x][y] = true;
                }
            }
        }
        return false;
    }
}
