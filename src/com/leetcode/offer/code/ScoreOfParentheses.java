package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 *  
 * <p>
 * 提示：
 * <p>
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        int layer = -1;
        for (int i = 0; i < chars.length; i++) {
            layer += chars[i] == '(' ? 1 : -1;
            if (chars[i] == '(' && chars[i + 1] == ')') {
                res += 1 << layer;
            }
        }
        return res;
    }
}
