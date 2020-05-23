package com.leetcode.offer.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * <p>
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * <p>
 * 示例:
 * <p>
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * 示例:
 * <p>
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * 提示：
 * <p>
 * 1 <= array1.length, array2.length <= 100000
 * 通过次数1,789提交次数4,057
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSwapValues {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : array1) {
            sum1 += i;
        }
        for (int i : array2) {
            sum2 += i;
            set.add(i);
        }
        int sum = sum1 + sum2;
        if (sum % 2 != 0) {
            return new int[0];
        }
        int target = sum / 2;
        for (int i : array1) {
            if (set.contains(target - (sum1 - i))) {
                return new int[]{i, target - (sum1 - i)};
            }
        }
        return new int[0];
    }
}
