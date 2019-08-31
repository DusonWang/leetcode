package com.leetcode.offer.day2;

import java.util.Stack;

/**
 * @author duson
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidKuoHao {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        final char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char tmp = stack.pop();
                if (tmp != '[' && c == ']' || tmp != '(' && c == ')' || tmp != '{' && c == '}') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidKuoHao validKuoHao = new ValidKuoHao();
        String[] test = new String[]{"]", "()", "()[]{}", "(]", "([)]", "{[]}"};
        for (String tmp : test) {
            System.out.println(tmp + "<>" + validKuoHao.isValid(tmp));
        }
    }
}
