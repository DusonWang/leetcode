package com.leetcode.offer.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author duson
 * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
 * <p>
 * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = "ab", B = "ba"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：A = "abc", B = "bca"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：A = "abac", B = "baca"
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：A = "aabc", B = "abca"
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length == B.length <= 20
 * A 和 B 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母。
 * 通过次数1,122提交次数3,979
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-similar-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KSimilarity {

    public int kSimilarity(String a, String b) {
        if (a.equals(b)) {
            return 0;
        }
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(a);
        vis.add(a);
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            for (int sz = q.size(); sz > 0; sz--) {
                String s = q.poll();
                if (s == null) {
                    continue;
                }
                int i = 0;
                while (s.charAt(i) == b.charAt(i)) {
                    i++;
                }
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == b.charAt(j) || s.charAt(j) != b.charAt(i)) {
                        continue;
                    }
                    String temp = swap(s, i, j);
                    if (temp.equals(b)) {
                        return res;
                    }
                    if (vis.add(temp)) {
                        q.add(temp);
                    }
                }
            }
        }
        return res;
    }

    private String swap(String s, int i, int j) {
        char[] ca = s.toCharArray();
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
        return new String(ca);
    }
}
