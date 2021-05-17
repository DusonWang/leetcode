package code.code;

import java.util.Stack;

/**
 * 一个数组的 最小乘积?定义为这个数组中 最小值?乘以?数组的 和?。
 * <p>
 * 比方说，数组?[3,2,5]?（最小值是?2）的最小乘积为?2 * (3+2+5) = 2 * 10 = 20?。
 * 给你一个正整数数组?nums?，请你返回?nums?任意?非空子数组?的最小乘积?的?最大值?。由于答案可能很大，请你返回答案对??109 + 7?取余?的结果。
 * <p>
 * 请注意，最小乘积的最大值考虑的是取余操作 之前?的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数?保存。
 * <p>
 * 子数组?定义为一个数组的 连续?部分。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,3,1,2]
 * 输出：18
 * 解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
 * 3 * (3+3) = 3 * 6 = 18 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,1,5,6,4,2]
 * 输出：60
 * 解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
 * 4 * (5+6+4) = 4 * 15 = 60 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 107
 * 通过次数3,250提交次数8,957
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray-min-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumMinProduct {

    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        long[] sums = new long[len + 1];
        for (int i = 0; i < len; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int index = -1;
        int[] indexStack = new int[len];
        long ans = 0;
        for (int i = 0; i < len; i++) {
            int v = nums[i];
            while (index > -1 && nums[indexStack[index]] > v) {
                int pop = nums[indexStack[index--]];
                int left = index > -1 ? (indexStack[index] + 1) : 0;
                ans = Math.max(ans, pop * (sums[i] - sums[left]));
            }
            indexStack[++index] = i;
        }
        while (index > -1) {
            int pop = nums[indexStack[index--]];
            int left = index > -1 ? (indexStack[index] + 1) : 0;
            ans = Math.max(ans, pop * (sums[len] - sums[left]));
        }

        return (int) (ans % 1000000007);
    }
}
