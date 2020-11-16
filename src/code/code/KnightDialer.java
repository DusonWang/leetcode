package code.code;

/**
 * @author duson
 * 国际象棋中的骑士可以按下图所示进行移动：
 * <p>
 * ?.? ? ? ? ? ?
 * <p>
 * <p>
 * 这一次，我们将?“骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳?N-1 步。每一步必须是从一个数字键跳到另一个数字键。
 * <p>
 * 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下?N 位数字。
 * <p>
 * 你能用这种方式拨出多少个不同的号码？
 * <p>
 * 因为答案可能很大，所以输出答案模?10^9 + 7。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：2
 * 输出：20
 * 示例 3：
 * <p>
 * 输入：3
 * 输出：46
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 5000
 * 通过次数2,403提交次数5,493
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/knight-dialer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KnightDialer {

    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        int mod = 1000000007;
        long a1 = 1, a2 = 1, a3 = 1, a4 = 1, a6 = 1, a7 = 1, a8 = 1, a9 = 1, a0 = 1;
        for (int i = 0; i < n - 1; i++) {
            long aa1 = (a8 + a6) % mod;
            long aa2 = (a7 + a9) % mod;
            long aa3 = (a4 + a8) % mod;
            long aa4 = (a3 + a9 + a0) % mod;
            long aa6 = (a1 + a7 + a0) % mod;
            long aa7 = (a2 + a6) % mod;
            long aa8 = (a1 + a3) % mod;
            long aa9 = (a2 + a4) % mod;
            long aa0 = (a4 + a6) % mod;
            a1 = aa1;
            a2 = aa2;
            a3 = aa3;
            a4 = aa4;
            a6 = aa6;
            a7 = aa7;
            a8 = aa8;
            a9 = aa9;
            a0 = aa0;
        }
        return (int) ((a1 + a2 + a3 + a4 + a6 + a7 + a8 + a9 + a0) % mod);
    }
}
