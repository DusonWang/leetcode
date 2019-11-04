package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [3,5,2,1,6,4]
 * 输出: 一个可能的解答是 [3,5,1,6,2,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WiggleSort0 {

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1])
                    || (i % 2 == 1 && nums[i] < nums[i + 1])) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public void wiggleSort2(int[] nums) {
        final int len = nums.length;
        final int[] copy = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        int mid = len / 2;
        if ((len & 1) == 0) {
            mid--;
        }
        for (int i = len - 1; i > mid; i--) {
            nums[2 * (len - i - 1) + 1] = copy[i];
        }
        for (int i = mid; i >= 0; i--) {
            nums[2 * (mid - i)] = copy[i];
        }
    }
}
