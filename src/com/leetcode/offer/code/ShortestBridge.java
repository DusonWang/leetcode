package com.leetcode.offer.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duson
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * <p>
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 * <p>
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 或 A[i][j] == 1
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-bridge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestBridge {

    public int shortestBridge(int[][] a) {
        int m = a.length, n = a[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        // 1. dfs to find an island, mark it in `visited`
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    dfs(a, visited, q, i, j, dirs);
                    found = true;
                    break;
                }
            }
        }
        // 2. bfs to expand this island
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
                        if (a[i][j] == 1) {
                            return step;
                        }
                        q.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] a, boolean[][] visited, Queue<int[]> q, int i, int j, int[][] dirs) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || visited[i][j] || a[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(a, visited, q, i + dir[0], j + dir[1], dirs);
        }
    }
}
