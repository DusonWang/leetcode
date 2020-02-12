package com.leetcode.offer.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 由空地和墙组成的迷宫中有一个球。球可以向上（u）下（d）左（l）右（r）四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。迷宫中还有一个洞，当球运动经过洞时，就会掉进洞里。
 * <p>
 * 给定球的起始位置，目的地和迷宫，找出让球以最短距离掉进洞里的路径。 距离的定义是球从起始位置（不包括）到目的地（包括）经过的空地个数。通过'u', 'd', 'l' 和 'r'输出球的移动方向。 由于可能有多条最短路径， 请输出字典序最小的路径。如果球无法进入洞，输出"impossible"。
 * <p>
 * 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
 * <p>
 *  
 * <p>
 * 示例1:
 * <p>
 * 输入 1: 迷宫由以下二维数组表示
 * <p>
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 0 0 0 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 * <p>
 * 输入 2: 球的初始位置 (rowBall, colBall) = (4, 3)
 * 输入 3: 洞的位置 (rowHole, colHole) = (0, 1)
 * <p>
 * 输出: "lul"
 * <p>
 * 解析: 有两条让球进洞的最短路径。
 * 第一条路径是 左 -> 上 -> 左, 记为 "lul".
 * 第二条路径是 上 -> 左, 记为 'ul'.
 * 两条路径都具有最短距离6, 但'l' < 'u'，故第一条路径字典序更小。因此输出"lul"。
 * <p>
 * 示例 2:
 * <p>
 * 输入 1: 迷宫由以下二维数组表示
 * <p>
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 0 0 0 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 * <p>
 * 输入 2: 球的初始位置 (rowBall, colBall) = (4, 3)
 * 输入 3: 洞的位置 (rowHole, colHole) = (3, 0)
 * <p>
 * 输出: "impossible"
 * <p>
 * 示例: 球无法到达洞。
 * <p>
 *  
 * <p>
 * 注意:
 * <p>
 * 迷宫中只有一个球和一个目的地。
 * 球和洞都在空地上，且初始时它们不在同一位置。
 * 给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。
 * 迷宫至少包括2块空地，行数和列数均不超过30。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-maze-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindShortestWay {

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length;
        int m = maze[0].length;
        String[][] way = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                way[i][j] = "";
            }
        }
        int[][] dp = new int[n][m];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        String[] dircectStr = new String[]{"u", "d", "l", "r"};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(ball);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int direction = 0; direction < 4; direction++) {
                int nx = cur[0], ny = cur[1];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 0) {
                    if (nx == hole[0] && ny == hole[1]) {
                        nx += dx[direction];
                        ny += dy[direction];
                        break;
                    }
                    nx += dx[direction];
                    ny += dy[direction];
                }
                nx -= dx[direction];
                ny -= dy[direction];
                int steps = dp[cur[0]][cur[1]] + Math.abs(nx - cur[0]) + Math.abs(ny - cur[1]);
                if (!(nx == cur[0] && ny == cur[1]) && (dp[nx][ny] == 0 || (dp[nx][ny] > steps || (dp[nx][ny] == steps && (way[cur[0]][cur[1]] + dircectStr[direction]).compareTo(way[nx][ny]) < 0)))) {
                    dp[nx][ny] = steps;
                    way[nx][ny] = way[cur[0]][cur[1]] + dircectStr[direction];
                    if (!(nx == hole[0] && ny == hole[1])) {
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return "".equals(way[hole[0]][hole[1]]) ? "impossible" : way[hole[0]][hole[1]];
    }
}
