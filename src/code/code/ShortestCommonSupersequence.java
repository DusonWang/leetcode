package code.code;

/**
 * @author duson
 * 给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 * <p>
 * （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：str1 = "abac", str2 = "cab"
 * 输出："cabac"
 * 解释：
 * str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
 * str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
 * 最终我们给出的答案是满足上述属性的最短字符串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 都由小写英文字母组成。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-common-supersequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestCommonSupersequence {

    public String shortestCommonSupersequence(String str1, String str2) {
        char[] c1 = str1.toCharArray(), c2 = str2.toCharArray();
        int m = c1.length, n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int l = dp[m][n];
        char[] res = new char[l];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (c1[i - 1] == c2[j - 1]) {
                res[--l] = c1[i - 1];
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                res[--l] = c1[i - 1];
                i--;
            } else {
                res[--l] = c2[j - 1];
                j--;
            }
        }
        while (i > 0) {
            res[--l] = c1[i - 1];
            i--;
        }
        while (j > 0) {
            res[--l] = c2[j - 1];
            j--;
        }

        return new String(res);
    }
}
