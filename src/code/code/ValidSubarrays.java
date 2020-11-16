package code.code;

import java.util.Arrays;

/**
 * 给定一个整数数组 A，返回满足下面条件的 非空、连续 子数组的数目：
 * <p>
 * 子数组中，最左侧的元素不大于其他元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,4,2,5,3]
 * 输出：11
 * 解释：有 11 个有效子数组，分别是：[1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3] 。
 * 示例 2：
 * <p>
 * 输入：[3,2,1]
 * 输出：3
 * 解释：有 3 个有效子数组，分别是：[3],[2],[1] 。
 * 示例 3：
 * <p>
 * 输入：[2,2,2]
 * 输出：6
 * 解释：有 6 个有效子数组，分别为是：[2],[2],[2],[2,2],[2,2],[2,2,2] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * 0 <= A[i] <= 100000
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidSubarrays {

    public int validSubarrays(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = length - 2; i >= 0; --i) {
            int j = i + 1;
            while (j < length && nums[i] <= nums[j]) {
                j += dp[j];
            }
            dp[i] = j - i;
            ans += dp[i];
        }
        return ans;
    }
}
