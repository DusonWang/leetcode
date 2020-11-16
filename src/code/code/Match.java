package code.code;

/**
 * @author duson
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Match {

    public boolean isMatch(String text, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return text == null || text.length() == 0;
        }

        boolean firstMatch = !(text == null || text.length() == 0)
                && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }


    public boolean isMatch2(String text, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return text == null || text.length() == 0;
        }

        final int m = text.length();
        final int n = pattern.length();
        final boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        final char[] pChars = pattern.toCharArray();
        final char[] tChars = text.toCharArray();
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean firstMatch = i < m && (tChars[i] == pattern.charAt(j) || pChars[j] == '.');
                if (j + 1 < n && pChars[j + 1] == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Match match = new Match();
        System.out.println(match.isMatch2("mississippi", "mis*is*p*."));
        System.out.println(match.isMatch2("aa", "a*"));
        System.out.println(match.isMatch2("ab", ".*"));
        System.out.println(match.isMatch2("aab", "c*a*b"));

    }
}
