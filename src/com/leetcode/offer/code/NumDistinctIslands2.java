package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 给定一个非空01二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。
 * <p>
 * 请你计算这个网格中共有多少个形状不同的岛屿。如果两个岛屿的形状相同，或者通过旋转（顺时针旋转 90°，180°，270°）、翻转（左右翻转、上下翻转）后形状相同，那么就认为这两个岛屿是相同的。
 * <p>
 *  
 * <p>
 * 样例 1:
 * <p>
 * 11000
 * 10000
 * 00001
 * 00011
 * 给定上图，返回结果 1。
 * <p>
 * 注意 ：
 * <p>
 * 11
 * 1
 * 和
 * <p>
 * 1
 * 11
 * 是相同的岛屿。因为我们通过 180° 旋转第一个岛屿，两个岛屿的形状相同。
 * <p>
 *  
 * <p>
 * 样例 2:
 * <p>
 * 11100
 * 10001
 * 01001
 * 01110
 * 给定上图，返回结果 2。
 * <p>
 * 下面是两个不同的岛屿：
 * <p>
 * 111
 * 1
 * 和
 * <p>
 * 1
 * 1
 *  
 * <p>
 * 注意 ：
 * <p>
 * 111
 * 1
 * 和
 * <p>
 * 1
 * 111
 * 相同的岛屿。因为我们通过上下翻转第一个岛屿，两个岛屿的形状相同。
 * <p>
 *  
 * <p>
 * 注释 :  二维数组每维的大小都不会超过50。
 * <p>
 * 通过次数231提交次数426
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-distinct-islands-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDistinctIslands2 {

    private boolean[][] mVisited;

    private int[][] mGrid;

    public int numDistinctIslands2(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0].length == 0) {
            return 0;
        }
        mGrid = grid;
        mVisited = new boolean[grid.length][grid[0].length];
        Set<String> islands = new HashSet<>(0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                List<Integer> island = new ArrayList<>(0);
                dfs(i, j, island);
                if (!island.isEmpty()) {
                    String islandStr = islandToString(island);
                    System.out.println(islandStr);
                    islands.add(islandStr);
                }
            }
        }
        return islands.size();
    }

    private void dfs(int row, int col, List<Integer> island) {
        if (row < 0 || row >= mVisited.length) {
            return;
        }
        if (col < 0 || col >= mVisited[0].length) {
            return;
        }
        if (mVisited[row][col] || mGrid[row][col] == 0) {
            return;
        }
        mVisited[row][col] = true;
        island.add(row * mGrid[0].length + col);
        dfs(row - 1, col, island);
        dfs(row + 1, col, island);
        dfs(row, col - 1, island);
        dfs(row, col + 1, island);
    }

    private String islandToString(List<Integer> island) {
        int[][] rows = new int[8][island.size()];
        int[][] cols = new int[8][island.size()];
        for (int i = 0; i < island.size(); i++) {
            int point = island.get(i);
            int x = point / mGrid[0].length;
            int y = point % mGrid[0].length;
            rows[0][i] = x;
            cols[0][i] = y;
            rows[1][i] = x;
            cols[1][i] = -y;
            rows[2][i] = -x;
            cols[2][i] = y;
            rows[3][i] = -x;
            cols[3][i] = -y;
            rows[4][i] = y;
            cols[4][i] = x;
            rows[5][i] = y;
            cols[5][i] = -x;
            rows[6][i] = -y;
            cols[6][i] = x;
            rows[7][i] = -y;
            cols[7][i] = -x;
        }
        String res = "";
        int[] out = new int[island.size()];
        for (int i = 0; i < 8; i++) {
            int minRow = rows[i][0];
            int minCol = cols[i][0];
            for (int j = 0; j < island.size(); j++) {
                minRow = Math.min(minRow, rows[i][j]);
                minCol = Math.min(minCol, cols[i][j]);
            }
            for (int j = 0; j < island.size(); j++) {
                out[j] = (rows[i][j] - minRow) * (mGrid[0].length + mGrid.length) + (cols[i][j] - minCol);
            }
            Arrays.sort(out);
            String tmp = Arrays.toString(out);
            System.out.println(tmp);
            if (res.compareTo(tmp) < 0) {
                res = tmp;
            }
        }
        return res;
    }
}
