package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个字符串 S，返回只含 单一字母 的子串个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： "aaaba"
 * 输出： 8
 * 解释：
 * 只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
 * "aaa" 出现 1 次。
 * "aa" 出现 2 次。
 * "a" 出现 4 次。
 * "b" 出现 1 次。
 * 所以答案是 1 + 2 + 4 + 1 = 8。
 * 示例 2:
 * <p>
 * 输入： "aaaaaaaaaa"
 * 输出： 55
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 1000
 * S[i] 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-substrings-with-only-one-distinct-letter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountLetters {

    public int countLetters(String s) {
        int ans = 0;
        int prev = 1;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                prev++;
            } else {
                ans += prev * (prev + 1) / 2;
                prev = 1;
            }
        }

        ans += prev * (prev + 1) / 2;
        return ans;
    }
}
