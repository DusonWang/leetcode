package code.code;

/**
 * 给你一个非常大的整数 n 和一个整数数字 x ，大整数 n用一个字符串表示。n 中每一位数字和数字 x 都处于闭区间 [1, 9] 中，且 n 可能表示一个 负数 。
 * <p>
 * 你打算通过在 n 的十进制表示的任意位置插入 x 来 最大化 n 的 数值 。但 不能 在负号的左边插入 x 。
 * <p>
 * 例如，如果 n = 73 且 x = 6 ，那么最佳方案是将 6 插入 7 和 3 之间，使 n = 763 。
 * 如果 n = -55 且 x = 2 ，那么最佳方案是将 2 插在第一个 5 之前，使 n = -255 。
 * 返回插入操作后，用字符串表示的n 的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = "99", x = 9
 * 输出："999"
 * 解释：不管在哪里插入 9 ，结果都是相同的。
 * 示例 2：
 * <p>
 * 输入：n = "-13", x = 2
 * 输出："-123"
 * 解释：向 n 中插入 x 可以得到 -213、-123 或者 -132 ，三者中最大的是 -123 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n.length <= 105
 * 1 <= x <= 9
 * n 中每一位的数字都在闭区间 [1, 9] 中。
 * n代表一个有效的整数。
 * 当 n 表示负数时，将会以字符 '-' 开始。
 * 通过次数5,029提交次数14,631
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-value-after-insertion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxValue3 {

    public String maxValue(String n, int x) {
        boolean neg = false;
        if (n.charAt(0) == '-') {
            neg = true;
            n = n.substring(1);
        }
        for (int i = 0; i < n.length(); i++) {
            int current = n.charAt(i) - '0';
            if (!neg && current < x || neg && current > x) {
                return (neg ? "-" : "") + n.substring(0, i) + x + n.substring(i);
            }
        }
        return (neg ? "-" : "") + n + x;
    }

}
