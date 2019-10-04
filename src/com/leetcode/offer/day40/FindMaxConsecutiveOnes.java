package com.leetcode.offer.day40;

/**
 * @author duson
 * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *      当翻转以后，最大连续 1 的个数为 4。
 *  
 * <p>
 * 注：
 * <p>
 * 输入数组只包含 0 和 1.
 * 输入数组的长度为正整数，且不超过 10,000
 *  
 * <p>
 * 进阶：
 * 如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int curCount = 0;
        int lastZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curCount++;
            } else {
                maxCount = Math.max(maxCount, curCount);
                curCount = i - lastZeroIndex;
                lastZeroIndex = i;
            }
        }
        return Math.max(maxCount, curCount);
    }
}
