package com.leetcode.offer.code;

/**
 * 给你一个整数数组?nums?和一个整数?k?，请你返回 非空?子序列元素和的最大值，子序列需要满足：子序列中每两个 相邻?的整数?nums[i]?和?nums[j]?，它们在原数组中的下标?i?和?j?满足?i < j?且 j - i <= k 。
 * <p>
 * 数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2,-10,5,20], k = 2
 * 输出：37
 * 解释：子序列为 [10, 2, 5, 20] 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,-2,-3], k = 1
 * 输出：-1
 * 解释：子序列必须是非空的，所以我们选择最大的数字。
 * 示例 3：
 * <p>
 * 输入：nums = [10,-2,-10,-5,20], k = 2
 * 输出：23
 * 解释：子序列为 [10, -2, -5, 20] 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 10^5
 * -10^4?<= nums[i] <= 10^4
 * 通过次数1,584提交次数3,930
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/constrained-subsequence-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstrainedSubsetSum {

    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i - max > k) {
                max = i - 1;
                for (int j = i - 2; j >= i - k && j >= 0; j--) {
                    if (dp[max] < dp[j]) {
                        max = j;
                    }
                }
            }
            dp[i] = Math.max(nums[i], dp[max] + nums[i]);
            if (dp[i] > dp[max]) {
                max = i;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
