package com.leetcode.offer.code;

/**
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
 * 输出：true
 * 解释：每个 1 都至少相隔 2 个元素。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：false
 * 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1,1], k = 0
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：nums = [0,1,0,1], k = 1
 * 输出：true
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= k <= nums.length
 * nums[i] 的值为 0 或 1
 * 通过次数3,886提交次数6,269
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-all-1s-are-at-least-length-k-places-away
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KLengthApart {

    public boolean kLengthApart(int[] nums, int k) {
        int count = k;
        for (int num : nums) {
            if (num == 1) {
                if (count < k) {
                    return false;
                }
                count = 0;
            } else {
                count++;
            }
        }
        return true;
    }
}
