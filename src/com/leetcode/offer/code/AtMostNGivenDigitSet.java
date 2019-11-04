package com.leetcode.offer.code;

/**
 * @author duson
 * 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）
 * <p>
 * 现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。
 * <p>
 * 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：D = ["1","3","5","7"], N = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * 示例 2：
 * <p>
 * 输入：D = ["1","4","9"], N = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 *  
 * <p>
 * 提示：
 * <p>
 * D 是按排序顺序的数字 '1'-'9' 的子集。
 * 1 <= N <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/numbers-at-most-n-given-digit-set
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AtMostNGivenDigitSet {

    public static int atMostNGivenDigitSet(String[] D, int N) {
        String s = String.valueOf(N);
        int k = s.length();
        int[] dp = new int[k + 1];
        dp[k] = 1;

        for (int i = k - 1; i >= 0; --i) {
            int si = s.charAt(i) - '0';
            for (String d : D) {
                if (Integer.parseInt(d) < si) {
                    dp[i] += Math.pow(D.length, k - i - 1);
                } else if (Integer.parseInt(d) == si) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        for (int i = 1; i < k; ++i) {
            dp[0] += Math.pow(D.length, i);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 130));
    }
}
