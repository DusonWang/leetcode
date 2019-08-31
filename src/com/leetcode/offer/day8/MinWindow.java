package com.leetcode.offer.day8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {

//    public String minWindow2(String s, String t) {
//        char[] sChars = s.toCharArray();
//        char[] pChars = t.toCharArray();
//        int[] pMap = new int[128];
//        int i = 0, j = 0;
//        int count = pChars.length;
//        int minLen = s.length() + 1,l = 0,r = 0;
//        for (char pChar : pChars) {
//            pMap[pChar]++;
//        }
//        while (j < sChars.length) {
//            if (pMap[sChars[j]] > 0) {
//                count--;
//            }
//            pMap[sChars[j]]--;
//            j++;
//            while (count == 0) {
//                if (j - i < minLen) {
//                    minLen = j - i;
//                    l = i;
//                    r = j;
//                }
//                pMap[sChars[i]]++;
//                if (pMap[sChars[i]] > 0) {
//                    count++;
//                }
//                i++;
//            }
//        }
//        return minLen == s.length() + 1 ? "" : s.substring(l, r);
//    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char chr = t.charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int ansLeft = 0;
        int ansRight = -1;
        int ansLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char charRight = s.charAt(right);
            if (map.containsKey(charRight)) {
                map.put(charRight, map.get(charRight) - 1);
                while (match(map)) {
                    int tempLen = right - left + 1;
                    if (tempLen < ansLen) {
                        ansLeft = left;
                        ansRight = right;
                        ansLen = tempLen;
                    }
                    char key = s.charAt(left);
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    }
                    left++;
                }
            }
            right++;
        }
        return s.substring(ansLeft, ansRight + 1);
    }

    private boolean match(Map<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
    }
}
