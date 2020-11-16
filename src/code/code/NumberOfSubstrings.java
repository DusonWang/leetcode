package code.code;

/**
 * @author duson
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * <p>
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * 示例 2：
 * <p>
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 5 x 10^4
 * s 只包含字符 a，b 和 c 。
 * 通过次数1,597提交次数3,952
 * 在真实的面试中遇到过这道题？
 */
public class NumberOfSubstrings {

    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0};
        int res = 0;
        int i = 0;
        int n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                --count[s.charAt(i++) - 'a'];
            }
            res += i;
        }
        return res;
    }
}
