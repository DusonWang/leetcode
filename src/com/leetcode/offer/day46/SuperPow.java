package com.leetcode.offer.day46;

/**
 * @author duson
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 示例 2:
 * <p>
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-pow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SuperPow {

    private static final int M = 1337;

    public int normalPow(int a, int b) {
        int result = 1;
        while (b != 0) {
            if (b % 2 != 0) {
                result = result * a % M;
            }
            a = a * a % M;
            b /= 2;
        }
        return result;
    }

    public int superPow(int a, int[] b) {
        a %= M;
        int result = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            result = result * normalPow(a, b[i]) % M;
            a = normalPow(a, 10);
        }
        return result;
    }
}
