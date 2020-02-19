package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: m = 2, n = 2, N = 2, i = 0, j = 0
 * 输出: 6
 * 解释:
 * <p>
 * 示例 2：
 * <p>
 * 输入: m = 1, n = 3, N = 3, i = 0, j = 1
 * 输出: 12
 * 解释:
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 球一旦出界，就不能再被移动回网格内。
 * 网格的长度和高度在 [1,50] 的范围内。
 * N 在 [0,50] 的范围内。
 * 通过次数2,318提交次数6,534
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPaths2 {

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) {
            return 0;
        }
        final int mod = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % mod;
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % mod;
                        }
                    }
                }
            }
            count = temp;
        }
        return result;
    }
}
