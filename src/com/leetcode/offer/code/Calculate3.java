package com.leetcode.offer.code;

import java.util.Stack;

/**
 * @author duson
 * <p>
 * ʵ��һ�������ļ�����������򵥵ı��ʽ�ַ�����
 * <p>
 * ���ʽ�ַ������԰��������� ( �������� )���Ӻ� + �ͼ��� -���Ǹ�?�����Ϳո�?��
 * <p>
 * ���ʽ�ַ���ֻ�����Ǹ�������?+, -, *, /?�������������� (?�������� )�Ϳո�?������������Ҫ���½ضϡ�
 * <p>
 * ����Լٶ��������ַ���������Ч�ġ����е��м����ķ�ΧΪ [-2147483648, 2147483647]��
 * <p>
 * ?
 * <p>
 * һЩ���ӣ�
 * <p>
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * ?
 * <p>
 * ע����Ҫ ʹ�����ÿ⺯�� eval��
 * <p>
 * ?
 * <p>
 * ͨ������1,165�ύ����3,329
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/basic-calculator-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
