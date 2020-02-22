package com.leetcode.offer.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author duson
 * 给定一个非空01二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。
 * <p>
 * 请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。
 * <p>
 *  
 * <p>
 * 样例 1:
 * <p>
 * 11000
 * 11000
 * 00011
 * 00011
 * 给定上图，返回结果 1。
 * <p>
 *  
 * <p>
 * 样例 2:
 * <p>
 * 11011
 * 10000
 * 00001
 * 11011
 * 给定上图，返回结果 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">3</font>。
 * <p>
 * 注意:
 * <p>
 * 11
 * 1
 * 和
 * <p>
 * 1
 * 11
 * 是不同的岛屿，因为我们不考虑旋转、翻转操作。
 * <p>
 *  
 * <p>
 * 注释 :  二维数组每维的大小都不会超过50。
 * <p>
 * 通过次数884提交次数1,955
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-distinct-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDistinctIslands {

    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, sb);
                set.add(sb.toString());
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j, sb.append("d"));
        dfs(grid, i, j + 1, sb.append("r"));
        dfs(grid, i - 1, j, sb.append("u"));
        dfs(grid, i, j - 1, sb.append("l"));
    }
}
