package code.code;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给你一个下标从 0 开始的整数数组 nums和一个整数 k。
 * <p>
 * 一开始你在下标0处。每一步，你最多可以往前跳k步，但你不能跳出数组的边界。也就是说，你可以从下标i跳到[i + 1， min(n - 1, i + k)]包含 两个端点的任意位置。
 * <p>
 * 你的目标是到达数组最后一个位置（下标为 n - 1），你的 得分为经过的所有数字之和。
 * <p>
 * 请你返回你能得到的 最大得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,-5,-2,4,0,3], k = 3
 * 输出：17
 * 解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, k <= 105
 * -104<= nums[i]<= 104
 * 通过次数5,112提交次数12,567
 * 请问您在哪类招聘中遇到此题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-vi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxResult {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            for (int j = Math.max(0, i - k); j < i; ++j) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        MaxResult maxResult = new MaxResult();
        System.out.println(maxResult.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
    }
}
