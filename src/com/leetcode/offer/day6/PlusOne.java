package com.leetcode.offer.day6;

import java.util.Arrays;

/**
 * @author duson
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        final int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne2(int[] digits) {

        int x = digits[digits.length - 1] + 1;
        if (x < 10) {
            digits[digits.length - 1] = x;
            return digits;
        }
        int c = 1;
        digits[digits.length - 1] = 0;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += c;
                c = 0;
                break;
            } else {
                digits[i] = 0;
                c = 1;
            }
        }
        if (c == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, result.length - 1);
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{4, 0, 9})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9, 9, 9})));

    }
}
