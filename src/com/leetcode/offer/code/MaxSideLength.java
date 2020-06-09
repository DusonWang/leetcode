package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个大小为?m x n?的矩阵?mat?和一个整数阈值?threshold。
 * <p>
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0?。
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * 输出：2
 * 解释：总和小于 4 的正方形的最大边长为 2，如图所示。
 * 示例 2：
 * <p>
 * 输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
 * 输出：2
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 300
 * m == mat.length
 * n == mat[i].length
 * 0 <= mat[i][j] <= 10000
 * 0 <= threshold?<= 10^5
 * 通过次数2,749提交次数6,562
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSideLength {

    public int maxSideLength(int[][] mat, int threshold) {
        int high = mat.length, length = mat[0].length, size = 0;
        int[][] prefix = new int[high + 1][length + 1];
        for (int i = 1; i <= high; i++) {
            for (int j = 1; j <= length; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= high; i++) {
            for (int j = 1; j <= length; j++) {
                if (mat[i - 1][j - 1] > threshold) {
                    continue;
                }
                for (int k = 1; j - k >= 0 && i - k >= 0; k++) {
                    int sum = prefix[i][j] - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k];
                    if (sum > threshold) {
                        break;
                    }
                    size = Math.max(size, k);
                }
            }
        }
        return size;
    }
}
