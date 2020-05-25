package com.leetcode.offer.code;

/**
 * 我们有一组包含1和0的网格；其中1表示砖块。?当且仅当一块砖直接连接到网格的顶部，或者它至少有一块相邻（4?个方向之一）砖块不会掉落时，它才不会落下。
 * <p>
 * 我们会依次消除一些砖块。每当我们消除?(i, j) 位置时， 对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这个消除而落下。
 * <p>
 * 返回一个数组表示每次消除操作对应落下的砖块数目。
 * <p>
 * 示例 1：
 * 输入：
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * 输出: [2]
 * 解释:
 * 如果我们消除(1, 0)位置的砖块, 在(1, 1) 和(1, 2) 的砖块会落下。所以我们应该返回2。
 * 示例 2：
 * 输入：
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * 输出：[0,0]
 * 解释：
 * 当我们消除(1, 0)的砖块时，(1, 1)的砖块已经由于上一步消除而消失了。所以每次消除操作不会造成砖块落下。注意(1, 0)砖块不会记作落下的砖块。
 * 注意:
 * <p>
 * 网格的行数和列数的范围是[1, 200]。
 * 消除的数字不会超过网格的区域。
 * 可以保证每次的消除都不相同，并且位于网格的内部。
 * 一个消除的位置可能没有砖块，如果这样的话，就不会有砖块落下。
 * 通过次数781提交次数3,134
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bricks-falling-when-hit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author duson
 */
public class HitBricks {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = -1;
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            connect(grid, 0, j);
        }
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int row = hits[i][0];
            int col = hits[i][1];
            if (grid[row][col] == -1) {
                grid[row][col] = 1;
                if (connectedToTop(grid, row, col)) {
                    res[i] = connect(grid, row, col) - 1;
                }
            }
        }
        return res;
    }

    private boolean connectedToTop(int[][] grid, int i, int j) {
        if (i == 0) {
            return true;
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 2) {
            return true;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 2) {
            return true;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 2) {
            return true;
        }
        return j + 1 < grid[0].length && grid[i][j + 1] == 2;
    }

    private int connect(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        int res = 1;
        res += connect(grid, i - 1, j);
        res += connect(grid, i + 1, j);
        res += connect(grid, i, j + 1);
        res += connect(grid, i, j - 1);
        return res;
    }
}
