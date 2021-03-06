package code.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 你准备参加一场远足活动。给你一个二维?rows x columns?的地图?heights?，其中?heights[row][col]?表示格子?(row, col)?的高度。一开始你在最左上角的格子?(0, 0)?，且你希望去最右下角的格子?(rows-1, columns-1)?（注意下标从 0 开始编号）。你每次可以往 上，下，左，右?四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值?是路径上相邻格子之间 高度差绝对值?的 最大值?决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小?体力消耗值?。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 * <p>
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * ?
 * <p>
 * 提示：
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * 通过次数22,508提交次数45,641
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumEffortPath {

    private int[][] heights;
    private int m;
    private int n;
    private boolean[][] visited;

    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        int left = 0;
        int right = 1000000;
        while (left < right) {
            int middle = (left + right) >>> 1;
            visited = new boolean[m][n];
            if (hasPath(0, 0, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private boolean hasPath(int i, int j, int cost) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;
        if (i + 1 < m && !visited[i + 1][j] && Math.abs(heights[i][j] - heights[i + 1][j]) <= cost && hasPath(i + 1, j, cost)) {
            return true;
        }
        if (j + 1 < n && !visited[i][j + 1] && Math.abs(heights[i][j] - heights[i][j + 1]) <= cost && hasPath(i, j + 1, cost)) {
            return true;
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && Math.abs(heights[i][j] - heights[i - 1][j]) <= cost && hasPath(i - 1, j, cost)) {
            return true;
        }
        return j - 1 >= 0 && !visited[i][j - 1] && Math.abs(heights[i][j] - heights[i][j - 1]) <= cost && hasPath(i, j - 1, cost);
    }
}
