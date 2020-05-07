package com.leetcode.offer.code;

/**
 * @author duson
 * 给出一个二维数组?A，每个单元格为 0（代表海）或 1（代表陆地）。
 * <p>
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * <p>
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 * <p>
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * 所有行的大小都相同
 * 通过次数3,504提交次数6,895
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumEnclaves {

    public int numEnclaves(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            dfs(A, i, 0);
        }
        for (int j = 0; j < A[0].length; j++) {
            dfs(A, 0, j);
        }
        for (int i = 0; i < A.length; i++) {
            dfs(A, i, A[0].length - 1);
        }
        for (int j = 0; j < A[0].length; j++) {
            dfs(A, A.length - 1, j);
        }
        int result = 0;
        for (int[] ints : A) {
            for (int y : ints) {
                result += y;
            }
        }
        return result;
    }

    private void dfs(int[][] A, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length) {
            return;
        }
        if (A[i][j] == 0) {
            return;
        }
        A[i][j] = 0;
        dfs(A, i - 1, j);
        dfs(A, i + 1, j);
        dfs(A, i, j - 1);
        dfs(A, i, j + 1);
    }
}
