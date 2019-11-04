package com.leetcode.offer.code;

/**
 * @author duson
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * <p>
 * 注意:
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        int sum = max;
        for (int right = k; right < nums.length; right++) {
            sum = sum + nums[right] - nums[right - k];
            max = Math.max(sum, max);
        }

        return (double) max / k;
    }

    public static void main(String[] args) {
        FindMaxAverage findMaxAverage = new FindMaxAverage();
        System.out.println(findMaxAverage.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage.findMaxAverage(new int[]{-1}, 1));

    }
}
