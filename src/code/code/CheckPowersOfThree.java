package code.code;

/**
 * 给你一个整数?n?，如果你可以将?n?表示成若干个不同的三的幂之和，请你返回?true?，否则请返回 false?。
 * <p>
 * 对于一个整数 y?，如果存在整数 x?满足 y == 3x?，我们称这个整数 y?是三的幂。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * 示例 2：
 * <p>
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * 示例 3：
 * <p>
 * 输入：n = 21
 * 输出：false
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 107
 * 通过次数4,005提交次数6,128
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-number-is-a-sum-of-powers-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckPowersOfThree {

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 > 1) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}
