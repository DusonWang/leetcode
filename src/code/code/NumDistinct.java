package code.code;

/**
 * @author duson
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * <p>
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 * <p>
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * <p>
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2:
 * <p>
 * 输入: S = "babgbag", T = "bag"
 * 输出: 5
 * 解释:
 * <p>
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * <p>
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDistinct {

    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }

    public static void main(String[] args) {
        NumDistinct numDistinct = new NumDistinct();
        System.out.println(numDistinct.numDistinct("babgbag", "bag"));
        System.out.println(numDistinct.numDistinct("rabbbit", "rabbit"));
    }
}
