package com.leetcode.offer.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int length = nums.length;
        int[] indexes = new int[2];
        for (int i = 0; i < length; i++) {
            int minus = target - nums[i];
            for (int j = i + 1; j < length; j++) {
                if (nums[j] == minus) {
                    indexes[0] = i;
                    indexes[1] = j;
                    return indexes;
                }
            }
        }
        return indexes;
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int length = nums.length;
        int[] indexes = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && index != i) {
                indexes[0] = i;
                indexes[1] = index;
                return indexes;
            }
        }
        return indexes;
    }

    public int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int length = nums.length;
        int[] indexes = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < length; i++) {
            int minus = target - nums[i];
            Integer index = map.get(nums[i]);
            if (index != null) {
                indexes[0] = index;
                indexes[1] = i;
                break;
            }
            map.put(minus, i);
        }
        return indexes;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] indexes = twoSum.twoSum3(nums, target);
        System.out.println(indexes[0] + "<>" + indexes[1]);
    }
}
