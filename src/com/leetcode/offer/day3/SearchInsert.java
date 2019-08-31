package com.leetcode.offer.day3;

/**
 * @author duson
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsert {

    private int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int index = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target > nums[i]) {
                index = i + 1;
                break;
            } else if (target == nums[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        final SearchInsert searchInsert = new SearchInsert();
        final int[] nums = new int[]{1, 3, 5, 6};
        final int[] targets = new int[]{5, 2, 7, 0,4};
        for (int target : targets) {
            System.out.println(" 1 " + searchInsert.searchInsert(nums, target));
        }


    }
}
