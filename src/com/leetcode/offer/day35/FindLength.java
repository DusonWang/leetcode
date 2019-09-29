package com.leetcode.offer.day35;

/**
 * @author duson
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLength {

    public int findLength(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        dp[0][0] = 0;
        int max = 0;
        for (int i = 1; i <= a.length; ++i) {
            for (int j = 1; j <= b.length; ++j) {
                dp[i][j] = a[i - 1] == b[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
