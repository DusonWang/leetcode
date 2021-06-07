package code.code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。
 * <p>
 * 游戏地图用大小为 n * m 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。
 * <p>
 * 现在你将作为玩家参与游戏，按规则将箱子'B'移动到目标位置'T' ：
 * <p>
 * 玩家用字符'S'表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
 * 地板用字符'.'表示，意味着可以自由行走。
 * 墙用字符'#'表示，意味着障碍物，不能通行。
 * 箱子仅有一个，用字符'B'表示。相应地，网格上有一个目标位置'T'。
 * 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
 * 玩家无法越过箱子。
 * 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回-1。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 * ["#",".",".","B",".","#"],
 * ["#",".","#","#",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * 输出：3
 * 解释：我们只需要返回推箱子的次数。
 * 示例 2：
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 * ["#",".",".","B",".","#"],
 * ["#","#","#","#",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 * ["#","T",".",".","#","#"],
 * ["#",".","#","B",".","#"],
 * ["#",".",".",".",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * 输出：5
 * 解释：向下、向左、向左、向上再向上。
 * 示例 4：
 * <p>
 * 输入：grid = [["#","#","#","#","#","#","#"],
 * ["#","S","#",".","B","T","#"],
 * ["#","#","#","#","#","#","#"]]
 * 输出：-1
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 20
 * 1 <= grid[i].length <= 20
 * grid 仅包含字符'.', '#', 'S' , 'T', 以及'B'。
 * grid中'S', 'B'和'T'各只能出现一个。
 * 通过次数2,670提交次数6,438
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-move-a-box-to-their-target-location hard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinPushBox {

    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int row;
    private int col;
    private char[][] grid;
    private boolean[][] searchSign;

    private boolean isReachable(int srcx, int srcy, int dstx, int dsty) {
        if (dstx < 0 || dstx >= row || dsty < 0 || dsty >= col || grid[dstx][dsty] == '#') {
            return false;
        }
        for (boolean[] line : searchSign) {
            Arrays.fill(line, false);
        }
        searchSign[srcx][srcy] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{srcx, srcy});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == dstx && cur[1] == dsty) {
                return true;
            }
            for (int[] dir : dirs) {
                int ni = cur[0] + dir[0];
                int nj = cur[1] + dir[1];
                if (ni < 0 || ni >= row || nj < 0 || nj >= col || searchSign[ni][nj] || grid[ni][nj] == '#' || grid[ni][nj] == 'B') {
                    continue;
                }
                searchSign[ni][nj] = true;
                queue.offer(new int[]{ni, nj});
            }
        }
        return false;
    }

    public int minPushBox(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        this.grid = grid;
        searchSign = new boolean[row][col];
        int[] starter = new int[4];
        int[] end = new int[2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'S') {
                    starter[2] = i;
                    starter[3] = j;
                } else if (grid[i][j] == 'B') {
                    starter[0] = i;
                    starter[1] = j;
                } else if (grid[i][j] == 'T') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(starter);
        boolean[][] visited = new boolean[row * col][row * col];
        visited[starter[0] * col + starter[1]][starter[2] * col + starter[3]] = true;
        int stride = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                count--;
                int[] cur = queue.poll();
                if (cur[0] == end[0] && cur[1] == end[1]) {
                    return stride;
                }
                grid[cur[0]][cur[1]] = 'B';
                grid[cur[2]][cur[3]] = 'S';
                for (int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if (ni < 0 || ni >= row || nj < 0 || nj >= col || visited[ni * col + nj][cur[0] * col + cur[1]] || grid[ni][nj] == '#') {
                        continue;
                    }
                    if (!isReachable(cur[2], cur[3], cur[0] - dir[0], cur[1] - dir[1])) {
                        continue;
                    }
                    visited[ni * col + nj][cur[0] * col + cur[1]] = true;
                    queue.offer(new int[]{ni, nj, cur[0], cur[1]});
                }
                grid[cur[0]][cur[1]] = '.';
                grid[cur[2]][cur[3]] = '.';
            }
            stride++;
        }
        return -1;
    }
}
