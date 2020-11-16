package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author duson
 * 给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：
 * <p>
 * 可以写成某个字符串与其自身相连接的形式（即，可以写为 a + a，其中 a 是某个字符串）。
 * 例如，abcabc 就是 abc 和它自身连接形成的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "abcabcabc"
 * 输出：3
 * 解释：3 个子字符串分别为 "abcabc"，"bcabca" 和 "cabcab" 。
 * 示例 2：
 * <p>
 * 输入：text = "leetcodeleetcode"
 * 输出：2
 * 解释：2 个子字符串为 "ee" 和 "leetcodeleetcode" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 2000
 * text 只包含小写英文字母。
 * 通过次数1,018提交次数2,504
 * 在真实的面试中遇到过这道题？
 * <p>
 * https://leetcode-cn.com/problems/distinct-echo-substrings/
 */
public class DistinctEchoSubstrings {

    public int distinctEchoSubstrings(String text) {
        Set<String> ans = new HashSet<>();
        int n = text.length();
        char[] array = text.toCharArray();

        for (int len = 1; len <= n / 2; len++) {
            int count = 0;
            for (int l = 0; l + len < n; l++) {
                int r = l + len;
                if (array[l] == array[r]) {
                    count++;
                    if (count == len) {
                        if (ans.add(text.substring(l - len + 1, l + 1))) {
                            count--;
                        }
                    }
                } else {
                    count = 0;
                }
            }
        }
        return ans.size();
    }
}
