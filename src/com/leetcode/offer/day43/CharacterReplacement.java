package com.leetcode.offer.day43;

/**
 * @author duson
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意:
 * 字符串长度 和 k 不会超过 104。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "ABAB", k = 2
 * <p>
 * 输出:
 * 4
 * <p>
 * 解释:
 * 用两个'A'替换为两个'B',反之亦然。
 * 示例 2:
 * <p>
 * 输入:
 * s = "AABABBA", k = 1
 * <p>
 * 输出:
 * 4
 * <p>
 * 解释:
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        final int len = s.length();
        int maxLength = 0;
        int start = 0, end = 0;
        int[] count = new int[26];
        int maxCount = 0;
        for (; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        System.out.println(characterReplacement.characterReplacement("AABABBA", 1));
        //System.out.println(characterReplacement.characterReplacement("ABAB", 2));

    }
}
