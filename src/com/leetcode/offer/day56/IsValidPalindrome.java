package com.leetcode.offer.day56;

/**
 * @author duson
 * 给出一个字符串 s 和一个整数 k，请你帮忙判断这个字符串是不是一个「K 回文」。
 * <p>
 * 所谓「K 回文」：如果可以通过从字符串中删去最多 k 个字符将其转换为回文，那么这个字符串就是一个「K 回文」。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：s = "abcdeca", k = 2
 * 输出：true
 * 解释：删除字符 “b” 和 “e”。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 中只含有小写英文字母
 * 1 <= k <= s.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidPalindrome {

    public boolean isValidPalindrome(String s, int k) {
        return s.length() - longestPalindromeSubseq(s) <= k;
    }

    private int longestPalindromeSubseq(String s) {
        char[] ss = s.toCharArray();
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (ss[i] == ss[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
