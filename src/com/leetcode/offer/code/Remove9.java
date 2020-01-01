package com.leetcode.offer.code;

/**
 * @author duson
 * 从 1 开始，移除所有包含数字 9 的所有整数，例如 9，19，29，……
 * <p>
 * 这样就获得了一个新的整数数列：1，2，3，4，5，6，7，8，10，11，……
 * <p>
 * 给定正整数 n，请你返回新数列中第 n 个数字是多少。1 是新数列中的第一个数字。
 * <p>
 *  
 * <p>
 * 样例 1:
 * <p>
 * 输入: 9
 * 输出: 10
 *  
 * <p>
 * 注释 ：n 不会超过 9 x 10^8。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-9
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Remove9 {

    public int newInteger2(int n) {
        int res = 0;
        int exp = 1;
        while (n > 0) {
            int r = n % 9;
            n = n / 9;
            res = r * exp + res;
            exp *= 10;
        }
        return res;
    }

    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }
}
