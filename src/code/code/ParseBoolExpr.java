package code.code;

import java.util.Stack;

/**
 * ����һ�����ַ�����ʽ������?�������ʽ��boolean�� expression�����ظ�ʽ����������
 * <p>
 * ��Ч�ı��ʽ����ѭ����Լ����
 * <p>
 * "t"��������Ϊ True
 * "f"��������Ϊ False
 * "!(expr)"���������Ϊ���ڲ����ʽ expr �����߼� �ǵ����㣨NOT��
 * "&(expr1,expr2,...)"���������Ϊ�� 2 ���������ڲ����ʽ expr1, expr2, ... �����߼� ������㣨AND��
 * "|(expr1,expr2,...)"���������Ϊ�� 2 ���������ڲ����ʽ expr1, expr2, ... �����߼� ������㣨OR��
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺expression = "!(f)"
 * �����true
 * ʾ�� 2��
 * <p>
 * ���룺expression = "|(f,t)"
 * �����true
 * ʾ�� 3��
 * <p>
 * ���룺expression = "&(t,f)"
 * �����false
 * ʾ�� 4��
 * <p>
 * ���룺expression = "|(&(t,f,t),!(t))"
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] �� {'(', ')', '&', '|', '!', 't', 'f', ','} �е��ַ���ɡ�
 * expression ����������ʽ��������Ч���ʽ����ʾһ������ֵ��
 * ͨ������2,102�ύ����3,921
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/parsing-a-boolean-expression
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author duson
 */
public class ParseBoolExpr {

    public boolean parseBoolExpr(String expression) {
        if (expression == null || expression.length() == 0) {
            return false;
        }

        Stack<Character> ops = new Stack<>();
        Stack<Boolean> operands = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == 'f') {
                operands.push(false);
            } else if (ch == 't') {
                operands.push(true);
            } else if (ch == '(') {
                operands.push(null);
            } else if (ch == ')') {
                char operator = ops.pop();
                boolean res = true;
                if (operator == '|') {
                    res = false;
                }
                while (!operands.isEmpty() && operands.peek() != null) {
                    if (operator == '|') {
                        res |= operands.pop();
                    } else if (operator == '&') {
                        res &= operands.pop();
                    } else if (operator == '!') {
                        res = !operands.pop();
                    }
                }
                operands.pop();
                operands.push(res);

            } else if (ch == ',') {
            } else {
                ops.push(ch);
            }
        }
        return operands.peek();
    }

}
