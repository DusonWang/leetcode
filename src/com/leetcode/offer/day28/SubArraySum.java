package com.leetcode.offer.day28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 */
public class SubArraySum {

    /*
     * all positive numbers
     * */
    public int findSubArraySumWays(int[] nums, int m) {
        final int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = m; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[m];
    }

    /*
     * 2数和
     * 3数和
     * ...
     * M数和
     * */
    public List<List<Integer>> findSumWays2(int[] nums, int target, int m) {
        Arrays.sort(nums);
        return kSum(nums, target, m, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (index >= len) {
            return res;
        }
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (target - nums[i] > nums[j]) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if (temp.size() > 0) {
                    for (List<Integer> list : temp) {
                        list.add(nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int[] nums = new int[]{1, 1, -1, 1, 2, 3, 4, 5};
        int target = 8;//{3,5}{1,4,3}{1,2,5}
        System.out.println(subArraySum.findSumWays2(nums, target, 2));
        System.out.println(subArraySum.findSumWays2(nums, target, 3));
        System.out.println(subArraySum.findSumWays2(nums, target, 4));

    }
}
