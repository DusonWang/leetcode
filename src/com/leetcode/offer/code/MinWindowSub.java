package com.leetcode.offer.code;

/**
 * @author duson
 * 给定字符串 S and T，找出 S 中最短的（连续）子串 W ，使得 T 是 W 的 子序列 。
 * <p>
 * 如果 S 中没有窗口可以包含 T 中的所有字符，返回空字符串 ""。如果有不止一个最短长度的窗口，返回开始位置最靠左的那个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * S = "abcdebdde", T = "bde"
 * 输出："bcde"
 * 解释：
 * "bcde" 是答案，因为它在相同长度的字符串 "bdde" 出现之前。
 * "deb" 不是一个更短的答案，因为在窗口中必须按顺序出现 T 中的元素。
 *  
 * <p>
 * 注：
 * <p>
 * 所有输入的字符串都只包含小写字母。All the strings in the input will only contain lowercase letters.
 * S 长度的范围为 [1, 20000]。
 * T 长度的范围为 [1, 100]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindowSub {

    public String minWindow(String s, String t) {
        int i = 0, j = 0;
        int len = s.length();
        int minLen = Integer.MAX_VALUE;
        int n = t.length();
        int start = -1;
        while (i < len) {
            if (s.charAt(i) == t.charAt(j)) {
                if (++j == n) {
                    int end = i + 1;
                    while (--j >= 0) {
                        while (s.charAt(i--) != t.charAt(j)) {
                            ;
                        }
                    }
                    ++i;
                    ++j;
                    if (end - i < minLen) {
                        minLen = end - i;
                        start = i;
                    }
                }
            }
            i++;
        }
        return start == -1 ? "" : s.substring(start, start + minLen);
    }

    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.contains(t)) {
            return t;
        }
        int start = 0;
        int end = s.length() - 1;
        int p = 0;
        int q = 0;
        while (p < s.length()) {
            if (s.charAt(p) == t.charAt(q)) {
                q++;
            }
            if (q == t.length()) {
                int right = p;
                q--;
                while (q >= 0) {
                    if (s.charAt(p) == t.charAt(q)) {
                        q--;
                    }
                    p--;
                }
                p++;
                if (right - p + 1 < end - start + 1) {
                    start = p;
                    end = right;
                }
                q = 0;
            }
            p++;
        }
        return end - start + 1 == s.length() ? "" : s.substring(start, end + 1);
    }
}
