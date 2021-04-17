package code.code;

/**
 * 给你两个非负整数?low 和?high?。请你返回?low 和?high?之间（包括二者）奇数的数目。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * 示例 2：
 * <p>
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 0 <= low <= high?<= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountOdds {

    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        } else {
            return (high - low) / 2 + 1;
        }
    }
}
