package code.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个大小为m x n的整数矩阵isWater，它代表了一个由 陆地和 水域单元格组成的地图。
 * <p>
 * 如果isWater[i][j] == 0，格子(i, j)是一个 陆地格子。
 * 如果isWater[i][j] == 1，格子(i, j)是一个 水域格子。
 * 你需要按照如下规则给每个单元格安排高度：
 * <p>
 * 每个格子的高度都必须是非负的。
 * 如果一个格子是是 水域，那么它的高度必须为 0。
 * 任意相邻的格子高度差 至多为 1。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
 * 找到一种安排高度的方案，使得矩阵中的最高高度值最大。
 * <p>
 * 请你返回一个大小为m x n的整数矩阵 height，其中 height[i][j]是格子 (i, j)的高度。如果有多种解法，请返回任意一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：isWater = [[0,1],[0,0]]
 * 输出：[[1,0],[2,1]]
 * 解释：上图展示了给各个格子安排的高度。
 * 蓝色格子是水域格，绿色格子是陆地格。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * 输出：[[1,1,0],[0,1,1],[1,2,2]]
 * 解释：所有安排方案中，最高可行高度为 2 。
 * 任意安排方案中，只要最高高度为 2 且符合上述规则的，都为可行方案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == isWater.length
 * n == isWater[i].length
 * 1 <= m, n <= 1000
 * isWater[i][j]要么是0，要么是1。
 * 至少有 1个水域格子。
 * 通过次数3,111提交次数5,464
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-of-highest-peak
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HighestPeak {

    private final int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] highestPeak(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visi = new boolean[row][col];
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.remove();
            ans[node[0]][node[1]] = node[2];
            for (int[] d : dir) {
                int x = node[0] + d[0];
                int y = node[1] + d[1];
                if (x >= 0 && x < row && y >= 0 && y < col && !visi[x][y] && mat[x][y] == 0) {
                    queue.add(new int[]{x, y, node[2] + 1});
                    visi[x][y] = true;
                }
            }
        }
        return ans;
    }
}
