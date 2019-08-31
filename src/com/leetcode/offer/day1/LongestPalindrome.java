package com.leetcode.offer.day1;

/**
 * @author duson
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        final char[] chars = s.toCharArray();
        final int len = s.length();
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < len; i++) {
            int count1 = count(chars, i, i);
            int count2 = count(chars, i, i + 1);
            int max = Math.max(count1, count2);
            if (max > endIndex - startIndex) {
                startIndex = i - (max - 1) / 2;
                endIndex = i + max / 2;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    private int count(char[] chars, int start, int end) {
        int left = start;
        int right = end;
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String[] array = new String[]{"babad", "cbbd"};
        for (String aa : array) {
            System.out.println(longestPalindrome.longestPalindrome(aa));
        }
    }
}
