package com.leetcode.offer.day50;

/**
 * @author duson
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * <p>
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：12
 * 解释：
 * 可能的下降路径有：
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * 和最小的下降路径是 [1,4,7]，所以答案是 12。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinFallingPathSum {

    public int minFallingPathSum(int[][] a) {
        int n = a.length;
        for (int r = n - 2; r >= 0; --r) {
            for (int c = 0; c < n; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = a[r + 1][c];
                if (c > 0) {
                    best = Math.min(best, a[r + 1][c - 1]);
                }
                if (c + 1 < n) {
                    best = Math.min(best, a[r + 1][c + 1]);
                }
                a[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x : a[0]) {
            ans = Math.min(ans, x);
        }
        return ans;
    }
}
