package com.leetcode.offer.code;

/**
 * @author duson
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * <p>
 * 示例：
 * <p>
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * 提示：
 * <p>
 * numbers.length == 2
 * 通过次数1,918提交次数2,356
 * 在真实的面试中遇到过这道题？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-numbers-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapNumbers {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] = numbers[1] + numbers[0];
        numbers[0] = numbers[1] - numbers[0];
        return numbers;
    }

}
