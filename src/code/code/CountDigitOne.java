package code.code;

/**
 * @author duson
 * <p>
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * 示例:
 * <p>
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountDigitOne {

    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        }
        return ones;
    }
}
