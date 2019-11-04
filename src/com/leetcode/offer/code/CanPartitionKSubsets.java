package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *  
 * <p>
 * 注意:
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / k;
        if (target * k != sum) {
            return false;
        }
        int[] subset = new int[k];
        Arrays.sort(nums);
        return helper(nums, k, nums.length - 1, subset, target);
    }

    private boolean helper(int[] nums, int k, int start, int[] subset, int target) {
        if (start < 0) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (i > 0 && subset[i - 1] == 0) {
                return false;
            }
            if (subset[i] + nums[start] <= target) {
                subset[i] += nums[start];
                if (helper(nums, k, start - 1, subset, target)) {
                    return true;
                }
                subset[i] -= nums[start];
            }
        }
        return false;
    }
}
