package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示。
 * <p>
 * 使用三元组表示金字塔的堆砌规则如下：
 * <p>
 * 对于三元组(A, B, C) ，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
 * <p>
 * 初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
 * <p>
 * 如果可以由基层一直堆到塔尖就返回 true，否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 * 输出: true
 * 解析:
 * 可以堆砌成这样的金字塔:
 * A
 * / \
 * G   E
 * / \ / \
 * B   C   D
 * <p>
 * 因为符合('B', 'C', 'G'), ('C', 'D', 'E') 和 ('G', 'E', 'A') 三种规则。
 * 示例 2:
 * <p>
 * 输入: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 * 输出: false
 * 解析:
 * 无法一直堆到塔尖。
 * 注意, 允许存在像 (A, B, C) 和 (A, B, D) 这样的三元组，其中 C != D。
 *  
 * <p>
 * 注意：
 * <p>
 * bottom 的长度范围在 [2, 8]。
 * allowed 的长度范围在[0, 200]。
 * 方块的标记字母范围为{'A', 'B', 'C', 'D', 'E', 'F', 'G'}。
 * 通过次数1,601提交次数2,985
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pyramid-transition-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PyramidTransition {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> m = new HashMap<>();
        for (String s : allowed) {
            String pre = s.substring(0, 2);
            m.putIfAbsent(pre, new HashSet<>());
            m.get(pre).add(s.charAt(2));
        }
        return dfs(bottom, "", m, 1);
    }

    private boolean dfs(String row, String nextRow, Map<String, Set<Character>> allowed, int i) {
        if (row.length() == 1) {
            return true;
        }
        if (nextRow.length() + 1 == row.length()) {
            return dfs(nextRow, "", allowed, 1);
        }
        for (Character c : allowed.getOrDefault(row.substring(i - 1, i + 1), new HashSet<>())) {
            if (dfs(row, nextRow + c, allowed, i + 1)) {
                return true;
            }
        }
        return false;
    }
}
