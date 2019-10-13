package com.leetcode.offer.day46;

/**
 * @author duson
 * 想象一下炸弹人游戏，在你面前有一个二维的网格来表示地图，网格中的格子分别被以下三种符号占据：
 * <p>
 * 'W' 表示一堵墙
 * 'E' 表示一个敌人
 * '0'（数字 0）表示一个空位
 * <p>
 * <p>
 * 请你计算一个炸弹最多能炸多少敌人。
 * <p>
 * 由于炸弹的威力不足以穿透墙体，炸弹只能炸到同一行和同一列没被墙体挡住的敌人。
 * <p>
 * 注意：你只能把炸弹放在一个空的格子里
 * <p>
 * 示例:
 * <p>
 * 输入: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * 输出: 3
 * 解释: 对于如下网格
 * <p>
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * <p>
 * 假如在位置 (1,1) 放置炸弹的话，可以炸到 3 个敌人
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bomb-enemy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxKilledEnemies {

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 ||
                grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        int rows = 0;
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rows = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            rows += 1;
                        }
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    cols[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            cols[j] += 1;
                        }
                    }
                }
                if (grid[i][j] == '0' && rows + cols[j] > res) {
                    res = rows + cols[j];
                }
            }
        }
        return res;
    }
}
