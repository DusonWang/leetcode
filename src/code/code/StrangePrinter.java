package code.code;

/**
 * @author duson
 * 有台奇怪的打印机有以下两个特殊要求：
 * <p>
 * 打印机每次只能打印同一个字符序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aaabbb"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后打印 "bbb"。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 * 提示: 输入字符串的长度不会超过 100。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strange-printer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrangePrinter {

    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                dp[i][j] = (i == j) ? 1 : 1 + dp[i + 1][j];
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(k) == s.charAt(i)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
