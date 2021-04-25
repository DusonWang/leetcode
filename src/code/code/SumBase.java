package code.code;

/**
 * 给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
 * <p>
 * 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 34, k = 6
 * 输出：9
 * 解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
 * 示例 2：
 * <p>
 * 输入：n = 10, k = 10
 * 输出：1
 * 解释：n 本身就是 10 进制。 1 + 0 = 1 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 2 <= k <= 10
 * 通过次数3,200提交次数4,069
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-digits-in-base-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumBase {

    public int sumBase(int n, int k) {
        int res = 0;
        while (n != 0) {
            res += n % k;
            n /= k;
        }
        return res;
    }

    public static void main(String[] args) {
        SumBase sumBase = new SumBase();
        System.out.println(sumBase.sumBase(34, 6));
        System.out.println(sumBase.sumBase(10, 10));

    }

}
