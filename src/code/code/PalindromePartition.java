package code.code;

/**
 * @author duson
 * 给你一个由小写字母组成的字符串?s，和一个整数?k。
 * <p>
 * 请你按下面的要求分割字符串：
 * <p>
 * 首先，你可以将?s?中的部分字符修改为其他的小写英文字母。
 * 接着，你需要把?s?分割成?k?个非空且不相交的子串，并且每个子串都是回文串。
 * 请返回以这种方式分割字符串所需修改的最少字符数。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", k = 2
 * 输出：1
 * 解释：你可以把字符串分割成 "ab" 和 "c"，并修改 "ab" 中的 1 个字符，将它变成回文串。
 * 示例 2：
 * <p>
 * 输入：s = "aabbc", k = 3
 * 输出：0
 * 解释：你可以把字符串分割成 "aa"、"bb" 和 "c"，它们都是回文串。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode", k = 8
 * 输出：0
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= s.length <= 100
 * s?中只含有小写英文字母。
 * 通过次数1,544提交次数2,695
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromePartition {

    public int palindromePartition(String s, int k) {
        int len = s.length();
        int[][] times = new int[len][len];
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int end = i + l - 1;
                times[i][end] = times[i + 1][end - 1] + (s.charAt(i) == s.charAt(end) ? 0 : 1);
            }
        }
        int[][] dp = new int[len + 1][k + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                if (j == 1) {
                    dp[i][j] = times[0][i - 1];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int start = j - 1; start < i; start++) {
                        dp[i][j] = Math.min(dp[i][j], dp[start][j - 1] + times[start][i - 1]);
                    }
                }
            }
        }
        return dp[len][k];
    }
}
