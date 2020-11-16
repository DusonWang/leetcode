package code.code;

/**
 * @author duson
 * 「快乐前缀」是在原字符串中既是?非空 前缀也是后缀（不包括原字符串自身）的字符串。
 * <p>
 * 给你一个字符串 s，请你返回它的 最长快乐前缀。
 * <p>
 * 如果不存在满足题意的前缀，则返回一个空字符串。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "level"
 * 输出："l"
 * 解释：不包括 s 自己，一共有 4 个前缀（"l", "le", "lev", "leve"）和 4 个后缀（"l", "el", "vel", "evel"）。最长的既是前缀也是后缀的字符串是 "l" 。
 * 示例 2：
 * <p>
 * 输入：s = "ababab"
 * 输出："abab"
 * 解释："abab" 是最长的既是前缀也是后缀的字符串。题目允许前后缀在原字符串中重叠。
 * 示例 3：
 * <p>
 * 输入：s = "leetcodeleet"
 * 输出："leet"
 * 示例 4：
 * <p>
 * 输入：s = "a"
 * 输出：""
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 只含有小写英文字母
 * 通过次数3,051提交次数8,796
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-happy-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPrefix {

    public String longestPrefix(String s) {
        char[] w = s.toCharArray();
        int n = s.length();
        int[] next = new int[n];
        int len = 0, i = 1;
        while (i < n) {
            if (w[i] == w[len]) {
                len++;
                next[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = next[len - 1];
                } else {
                    i++;
                }
            }
        }
        return s.substring(0, next[n - 1]);
    }
}
