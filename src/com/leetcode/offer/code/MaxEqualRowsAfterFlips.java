package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。
 * <p>
 * 返回经过一些翻转后，行上所有值都相等的最大行数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 * <p>
 * 输入：[[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 * <p>
 * 输入：[[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= matrix.length <= 300
 * 1 <= matrix[i].length <= 300
 * 所有 matrix[i].length 都相等
 * matrix[i][j] 为 0 或 1
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxEqualRowsAfterFlips {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] ints : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    sb.append("a");
                } else {
                    sb.append(ints[j] == ints[0] ? "a" : "b");
                }
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        int res = 0;
        for (int num : map.values()) {
            res = Math.max(res, num);
        }
        return res;
    }
}
