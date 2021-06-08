package code.code;

/**
 * 给你一个整数n，请你将1到 n的二进制表示连接起来，并返回连接结果对应的 十进制数字对 109+ 7取余的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：二进制的 "1" 对应着十进制的 1 。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：27
 * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 * 示例 3：
 * <p>
 * 输入：n = 12
 * 输出：505379714
 * 解释：连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 109 + 7 取余后，结果为 505379714 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 通过次数4,916提交次数10,780
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/concatenation-of-consecutive-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConcatenatedBinary {

    public int concatenatedBinary(int n) {
        int m = 1_000_000_007;
        int b = 0;
        long ans = 0;
        for (int k = 1; k <= n; k++) {
            if ((k & (k - 1)) == 0) {
                ++b;
            }
            ans <<= b;
            ans += k;
            ans %= m;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        ConcatenatedBinary concatenatedBinary = new ConcatenatedBinary();
        System.out.println(concatenatedBinary.concatenatedBinary(12));
    }
}
