package com.leetcode.offer.code;

/**
 * @author duson
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 * <p>
 * 如果方程没有解，请返回“No solution”。
 * <p>
 * 如果方程有无限解，则返回“Infinite solutions”。
 * <p>
 * 如果方程中只有一个解，要保证返回值 x 是一个整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 * <p>
 * 输入: "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 * <p>
 * 输入: "2x=x"
 * 输出: "x=0"
 * 示例 4:
 * <p>
 * 输入: "2x+3x-6x=x+2"
 * 输出: "x=-1"
 * 示例 5:
 * <p>
 * 输入: "x=x+2"
 * 输出: "No solution"
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/solve-the-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveEquation {

    public String solveEquation(String equation) {
        int coefficient = 0, constant = 0;
        equation = equation + "#";
        Integer number = null;
        int sign = 1, left = 1;
        for (char c : equation.toCharArray()) {
            if ('0' <= c && c <= '9') {
                number = number == null ? c - '0' : number * 10 + c - '0';
            } else if (c == 'x') {
                coefficient += left * sign * (number == null ? 1 : number);
                sign = 1;
                number = null;
            } else if (c == '+' || c == '-' || c == '#') {
                if (number != null) {
                    constant += left * sign * number;
                    number = null;
                }
                sign = c == '+' ? 1 : -1;
            } else {// if (c == '=')
                if (number != null) {
                    constant += left * sign * number;
                    number = null;
                }
                left = -1;
                sign = 1;
            }
        }
        if (coefficient == 0 && constant == 0) {
            return "Infinite solutions";
        } else if (coefficient == 0) {
            return "No solution";
        } else {
            return "x=" + -constant / coefficient;
        }
    }
}
