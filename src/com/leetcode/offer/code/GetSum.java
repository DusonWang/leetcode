package com.leetcode.offer.code;

/**
 * @author duson
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetSum {

    public int getSum(int a, int b) {
        do {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }

    public static void main(String[] args) {
        GetSum getSum = new GetSum();
        System.out.println(getSum.getSum(1, 2));
        System.out.println(getSum.getSum(-2, 3));

    }
}
