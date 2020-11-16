package code.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * <p>
 * 有一队人（两人或以上）想要在一个地方碰面，他们希望能够最小化他们的总行走距离。
 * <p>
 * 给你一个 2D 网格，其中各个格子内的值要么是 0，要么是 1。
 * <p>
 * 1 表示某个人的家所处的位置。这里，我们将使用 曼哈顿距离 来计算，其中 distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * 输出: 6
 * <p>
 * 解析: 给定的三个人分别住在(0,0)，(0,4) 和 (2,2):
 *      (0,2) 是一个最佳的碰面点，其总行走距离为 2 + 2 + 2 = 6，最小，因此返回 6。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-meeting-point
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinTotalDistance {

    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        int row = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int col = cols.get(cols.size() / 2);
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }

    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for (int point : points) {
            distance += Math.abs(point - origin);
        }
        return distance;
    }
}
