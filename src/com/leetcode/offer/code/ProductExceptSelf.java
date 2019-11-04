package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        final int len = nums.length;
        final int[] res = new int[len];
        int k = 1;
        for (int i = 0; i < len; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int j = len - 1; j >= 0; j--) {
            res[j] *= k;
            k = k * nums[j];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
