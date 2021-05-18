package code.code;

/**
 * 给你两个字符串?s 和?t?，请你找出 s?中的非空子串的数目，这些子串满足替换 一个不同字符?以后，是 t?串的子串。换言之，请你找到 s?和 t?串中 恰好?只有一个字符不同的子字符串对的数目。
 * <p>
 * 比方说，?"computer" 和?"computation" 加粗部分只有一个字符不同：?'e'/'a'?，所以这一对子字符串会给答案加 1 。
 * <p>
 * 请你返回满足上述条件的不同子字符串对数目。
 * <p>
 * 一个 子字符串?是一个字符串中连续的字符。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aba", t = "baba"
 * 输出：6
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 * 示例 2：
 * 输入：s = "ab", t = "bb"
 * 输出：3
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("ab", "bb")
 * ("ab", "bb")
 * ("ab", "bb")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 * 示例 3：
 * 输入：s = "a", t = "a"
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：s = "abe", t = "bbc"
 * 输出：10
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 100
 * s 和?t?都只包含小写英文字母。
 * 通过次数2,350提交次数3,327
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-substrings-that-differ-by-one-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSubstrings3 {

    public int countSubstrings(String s, String t) {
//        int m = s.length();
//        int n = t.length();
//        int res = 0;
//        int[][][] dp = new int[m + 1][n + 1][2];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                boolean flag = s.charAt(i) == t.charAt(j);
//                dp[i + 1][j + 1][0] = flag ? dp[i][j][0] + 1 : 0;
//                dp[i + 1][j + 1][1] = flag ? dp[i][j][1] : dp[i][j][0] + 1;
//                res += dp[i + 1][j + 1][1];
//            }
//        }
//        return res;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int ans = 0;
        int sLen = ss.length;
        int tLen = tt.length;
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                int diff = 0;
                for (int k = 0; i + k < sLen && j + k < sLen; k++) {
                    if (ss[i + k] != tt[j + k]) {
                        diff++;
                    }
                    if (diff == 1) {
                        ans++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
