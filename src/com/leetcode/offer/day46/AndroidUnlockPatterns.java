package com.leetcode.offer.day46;

/**
 * @author duson
 * 我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。
 * <p>
 * 给你两个整数，分别为 ​​m 和 n，其中 1 ≤ m ≤ n ≤ 9，那么请你统计一下有多少种解锁手势，是至少需要经过 m 个点，但是最多经过不超过 n 个点的。
 * <p>
 *  
 * <p>
 * 先来了解下什么是一个有效的安卓解锁手势:
 * <p>
 * 每一个解锁手势必须至少经过 m 个点、最多经过 n 个点。
 * 解锁手势里不能设置经过重复的点。
 * 假如手势中有两个点是顺序经过的，那么这两个点的手势轨迹之间是绝对不能跨过任何未被经过的点。
 * 经过点的顺序不同则表示为不同的解锁手势。
 *  
 * <p>
 * <p>
 *  
 * <p>
 * 解释:
 * <p>
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * 无效手势：4 - 1 - 3 - 6
 * 连接点 1 和点 3 时经过了未被连接过的 2 号点。
 * <p>
 * 无效手势：4 - 1 - 9 - 2
 * 连接点 1 和点 9 时经过了未被连接过的 5 号点。
 * <p>
 * 有效手势：2 - 4 - 1 - 3 - 6
 * 连接点 1 和点 3 是有效的，因为虽然它经过了点 2 ，但是点 2 在该手势中之前已经被连过了。
 * <p>
 * 有效手势：6 - 5 - 4 - 1 - 9 - 2
 * 连接点 1 和点 9 是有效的，因为虽然它经过了按键 5 ，但是点 5 在该手势中之前已经被连过了。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: m = 1，n = 1
 * 输出: 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/android-unlock-patterns
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AndroidUnlockPatterns {

    public int numberOfPatterns(int m, int n) {
        int count = 0;
        boolean[][] visited = new boolean[3][3];
        count += dfs(m, n, 0, 0, 1, visited) * 4;
        count += dfs(m, n, 0, 1, 1, visited) * 4;
        count += dfs(m, n, 1, 1, 1, visited);
        return count;
    }

    private int dfs(int m, int n, int x, int y, int depth, boolean[][] visited) {
        int count = 0;
        if (depth == n) {
            count++;
            return count;
        }
        if (depth >= m) {
            count++;
        }
        visited[x][y] = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!visited[i][j]) {
                    if (Math.abs(i - x) != 1 && Math.abs(j - y) != 1 && !visited[(i + x) / 2][(j + y) / 2]) {
                        continue;
                    }
                    count += dfs(m, n, i, j, depth + 1, visited);
                }
            }
        }
        visited[x][y] = false;
        return count;
    }
}
