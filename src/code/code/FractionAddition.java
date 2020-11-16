package code.code;

/**
 * @author duson
 * 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 * <p>
 * 示例 1:
 * <p>
 * 输入:"-1/2+1/2"
 * 输出: "0/1"
 *  示例 2:
 * <p>
 * 输入:"-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 * <p>
 * 输入:"1/3-1/2"
 * 输出: "-1/6"
 * 示例 4:
 * <p>
 * 输入:"5/3+1/3"
 * 输出: "2/1"
 * 说明:
 * <p>
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 * 通过次数1,083提交次数2,249
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-addition-and-subtraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FractionAddition {

    public String fractionAddition(String expression) {
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '-') {
                sb.append('+');
            }
            sb.append(c);
        }
        if (sb.charAt(0) == '+') {
            sb.deleteCharAt(0);
        }
        String[] fraction = sb.toString().split("\\+");
        int up = 0, down = 1;
        for (String s : fraction) {
            String[] cur = s.split("/");
            int numerator = Integer.parseInt(cur[0]);
            int denominator = Integer.parseInt(cur[1]);
            up = up * denominator + down * numerator;
            down *= denominator;
        }
        int common = gcd(Math.abs(up), Math.abs(down));
        up /= common;
        down /= common;
        return up + "/" + down;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
