package com.leetcode.offer.code;


/**
 * @author duson
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 * <p>
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int max = 0;
        int disNums = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 0) {
                disNums++;
            }
            count[s.charAt(i)]++;
            while (disNums > 2) {
                count[s.charAt(j)]--;
                if (count[s.charAt(j)] == 0) {
                    disNums--;
                }
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
