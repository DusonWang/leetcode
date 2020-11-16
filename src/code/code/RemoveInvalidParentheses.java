package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 *     HARD
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * <p>
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 * <p>
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 * <p>
 * 输入: ")("
 * 输出: [""]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveInvalidParentheses {

    private List<String> res;

    public List<String> removeInvalidParentheses(String s) {
        res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        dfs(s, 0, 0, '(', ')');
        return res;
    }

    private void dfs(String s, int iStart, int jStart, char open, char close) {
        int count = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == open) {
                count++;
            }
            if (s.charAt(i) == close) {
                count--;
            }
            if (count >= 0) {
                continue;
            }

            //()())()
            for (int j = jStart; j <= i; j++) {
                if (s.charAt(j) == close && (j == jStart || s.charAt(j - 1) != close)) {
                    dfs(s.substring(0, j) + s.substring(j + 1), i, j, open, close);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if (open == '(') {
            dfs(reverse, 0, 0, ')', '(');
        } else {
            res.add(reverse);
        }
    }
}
