package com.leetcode.offer.code;

/**
 * @author duson
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aaabb", k = 3
 * <p>
 * 输出:
 * 3
 * <p>
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 * <p>
 * 输入:
 * s = "ababbc", k = 2
 * <p>
 * 输出:
 * 5
 * <p>
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstringK {

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        if (k < 2) {
            return s.length();
        }
        char[] arrays = s.toCharArray();
        return cnt(arrays, k, 0, arrays.length - 1);
    }

    private int cnt(char[] arrays, int k, int left, int right) {
        if (right - left + 1 < k) {
            return 0;
        }
        int[] times = new int[26];
        for (int i = left; i <= right; ++i) {
            ++times[arrays[i] - 'a'];
        }
        while (right - left + 1 >= k && times[arrays[left] - 'a'] < k) {
            ++left;
        }
        while (right - left + 1 >= k && times[arrays[right] - 'a'] < k) {
            --right;
        }
        if (right - left + 1 < k) {
            return 0;
        }
        for (int i = left; i <= right; ++i) {
            if (times[arrays[i] - 'a'] < k) {
                return Math.max(cnt(arrays, k, left, i - 1), cnt(arrays, k, i + 1, right));
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        LongestSubstringK longestSubstringK = new LongestSubstringK();
        System.out.println(longestSubstringK.longestSubstring("aaabbb", 3));
        //System.out.println(longestSubstring.longestSubstring("ababbc", 2));

    }
}
