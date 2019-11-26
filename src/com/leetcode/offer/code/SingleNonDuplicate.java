package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int h = (r + l) / 2;
            if (h % 2 == 1) {
                if (nums[h] == nums[h + 1]) {
                    r = h - 1;
                } else {
                    l = h + 1;
                }
            } else {
                if (nums[h] == nums[h + 1]) {
                    l = h + 2;
                } else {
                    r = h;
                }
            }
        }
        return nums[l];
    }
}
