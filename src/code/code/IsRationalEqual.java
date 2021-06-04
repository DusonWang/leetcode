package code.code;

import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 S 和 T，每个字符串代表一个非负有理数，只有当它们表示相同的数字时才返回 true；否则，返回 false。字符串中可以使用括号来表示有理数的重复部分。
 * <p>
 * 通常，有理数最多可以用三个部分来表示：整数部分?<IntegerPart>、小数非重复部分?<NonRepeatingPart>?和小数重复部分?<(><RepeatingPart><)>。数字可以用以下三种方法之一来表示：
 *
 * <IntegerPart>（例：0，12，123）
 * <IntegerPart><.><NonRepeatingPart> （例：0.5，2.12，2.0001）
 * <IntegerPart><.><NonRepeatingPart><(><RepeatingPart><)>（例：0.1(6)，0.9(9)，0.00(1212)）
 * 十进制展开的重复部分通常在一对圆括号内表示。例如：
 * <p>
 * 1 / 6 = 0.16666666... = 0.1(6) = 0.1666(6) = 0.166(66)
 * <p>
 * 0.1(6) 或?0.1666(6) 或?0.166(66) 都是?1 / 6 的正确表示形式。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "0.(52)", T = "0.5(25)"
 * 输出：true
 * 解释：因为 "0.(52)" 代表 0.52525252...，而 "0.5(25)" 代表 0.52525252525.....，则这两个字符串表示相同的数字。
 * 示例 2：
 * <p>
 * 输入：S = "0.1666(6)", T = "0.166(66)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：S = "0.9(9)", T = "1."
 * 输出：true
 * 解释：
 * "0.9(9)" 代表 0.999999999... 永远重复，等于 1 。[有关说明，请参阅此链接]
 * "1." 表示数字 1，其格式正确：(IntegerPart) = "1" 且 (NonRepeatingPart) = "" 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 每个部分仅由数字组成。
 * 整数部分?<IntegerPart>?不会以 2 个或更多的零开头。（对每个部分的数字没有其他限制）。
 * 1 <= <IntegerPart>.length <= 4
 * 0 <= <NonRepeatingPart>.length <= 4
 * 1 <= <RepeatingPart>.length <= 4
 * 通过次数1,135提交次数2,821
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/equal-rational-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsRationalEqual {

    private final List<Double> ratios = Arrays.asList(1.0, 1.0 / 9, 1.0 / 99, 1.0 / 999, 1.0 / 9999);

    public boolean isRationalEqual(String s, String t) {
        return Math.abs(computeValue(s) - computeValue(t)) < 1e-9;
    }

    private double computeValue(String s) {
        if (!s.contains("(")) {
            return Double.parseDouble(s);
        }
        int leftBracket = s.indexOf('(');
        int rightBracket = s.indexOf(')');
        double intNonRepeatingValue = Double.parseDouble(s.substring(0, leftBracket));
        int nonRepeatingLength = leftBracket - s.indexOf('.') - 1;
        int repeatingLength = rightBracket - leftBracket - 1;
        int repeatingValue = Integer.parseInt(s.substring(leftBracket + 1, rightBracket));
        return intNonRepeatingValue + repeatingValue * Math.pow(0.1, nonRepeatingLength) * ratios.get(repeatingLength);
    }
}
