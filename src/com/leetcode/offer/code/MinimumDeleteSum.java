package com.leetcode.offer.code;

/**
 * @author duson
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例 2:
 * <p>
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * 注意:
 * <p>
 * 0 < s1.length, s2.length <= 1000。
 * 所有字符串中的字符ASCII值在[97, 122]之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumDeleteSum {

    public int minimumDeleteSum2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + (int) s2.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + (int) s1.charAt(i - 1);
                } else {
                    int last = dp[i - 1][j - 1];
                    if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                        last += (int) s1.charAt(i - 1) + (int) s2.charAt(j - 1);
                    }
                    dp[i][j] = Math.min(last, Math.min(dp[i - 1][j] + (int) s1.charAt(i - 1), dp[i][j - 1] + (int) s2.charAt(j - 1)));
                }
            }
        }
        return dp[m][n];
    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int suma = 0;
        int sumb = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j < n; j++) {
            sumb += b[j];
        }
        for (int i = 0; i < m; i++) {
            suma += a[i];
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    dp[i + 1][j + 1] = a[i] + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return suma + sumb - dp[m][n] * 2;
    }
}
