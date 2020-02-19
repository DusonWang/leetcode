package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 给你一个整数数组 nums 。「 数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。
 * <p>
 * 你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作 一次 。
 * <p>
 * 请你找到可行的最大 数组值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,5,4]
 * 输出：10
 * 解释：通过翻转子数组 [3,1,5] ，数组变成 [2,5,1,3,4] ，数组值为 10 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,9,24,2,1,10]
 * 输出：68
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3*10^4
 * -10^5 <= nums[i] <= 10^5
 * 通过次数249提交次数794
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-subarray-to-maximize-array-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxValueAfterReverse {

    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int sum = 0;
        int minX = 1000000000;
        int maxX = -1000000000;
        int minPos = 0;
        int maxPos = 0;
        for (int i = 1; i < n; i++) {
            int currMinX = Math.min(nums[i], nums[i - 1]);
            int currMaxX = Math.max(nums[i], nums[i - 1]);
            sum += currMaxX - currMinX;
            if (currMaxX < minX) {
                minX = currMaxX;
                minPos = i;
            }
            if (currMinX > maxX) {
                maxX = currMinX;
                maxPos = i;
            }
        }
        int result = sum;
        result = Math.max(result, sum + (maxX - minX) * 2);
        result = Math.max(result, sum - Math.abs(nums[maxPos] - nums[maxPos - 1]) + Math.abs(nums[maxPos] - nums[0]));
        result = Math.max(result, sum - Math.abs(nums[minPos] - nums[minPos - 1]) + Math.abs(nums[minPos] - nums[0]));
        result = Math.max(result, sum - Math.abs(nums[maxPos] - nums[maxPos - 1]) + Math.abs(nums[maxPos - 1] - nums[n - 1]));
        result = Math.max(result, sum - Math.abs(nums[minPos] - nums[minPos - 1]) + Math.abs(nums[minPos - 1] - nums[n - 1]));
        return result;
    }
}
