package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * <p>
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 * <p>
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int min = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > min) {
                min = nums[i] - nums[i - 1];
            }
        }
        return min;
    }

    public int maximumGap2(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        int min = num[0];
        int max = num[0];
        for (int i : num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
        int[] bMin = new int[num.length - 1];
        int[] bMax = new int[num.length - 1];
        Arrays.fill(bMin, Integer.MAX_VALUE);
        Arrays.fill(bMax, Integer.MIN_VALUE);
        for (int i : num) {
            if (i == min || i == max) {
                continue;
            }
            int idx = (i - min) / gap;
            bMin[idx] = Math.min(i, bMin[idx]);
            bMax[idx] = Math.max(i, bMax[idx]);
        }

        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bMin[i] == Integer.MAX_VALUE && bMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bMin[i] - previous);
            previous = bMax[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        int[] a = new int[]{3, 6, 9, 1};

        maximumGap.maximumGap2(a);
    }
}
