package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * <p>
 * 请你返回非零偏移下降路径数字和的最小值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length == arr[i].length <= 200
 * -99 <= arr[i][j] <= 99
 * 通过次数1,336提交次数2,270
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinFallingPathSum2 {

    public int minFallingPathSum(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        int cols = arr[0].length;
        int min1, min2, min1Col = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                if (arr[i + 1][j] < min1) {
                    min2 = min1;
                    min1 = arr[i + 1][j];
                    min1Col = j;
                } else if (arr[i + 1][j] < min2) {
                    min2 = arr[i + 1][j];
                }
            }
            for (int j = 0; j < cols; j++) {
                arr[i][j] += (j == min1Col ? min2 : min1);
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            ret = Math.min(ret, arr[0][i]);
        }
        return ret;
    }
}
