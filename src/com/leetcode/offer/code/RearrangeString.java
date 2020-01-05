package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author duson
 * 给你一个非空的字符串 s 和一个整数 k，你要将这个字符串中的字母进行重新排列，使得重排后的字符串中相同字母的位置间隔距离至少为 k。
 * <p>
 * 所有输入的字符串都由小写字母组成，如果找不到距离至少为 k 的重排结果，请返回一个空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "aabbcc", k = 3
 * 输出: "abcabc"
 * 解释: 相同的字母在新的字符串中间隔至少 3 个单位距离。
 * 示例 2:
 * <p>
 * 输入: s = "aaabc", k = 3
 * 输出: ""
 * 解释: 没有办法找到可能的重排结果。
 * 示例 3:
 * <p>
 * 输入: s = "aaadbbcc", k = 2
 * 输出: "abacabcd"
 * 解释: 相同的字母在新的字符串中间隔至少 2 个单位距离。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rearrange-string-k-distance-apart
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RearrangeString {

    public String rearrangeString(String s, int k) {
        if (k <= 1) {
            return s;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> count[o2] - count[o1] == 0 ? o1 - o2 : count[o2] - count[o1]);

        for (int i = 0; i < 26; ++i) {
            if (count[i] != 0) {
                pq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < k && i + j < s.length(); ++j) {
                if (pq.isEmpty()) {
                    return "";
                }
                int c = pq.poll();
                temp.add(c);
                --count[c];
                sb.append((char) ('a' + c));
            }
            for (int c : temp) {
                if (count[c] != 0) {
                    pq.add(c);
                }
            }
        }
        return sb.toString();
    }
}
