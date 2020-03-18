package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * <p>
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * <p>
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 * <p>
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 * 通过次数3,779提交次数5,278
 * 在真实的面试中遇到过这道题？
 * <p>
 * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 */
public class LuckyNumbers {

    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] min = new int[m];
        int[] max = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                min[i] = Math.min(min[i], matrix[i][j]);
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (min[i] == max[j]) {
                    list.add(min[i]);
                }
            }
        }
        return list;
    }
}
