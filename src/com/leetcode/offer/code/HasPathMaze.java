package com.leetcode.offer.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。
 * <p>
 * 给定球的起始位置，目的地和迷宫，判断球能否在目的地停下。
 * <p>
 * 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入 1: 迷宫由以下二维数组表示
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * 输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
 * 输入 3: 目的地坐标 (rowDest, colDest) = (4, 4)
 * <p>
 * 输出: true
 * <p>
 * 解析: 一个可能的路径是 : 左 -> 下 -> 左 -> 下 -> 右 -> 下 -> 右。
 * <p>
 * 示例 2:
 * <p>
 * 输入 1: 迷宫由以下二维数组表示
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * 输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
 * 输入 3: 目的地坐标 (rowDest, colDest) = (3, 2)
 * <p>
 * 输出: false
 * <p>
 * 解析: 没有能够使球停在目的地的路径。
 * <p>
 *  
 * <p>
 * 注意:
 * <p>
 * 迷宫中只有一个球和一个目的地。
 * 球和目的地都在空地上，且初始时它们不在同一位置。
 * 给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。
 * 迷宫至少包括2块空地，行数和列数均不超过100。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-maze
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasPathMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}
