package com.leetcode.offer.code;

import java.util.Stack;

/**
 * @author duson
 * <p>
 * 实现一个基本的计算器来计算简单的表达式字符串。
 * <p>
 * 表达式字符串可以包含左括号 ( 和右括号 )，加号 + 和减号 -，非负?整数和空格?。
 * <p>
 * 表达式字符串只包含非负整数，?+, -, *, /?操作符，左括号 (?，右括号 )和空格?。整数除法需要向下截断。
 * <p>
 * 你可以假定给定的字符串总是有效的。所有的中间结果的范围为 [-2147483648, 2147483647]。
 * <p>
 * ?
 * <p>
 * 一些例子：
 * <p>
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * ?
 * <p>
 * 注：不要 使用内置库函数 eval。
 * <p>
 * ?
 * <p>
 * 通过次数1,165提交次数3,329
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Calculate3 {

    private int index = 0;

    public int calculate(String s) {
        char[] ch = s.toCharArray();
        return cal(ch);
    }

    private int cal(char[] ch) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (; index < ch.length; index++) {
            char c = ch[index];
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                index++;
                num = cal(ch);
            }
            if (!Character.isDigit(c) && c != ' ' || index == ch.length - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                    default:
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
