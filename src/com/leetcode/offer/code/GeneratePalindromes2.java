package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author duson
 * <p>
 * 给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
 * <p>
 * 如不能形成任何回文排列时，则返回一个空列表。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "aabb"
 * 输出: ["abba", "baab"]
 * 示例 2：
 * <p>
 * 输入: "abc"
 * 输出: []
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GeneratePalindromes2 {

    private Set<String> set = new HashSet<>();

    public List<String> generatePalindromes(String s) {
        int[] map = new int[128];
        char[] st = new char[s.length() / 2];
        if (!canPermutePalindrome(s, map)) {
            return new ArrayList<>();
        }
        char ch = 0;
        int k = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 == 1) {
                ch = (char) i;
            }
            for (int j = 0; j < map[i] / 2; j++) {
                st[k++] = (char) i;
            }
        }
        permute(st, 0, ch);
        return new ArrayList<>(set);
    }

    private boolean canPermutePalindrome(String s, int[] map) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    private void permute(char[] s, int l, char ch) {
        if (l == s.length) {
            set.add(new String(s) + (ch == 0 ? "" : ch) + new StringBuffer(new String(s)).reverse());
        } else {
            for (int i = l; i < s.length; i++) {
                if (s[l] != s[i] || l == i) {
                    swap(s, l, i);
                    permute(s, l + 1, ch);
                    swap(s, l, i);
                }
            }
        }
    }
}
