package com.leetcode.offer.code;

/**
 * 给你两个数组?nums1?和?nums2?。
 * <p>
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 * <p>
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5]?是?[1,2,3,4,5]?的一个子序列而?[1,5,3]?不是。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,-2], nums2 = [2,-6,7]
 * 输出：21
 * 解释：从 nums1 中得到子序列 [3] ，从 nums2 中得到子序列 [7] 。
 * 它们的点积为 (3*7) = 21 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [-1,-1], nums2 = [1,1]
 * 输出：-1
 * 解释：从 nums1 中得到子序列 [-1] ，从 nums2 中得到子序列 [1] 。
 * 它们的点积为 -1 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 100
 * ?
 * <p>
 * 点积：
 * <p>
 * 定义 a?= [a1,?a2,…,?an] 和 b?= [b1,?b2,…,?bn] 的点积为：
 * <p>
 * <p>
 * <p>
 * 这里的 Σ 指示总和符号。
 * 通过次数1,245提交次数3,827
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author duson
 */
public class MaxDotProduct {

    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++i) {
            dp[i] = new int[m];
            for (int j = 0; j < m; ++j) {
                dp[i][j] = a[i] * b[j];
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], 0);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
