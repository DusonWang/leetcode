package code.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duson
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * <p>
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * <p>
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,1],[1,0]]
 * <p>
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 * <p>
 * 输出：4
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * 通过次数4,356提交次数14,491
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestPathBinaryMatrix {

    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pop = queue.remove();
                if (pop[0] == m - 1 && pop[1] == n - 1) {
                    return ans + 1;
                }
                for (int k = 0; k < 8; k++) {
                    int nextX = dir[k][0] + pop[0];
                    int nextY = dir[k][1] + pop[1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                            && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
