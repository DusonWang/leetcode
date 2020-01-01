package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
 * 示例 2：
 * <p>
 * 输入：S = "home", K = 5
 * 输出：0
 * 解释：
 * 注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 10^4
 * S 中的所有字符均为小写英文字母
 * 1 <= K <= 10^4
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-length-substrings-with-no-repeated-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumKLenSubstrNoRepeats {

    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        if (k == 1) {
            return s.length();
        }
        int left = 0;
        int[] letter = new int[26];
        Arrays.fill(letter, -1);
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, letter[c - 'a'] + 1);
            if (right - left + 1 == k) {
                left++;
                ans++;
            }
            letter[c - 'a'] = right;
        }
        return ans;
    }
}
