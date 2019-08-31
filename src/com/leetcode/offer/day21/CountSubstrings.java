package com.leetcode.offer.day21;

/**
 * @author duson
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 * <p>
 * 输入的字符串长度不会超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSubstrings {

    private boolean huiWen(String s) {
        if ("".equals(s) || s.length() == 0) {
            return false;
        }
        int len = s.length();
        for (int i = 0; i <= len / 2; ++i) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private int countSubstrings2(String s) {
        final int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {
                if (huiWen(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private int cnt = 0;

    public int countSubstrings(String s) {
        final int sLen = s.length();
        for (int i = 0; i < s.length(); i++) {
            expend(s, i, i, sLen);
            expend(s, i, i + 1, sLen);
        }
        return cnt;
    }

    private void expend(String s, int start, int end, int sLen) {
        while (start >= 0 && end < sLen && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings("abc"));
        System.out.println(countSubstrings.countSubstrings("aaa"));
    }
}
