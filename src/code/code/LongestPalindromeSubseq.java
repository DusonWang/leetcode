package code.code;

/**
 * @author duson
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * "cbbd"
 * 输出:
 * <p>
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
