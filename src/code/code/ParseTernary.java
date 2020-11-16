package code.code;

/**
 * @author duson
 * 给定一个以字符串表示的任意嵌套的三元表达式，计算表达式的值。你可以假定给定的表达式始终都是有效的并且只包含数字 0-9, ?, :, T 和 F (T 和 F 分别表示真和假）。
 * <p>
 * 注意：
 * <p>
 * 给定的字符串长度 ≤ 10000。
 * 所包含的数字都只有一位数。
 * 条件表达式从右至左结合（和大多数程序设计语言类似）。
 * 条件是 T 和 F其一，即条件永远不会是数字。
 * 表达式的结果是数字 0-9, T 或者 F。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： "T?2:3"
 * <p>
 * 输出： "2"
 * <p>
 * 解释： 如果条件为真，结果为 2；否则，结果为 3。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入： "F?1:T?4:5"
 * <p>
 * 输出： "4"
 * <p>
 * 解释： 条件表达式自右向左结合。使用括号的话，相当于：
 * <p>
 * "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 * -> "(F ? 1 : 4)"                 或者     -> "(T ? 4 : 5)"
 * -> "4"                                    -> "4"
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入： "T?T?F:5:3"
 * <p>
 * 输出： "F"
 * <p>
 * 解释： 条件表达式自右向左结合。使用括号的话，相当于：
 * <p>
 * "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 * -> "(T ? F : 3)"                 或者       -> "(T ? F : 5)"
 * -> "F"                                     -> "F"
 *  
 * <p>
 * 在真实的面试中遇到过这道题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ternary-expression-parser
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ParseTernary {

    public String parseTernary(String expression) {
        if (expression.length() == 1) {
            return expression;
        }
        int pos = 2;
        int left = 1;
        int len = expression.length();
        while (pos < len) {
            if (expression.charAt(pos) == '?') {
                left++;
            } else if (expression.charAt(pos) == ':') {
                left--;
            }
            if (left == 0) {
                break;
            }
            pos++;
        }
        if (expression.charAt(0) == 'T') {
            return parseTernary(expression.substring(2, pos));
        } else {
            return parseTernary(expression.substring(pos + 1));
        }
    }
}
