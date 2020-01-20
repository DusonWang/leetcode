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
        String[] parts = equation.split("=");
        String leftPart = parts[0], rightPart = parts[1];
        int[] leftVal = evaluate(leftPart), rightVal = evaluate(rightPart);
        int cntX = leftVal[0] - rightVal[0];
        int cntNum = leftVal[1] - rightVal[1];
        if (cntX == 0) {
            if (cntNum != 0) {
                return "No solution";
            }
            return "Infinite solutions";
        }
        int valX = (-cntNum) / cntX;
        return "x=" + valX;
    }

    private int[] evaluate(String exp) {
        int[] result = new int[2];
        String[] expElements = exp.split("(?=[-+])");
        for (String ele : expElements) {
            if ("+x".equals(ele) || "x".equals(ele)) {
                result[0]++;
            } else if ("-x".equals(ele)) {
                result[0]--;
            } else if (ele.contains("x")) {
                result[0] += Integer.parseInt(ele.substring(0, ele.indexOf("x")));
            } else {
                result[1] += Integer.parseInt(ele);
            }
        }
        return result;
    }
}
