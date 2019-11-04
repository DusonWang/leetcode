package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSmaller {

    public List<Integer> countSmaller2(int[] nums) {
        final int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            list.add(count);
        }
        return list;
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] ans = new Integer[n];
        List<Integer> sorted = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }

    private int findIndex(List<Integer> sorted, int target) {
        int i = 0;
        int j = sorted.size();
        while (i < j) {
            int mid = (i + j) >> 1;
            if (sorted.get(mid) < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public List<Integer> countSmallerOpt(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int min = Integer.MAX_VALUE;
        for (int value : nums) {
            if (value < min) {
                min = value;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int value : nums) {
            if (value > max) {
                max = value;
            }
        }

        int[] btree = new int[max + 1];
        btree[0] = 0;
        int[] countArr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int count = getSum(nums[i] - 1, btree);
            countArr[i] = count;
            update(nums[i], btree);
        }
        List<Integer> result = new ArrayList<>();
        for (int value : countArr) {
            result.add(value);
        }
        return result;
    }

    private static int getSum(int value, int[] btree) {
        int sum = 0;
        while (value > 0) {
            sum += btree[value];
            value -= (value & -value);
        }
        return sum;
    }

    private static void update(int value, int[] btree) {
        while (value <= btree.length - 1) {
            btree[value] += 1;
            value += (value & -value);
        }
    }

    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        System.out.println(countSmaller.countSmaller(new int[]{5, 2, 6, 1}));
    }
}
