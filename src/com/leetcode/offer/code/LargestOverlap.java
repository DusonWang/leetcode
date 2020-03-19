package com.leetcode.offer.code;

/**
 * @author duson
 * 给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
 * <p>
 * 我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
 * <p>
 * （请注意，转换不包括向任何方向旋转。）
 * <p>
 * 最大可能的重叠是什么？
 * <p>
 * 示例 1:
 * <p>
 * 输入：A = [[1,1,0],
 * [0,1,0],
 * [0,1,0]]
 * B = [[0,0,0],
 * [0,1,1],
 * [0,0,1]]
 * 输出：3
 * 解释: 将 A 向右移动一个单位，然后向下移动一个单位。
 * 注意:
 * <p>
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 * 通过次数1,693提交次数2,925
 * 在真实的面试中遇到过这道题？
 */
public class LargestOverlap {

    public int largestOverlap(int[][] a, int[][] b) {
        int n = a.length;
        int[][] count = new int[2 * n + 1][2 * n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a[i][j] == 1) {
                    for (int i2 = 0; i2 < n; ++i2) {
                        for (int j2 = 0; j2 < n; ++j2) {
                            if (b[i2][j2] == 1) {
                                count[i - i2 + n][j - j2 + n] += 1;
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int[] row : count) {
            for (int v : row) {
                ans = Math.max(ans, v);
            }
        }
        return ans;
    }
}
