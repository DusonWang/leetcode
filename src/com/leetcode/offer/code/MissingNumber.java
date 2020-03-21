package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingNumber {

    public int missingNumber2(int[] nums) {
        final int len = nums.length;
        int expectedSum = len * (len + 1) / 2;
        int actualSum = 0;
        for(int x : nums) {
            actualSum += x;
        }
        return expectedSum - actualSum;
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return len;
    }

    public int missingNumber3(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i ^ nums[i];
        }
        return ans;
    }
}
