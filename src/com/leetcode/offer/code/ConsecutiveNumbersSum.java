package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 2
 * 解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 * <p>
 * 输入: 9
 * 输出: 3
 * 解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 * <p>
 * 输入: 15
 * 输出: 4
 * 解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * 说明: 1 <= N <= 10 ^ 9
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/consecutive-numbers-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int i = 1; i <= (int) Math.sqrt(2 * n); i++) {
            if ((2 * n + i - i * i) % (2 * i) == 0) {
                count++;
            }
        }
        return count;
    }
}
