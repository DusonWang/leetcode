package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 给你一个字符串?s ，请你返回满足以下条件且出现次数最大的?任意?子串的出现次数：
 * <p>
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于?minSize 且小于等于?maxSize 。
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * 输出：2
 * 解释：子串 "aab" 在原字符串中出现了 2 次。
 * 它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
 * 示例 2：
 * <p>
 * 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * 输出：2
 * 解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
 * 示例 3：
 * <p>
 * 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * 输出：0
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 1 <= maxLetters <= 26
 * 1 <= minSize <= maxSize <= min(26, s.length)
 * s?只包含小写英文字母。
 * 通过次数2,796提交次数6,502
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxFreq {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int l = 0;
        int r = 0;
        int max = 0;
        int[] charM = new int[128];
        int count = 0;
        Map<String, Integer> resMap = new HashMap<>();
        int len = s.length();
        while (r < len) {
            while (r < len && r - l < minSize) {
                if (charM[s.charAt(r++)]++ == 0) {
                    count++;
                }
            }
            if (count <= maxLetters) {
                String key = s.substring(l, r);
                int cur = resMap.getOrDefault(key, 0) + 1;
                max = Math.max(cur, max);
                resMap.put(key, cur);
            }
            if (--charM[s.charAt(l++)] == 0) {
                count--;
            }
        }
        return max;
    }

}
