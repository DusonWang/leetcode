package com.leetcode.offer.code;

/**
 * @author duson
 * 给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："abcd"
 * 输出：0
 * 解释：没有重复子串。
 * 示例 2：
 * <p>
 * 输入："abbaba"
 * 输出：2
 * 解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
 * 示例 3：
 * <p>
 * 输入："aabcaabdaab"
 * 输出：3
 * 解释：最长的重复子串为 "aab"，出现 3 次。
 * 示例 4：
 * <p>
 * 输入："aaaaa"
 * 输出：4
 * 解释：最长的重复子串为 "aaaa"，出现 2 次。
 *  
 * <p>
 * 提示：
 * <p>
 * 字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。
 * 1 <= S.length <= 1500
 * 通过次数1,067提交次数2,423
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestRepeatingSubstring {

    public int longestRepeatingSubstring(String s) {
        int lastLength = 0;
        for (int i = 1; i < s.length(); i++) {
            String ss = s.substring(i - lastLength, i + 1);
            String sCmp = s.substring(0, i);
            if (sCmp.contains(ss)) {
                lastLength = lastLength + 1;
            }
        }
        return lastLength;
    }
}
