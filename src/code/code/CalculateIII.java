package code.code;

import java.util.Stack;

/**
 * @author duson
 * 实现一个基本的计算器来计算简单的表达式字符串。
 * <p>
 * 表达式字符串可以包含左括号 ( 和右括号 )，加号 + 和减号 -，非负 整数和空格 。
 * <p>
 * 表达式字符串只包含非负整数， +, -, *, / 操作符，左括号 ( ，右括号 )和空格 。整数除法需要向下截断。
 * <p>
 * 你可以假定给定的字符串总是有效的。所有的中间结果的范围为 [-2147483648, 2147483647]。
 * <p>
 * <p>
 * <p>
 * 一些例子：
 * <p>
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * <p>
 * <p>
 * 注：不要 使用内置库函数 eval。
 * <p>
 * <p>
 * <p>
 * 通过次数703提交次数2,112
 * 在真实的面试中遇到过这道题？
 */
public class CalculateIII {

    public int calculate(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] res = cal(chars, 0);
        return res[0];
    }

    private int[] cal(char[] chars, int start){
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int i = start;
        while(i < chars.length){
            char c = chars[i];
            while(i < chars.length - 1 && c == ' '){
                i++;
                c = chars[i];
            }
            if((c >= '0' && c <= '9')){
                num = num * 10 + (c- '0');
            } else if(c == '('){
                int[] tmp = cal(chars, i + 1);
                num = tmp[0];
                i = tmp[1];
            }
            if((!(c >= '0' && c <= '9') && c != '(') || i == chars.length - 1){
                switch(sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int last = stack.pop();
                        num = last * num;
                        stack.push(num);
                        break;
                    case '/':
                        last = stack.pop();
                        num = last / num;
                        stack.push(num);
                        break;
                    default:
                        stack.push(num);
                }
                num = 0;
                sign = c;
            }
            if( c == ')'){
                break;
            }
            i++;
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return new int[]{res, i};
    }
}
