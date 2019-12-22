package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个 非递减 的正整数数组 nums 和整数 K，判断该数组是否可以被分成一个或几个 长度至少 为 K 的 不相交的递增子序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,3,3,4,4], K = 3
 * 输出：true
 * 解释：
 * 该数组可以分成两个子序列 [1,2,3,4] 和 [2,3,4]，每个子序列的长度都至少是 3。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,6,7,8], K = 3
 * 输出：false
 * 解释：
 * 没有办法根据条件来划分数组。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= K <= nums.length
 * 1 <= nums[i] <= 10^5
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-array-into-increasing-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanDivideIntoSubsequences {

    public boolean canDivideIntoSubsequences(int[] a, int k) {
        int cur = 1, groups = 1, n = a.length;
        for (int i = 1; i < n; i++) {
            cur = a[i - 1] < a[i] ? 1 : cur + 1;
            groups = Math.max(groups, cur);
        }
        return n >= k * groups;
    }
}
