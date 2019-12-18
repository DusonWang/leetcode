package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 我们给出 S，一个源于 {'D', 'I'} 的长度为 n 的字符串 。（这些字母代表 “减少” 和 “增加”。）
 * 有效排列 是对整数 {0, 1, ..., n} 的一个排列 P[0], P[1], ..., P[n]，使得对所有的 i：
 * <p>
 * 如果 S[i] == 'D'，那么 P[i] > P[i+1]，以及；
 * 如果 S[i] == 'I'，那么 P[i] < P[i+1]。
 * 有多少个有效排列？因为答案可能很大，所以请返回你的答案模 10^9 + 7.
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："DID"
 * 输出：5
 * 解释：
 * (0, 1, 2, 3) 的五个有效排列是：
 * (1, 0, 3, 2)
 * (2, 0, 3, 1)
 * (2, 1, 3, 0)
 * (3, 0, 2, 1)
 * (3, 1, 2, 0)
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * S 仅由集合 {'D', 'I'} 中的字符组成。
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-permutations-for-di-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumPermsDISequence {

    public int numPermsDISequence(String s) {
        int mod = 1_000_000_007;
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i - 1) == 'D') {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                } else {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int x : dp[n]) {
            ans += x;
            ans %= mod;
        }
        return ans;
    }
}
