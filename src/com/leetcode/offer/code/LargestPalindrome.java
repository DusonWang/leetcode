package com.leetcode.offer.code;

/**
 * @author duson
 * 你需要找到由两个 n 位数的乘积组成的最大回文数。
 * <p>
 * 由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。
 * <p>
 * 示例:
 * <p>
 * 输入: 2
 * <p>
 * 输出: 987
 * <p>
 * 解释: 99 x 91 = 9009, 9009 % 1337 = 987
 * <p>
 * 说明:
 * <p>
 * n 的取值范围为 [1,8]。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-palindrome-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestPalindrome {

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        for (int v = max - 1; v > max / 10; v--) {
            long u = Long.parseLong(v + new StringBuilder().append(v).reverse().toString());
            for (long x = max; x * x >= u; x--) {
                if (u % x == 0) {
                    return (int) (u % 1337);
                }
            }
        }
        return 0;
    }
}
