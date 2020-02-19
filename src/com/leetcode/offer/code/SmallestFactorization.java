package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个正整数 a，找出最小的正整数 b 使得 b 的所有数位相乘恰好等于 a。
 * <p>
 * 如果不存在这样的结果或者结果不是 32 位有符号整数，返回 0。
 * <p>
 *  
 * <p>
 * 样例 1
 * <p>
 * 输入：
 * <p>
 * 48
 * 输出：
 * <p>
 * 68
 *  
 * <p>
 * 样例 2
 * <p>
 * 输入：
 * <p>
 * 15
 * 输出：
 * <p>
 * 35
 *  
 * <p>
 * 通过次数574提交次数1,771
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-factorization
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestFactorization {

    public int smallestFactorization(int a) {
        if (a < 2) {
            return a;
        }
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                res = mul * i + res;
                mul *= 10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ? (int) res : 0;
    }
}
