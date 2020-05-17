package com.leetcode.offer.code;

/**
 * @author duson
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * ?
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例?2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例?3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * ?
 * <p>
 * 说明:
 * <p>
 * -100.0 <?x?< 100.0
 * n?是 32 位有符号整数，其数值范围是?[?231,?231?? 1] 。
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 * <p>
 * 通过次数15,058提交次数46,491
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyPow {

    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow2(x, n / 2);
        double mod = myPow2(x, n % 2);
        return half * half * mod;
    }
}
