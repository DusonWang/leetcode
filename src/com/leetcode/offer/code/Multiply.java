package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        final char[] ret = new char[num1.length() + num2.length()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = '0';
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            int num1Val = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num2Val = num2.charAt(j) - '0';
                int sum = (ret[i + j + 1] - '0') + num1Val * num2Val;
                ret[i + j + 1] = (char) (sum % 10 + '0');
                ret[i + j] += sum / 10;
            }
        }

        for (int i = 0; i < ret.length; i++) {
            if (ret[i] != '0' || i == ret.length - 1) {
                return new String(ret, i, ret.length - i);
            }
        }
        return "0";
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("123", "456"));
        System.out.println(multiply.multiply("2", "3"));

    }
}
