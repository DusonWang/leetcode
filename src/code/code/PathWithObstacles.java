package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 * <p>
 * 示例?1:
 * <p>
 * 输入:
 * [
 * ? [0,0,0],
 * ? [0,1,0],
 * ? [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r?和 c 的值均不超过 100。
 * <p>
 * 通过次数2,616提交次数7,748
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathWithObstacles {

    private int m;
    private int n;
    private int[][] grid;

    private boolean dfs(int row, int col, boolean[][] visited, List<List<Integer>> pathList) {
        if (row >= m || col >= n || grid[row][col] == 1 || visited[row][col]) {
            return false;
        }

        pathList.add(Arrays.asList(row, col));
        if (row == m - 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;

        if (dfs(row + 1, col, visited, pathList) || dfs(row, col + 1, visited, pathList)) {
            return true;
        }

        pathList.remove(pathList.size() - 1);
        return false;
    }

    public List<List<Integer>> pathWithObstacles(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        List<List<Integer>> ansList = new ArrayList<>();
        dfs(0, 0, new boolean[m][n], ansList);
        return ansList;
    }
}
