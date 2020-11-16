package code.code;

/**
 * @author duson
 * 给定一个在 0 到 9 之间的整数 d，和两个正整数 low 和 high 分别作为上下界。返回 d 在 low 和 high 之间的整数中出现的次数，包括边界 low 和 high。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：d = 1, low = 1, high = 13
 * 输出：6
 * 解释：
 * 数字 d=1 在 1,10,11,12,13 中出现 6 次。注意 d=1 在数字 11 中出现两次。
 * 示例 2：
 * <p>
 * 输入：d = 3, low = 100, high = 250
 * 输出：35
 * 解释：
 * 数字 d=3 在 103,113,123,130,131,...,238,239,243 出现 35 次。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= d <= 9
 * 1 <= low <= high <= 2×10^8
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/digit-count-in-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DigitsCount {

    private int digitsCountMath(int d, int num) {
        long di = 10;
        long ans = 0;
        for (int i = 1; (d == 0 ? di : i) <= num; i *= 10) {
            di = i * 10;
            int ndi = (int) ((num % di) / i);
            ans += (num / di - (d == 0 ? 1 : 0)) * i;
            if (d == ndi) {
                ans += (num % i) + 1;
            } else if (ndi > d) {
                ans += i;
            }
        }
        return (int) ans;
    }

    public int digitsCount(int d, int low, int high) {
        return digitsCountMath(d, high) - digitsCountMath(d, low - 1);
    }
}
