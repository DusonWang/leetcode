package com.leetcode.offer.day28;

/**
 * @author duson
 */
public class SubArraySum {

    public int findSumWays(int[] nums, int m) {
        final int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = m; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 8;//{3,5}{1,4,3}{1,2,5}
        System.out.println(subArraySum.findSumWays(nums, target));
    }
}
