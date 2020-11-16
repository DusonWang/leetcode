package code.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duson
 * 你是个房地产开发商，想要选择一片空地 建一栋大楼。你想把这栋大楼够造在一个距离周边设施都比较方便的地方，通过调研，你希望从它出发能在 最短的距离和 内抵达周边全部的建筑物。请你计算出这个最佳的选址到周边全部建筑物的 最短距离和。
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 你只能通过向上、下、左、右四个方向上移动。
 * <p>
 * 给你一个由 0、1 和 2 组成的二维网格，其中：
 * <p>
 * 0 代表你可以自由通过和选择建造的空地
 * 1 代表你无非通行的建筑物
 * 2 代表你无非通行的障碍物
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * 输出: 7
 * <p>
 * 解析:
 * 给定三个建筑物 (0,0)、(0,4) 和 (2,2) 以及一个位于 (0,2) 的障碍物。
 * 由于总距离之和 3+3+1=7 最优，所以位置 (1,2) 是符合要求的最优地点，故返回7。
 * 注意：
 * 你会保证有至少一栋建筑物，如果无法按照上述规则返回建房地点，则请你返回 -1。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-from-all-buildings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestDistance2 {

    private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[][] d = new int[m][n];
        int[][] count = new int[m][n];
        int cnt = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                    boolean[][] visited = new boolean[m][n];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] v = queue.poll();
                        int x = v[0];
                        int y = v[1];
                        int dist = v[2];
                        d[x][y] += dist;
                        for (int[] dir : dirs) {
                            int x1 = x + dir[0];
                            int y1 = y + dir[1];
                            if (x1 < 0 || y1 < 0 || x1 >= m || y1 >= n || visited[x1][y1] || grid[x1][y1] != 0) {
                                continue;
                            }
                            queue.add(new int[]{x1, y1, dist + 1});
                            visited[x1][y1] = true;
                            count[x1][y1]++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == cnt) {
                    res = Math.min(res, d[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
