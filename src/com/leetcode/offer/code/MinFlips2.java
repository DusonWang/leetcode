package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个 m x n 的二进制矩阵 mat。
 * <p>
 * 每一步，你可以选择一个单元格并将它反转（反转表示 0 变 1 ，1 变 0 ）。如果存在和它相邻的单元格，那么这些相邻的单元格也会被反转。（注：相邻的两个单元格共享同一条边。）
 * <p>
 * 请你返回将矩阵 mat 转化为全零矩阵的最少反转次数，如果无法转化为全零矩阵，请返回 -1 。
 * <p>
 * 二进制矩阵的每一个格子要么是 0 要么是 1 。
 * <p>
 * 全零矩阵是所有格子都为 0 的矩阵。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[0,0],[0,1]]
 * 输出：3
 * 解释：一个可能的解是反转 (1, 0)，然后 (0, 1) ，最后是 (1, 1) 。
 * 示例 2：
 * <p>
 * 输入：mat = [[0]]
 * 输出：0
 * 解释：给出的矩阵是全零矩阵，所以你不需要改变它。
 * 示例 3：
 * <p>
 * 输入：mat = [[1,1,1],[1,0,1],[0,0,0]]
 * 输出：6
 * 示例 4：
 * <p>
 * 输入：mat = [[1,0,0],[1,0,0]]
 * 输出：-1
 * 解释：该矩阵无法转变成全零矩阵
 *  
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[0].length
 * 1 <= m <= 3
 * 1 <= n <= 3
 * mat[i][j] 是 0 或 1 。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinFlips2 {

    public int minFlips(int[][] mat) {
        return search(0, mat.length, mat[0].length, 0, mat);
    }

    private int search(int index, int n, int m, int count, int[][] mat) {
        if (check(n, m, mat)) {
            return count;
        }
        if (index == n * m) {
            return -1;
        }
        int tmp = search(index + 1, n, m, count, mat);
        int i = index / m;
        int j = index % m;
        flip(i, j, n, m, mat);
        int tmp2 = search(index + 1, n, m, count + 1, mat);
        flip(i, j, n, m, mat);
        if (tmp == -1) {
            return tmp2;
        } else if (tmp2 == -1) {
            return tmp;
        } else {
            return Math.min(tmp, tmp2);
        }
    }

    private void flip(int i, int j, int n, int m, int[][] mat) {
        mat[i][j] = 1 - mat[i][j];
        if (i != 0) {
            mat[i - 1][j] = 1 - mat[i - 1][j];
        }
        if (i != n - 1) {
            mat[i + 1][j] = 1 - mat[i + 1][j];
        }
        if (j != 0) {
            mat[i][j - 1] = 1 - mat[i][j - 1];
        }
        if (j != m - 1) {
            mat[i][j + 1] = 1 - mat[i][j + 1];
        }
    }

    private boolean check(int n, int m, int[][] mat) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
