package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 * <p>
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 * <p>
 * 字母异位词 指字母相同，但排列不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 * 示例 2：
 * <p>
 * 输出：s = "leetcode", t = "practice"
 * 输出：5
 * 提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
 * 示例 3：
 * <p>
 * 输出：s = "anagram", t = "mangaar"
 * 输出：0
 * 提示："anagram" 和 "mangaar" 本身就是一组字母异位词。
 * 示例 4：
 * <p>
 * 输出：s = "xxyyzz", t = "xxyyzz"
 * 输出：0
 * 示例 5：
 * <p>
 * 输出：s = "friend", t = "family"
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s 和 t 只包含小写英文字母
 * 通过次数2,838提交次数4,123
 * 在真实的面试中遇到过这道题？
 */
public class MinSteps2 {

    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[t.charAt(i) - 'a'];
        }
        return Arrays.stream(count).map(Math::abs).sum() / 2;
    }
}
