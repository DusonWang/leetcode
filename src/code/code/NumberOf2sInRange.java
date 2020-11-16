package code.code;

/**
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * <p>
 * 示例:
 * <p>
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * 提示：
 * <p>
 * n <= 10^9
 * 通过次数1,013提交次数2,512
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-2s-in-range-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOf2sInRange {

    public int numberOf2sInRange(int n) {
        int ans = 0;
        for (int mask = 1; mask <= n; mask *= 10) {
            int leftMid = n / mask;
            int right = n % mask;
            int left = (leftMid + 7) / 10;
            ans += left * mask;
            if (leftMid % 10 == 2) {
                ans += right + 1;
            }
        }
        return ans;
    }
}
