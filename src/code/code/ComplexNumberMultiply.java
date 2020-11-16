package code.code;

/**
 * @author duson
 * 给定两个表示复数的字符串。
 * <p>
 * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1+1i", "1+1i"
 * 输出: "0+2i"
 * 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2:
 * <p>
 * 输入: "1+-1i", "1+-1i"
 * 输出: "0+-2i"
 * 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 * 注意:
 * <p>
 * 输入字符串不包含额外的空格。
 * 输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complex-number-multiplication
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ComplexNumberMultiply {

    public String complexNumberMultiply(String a, String b) {
        String[] elementsFromPart1 = a.split("\\+");
        String[] elementsFromPart2 = b.split("\\+");

        int aFromPartOne = Integer.parseInt(elementsFromPart1[0]);
        int bFromPartOne = Integer.parseInt(elementsFromPart1[1].split("i")[0]);

        int aFromPartTwo = Integer.parseInt(elementsFromPart2[0]);
        int bFromPartTwo = Integer.parseInt(elementsFromPart2[1].split("i")[0]);

        int intNum =  (aFromPartOne * aFromPartTwo) + (bFromPartOne * bFromPartTwo) * -1;
        int compNum = (aFromPartOne * bFromPartTwo + bFromPartOne * aFromPartTwo);

        return intNum + "+" + compNum + "i";
    }
}
