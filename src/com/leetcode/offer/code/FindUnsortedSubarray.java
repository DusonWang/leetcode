package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * <p>
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * <p>
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindUnsortedSubarray {

//    public int findUnsortedSubarray2(int[] nums) {
//        int low = 0, high = nums.length - 1;
//        while (low < high && nums[low] <= nums[low + 1]) {
//            low++;
//        }
//        while (low < high && nums[high - 1] <= nums[high]) {
//            high--;
//        }
//        if (low == high) {
//            return 0;
//        }
//        int max = nums[low], min = nums[low];
//        for (int i = low; i <= high; i++) {
//            max = Math.max(max, nums[i]);
//            min = Math.min(min, nums[i]);
//        }
//        while (low >= 0 && nums[low] > min) {
//            low--;
//        }
//        while (high < nums.length && nums[high] < max) {
//            high++;
//        }
//        return high - low - 1;
//    }

    public int findUnsortedSubarray(int[] nums) {
        final int len = nums.length;
        int[] copy = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        int start = len;
        int end = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != copy[i]) {
                start = Math.min(i, start);
                end = Math.max(end, i);
            }
        }
        return end - start > 0 ? (end - start + 1) : 0;
    }
}
