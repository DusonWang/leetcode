package com.leetcode.offer.day27;

/**
 * @author duson
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstringKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        int[] map = new int[256];
        int walker = 0;
        int runner = 0;
        int count = 0;
        while (runner < s.length()) {
            if (map[s.charAt(runner++)]++ == 0) {
                count++;
            }
            while (count > k) {
                if (map[s.charAt(walker++)]-- == 1) {
                    count--;
                }
            }
            res = Math.max(res, runner - walker);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringKDistinct lo = new LengthOfLongestSubstringKDistinct();
        System.out.println(lo.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(lo.lengthOfLongestSubstringKDistinct("aa", 1));
    }
}
