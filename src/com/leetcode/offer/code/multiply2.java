package com.leetcode.offer.code;

/**
 * @author duson
 * 给定两个 稀疏矩阵 A 和 B，请你返回 AB。你可以默认 A 的列数等于 B 的行数。
 * <p>
 * 请仔细阅读下面的示例。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * A = [
 * [ 1, 0, 0],
 * [-1, 0, 3]
 * ]
 * <p>
 * B = [
 * [ 7, 0, 0 ],
 * [ 0, 0, 0 ],
 * [ 0, 0, 1 ]
 * ]
 * <p>
 * 输出:
 * <p>
 * |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 * | 0 0 1 |
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-matrix-multiplication
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class multiply2 {

    public int[][] multiply(int[][] a, int[][] b) {
        int rowA = a.length;
        int colA = a[0].length;
        int colB = b[0].length;
        int[][] res = new int[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colA; j++) {
                if (a[i][j] != 0) {
                    for (int k = 0; k < colB; k++) {
                        if (b[j][k] != 0) {
                            res[i][k] += a[i][j] * b[j][k];
                        }
                    }
                }
            }
        }
        return res;
    }
}
