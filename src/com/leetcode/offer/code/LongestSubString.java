package com.leetcode.offer.code;


import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int len = array.length;
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            Integer index = map.get(array[i]);
            if (index != null) {
                left = Math.max(left, index + 1);
            }
            map.put(array[i], i);
            max = Math.max(i - left + 1, max);
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        final int len = s.length();
        final int[] index = new int[128];
        final char[] array = s.toCharArray();
        for (int j = 0, i = 0; j < len; j++) {
            i = Math.max(index[array[j]], i);
            ans = Math.max(ans, j - i + 1);
            index[array[j]] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] test = new String[]{"abcabcbb", "bdbbbb", "pwwkew", "au"};
        for (String ss : test) {
            //System.out.println(lengthOfLongestSubstring(ss));
            System.out.println(lengthOfLongestSubstring2(ss));
        }
    }
}
