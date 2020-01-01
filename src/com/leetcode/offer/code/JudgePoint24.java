package com.leetcode.offer.code;

/**
 * @author duson
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 * <p>
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 * <p>
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/24-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JudgePoint24 {

    public boolean judgePoint24(int[] nums) {
        double[] nums2 = new double[4];
        for (int i = 0; i < 4; ++i) {
            nums2[i] = (double) nums[i];
        }
        return compute24Helper(nums2, 4);
    }

    private boolean compute24Helper(double[] nums, int n) {
        if (n == 1) {
            if (Math.abs(nums[0] - 24) <= 1e-10) {
                return true;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double a = nums[i];
                double b = nums[j];
                nums[j] = nums[n - 1];
                nums[i] = a + b;
                if (compute24Helper(nums, n - 1)) {
                    return true;
                }
                nums[i] = a - b;
                if (compute24Helper(nums, n - 1)) {
                    return true;
                }
                nums[i] = b - a;
                if (compute24Helper(nums, n - 1)) {
                    return true;
                }
                nums[i] = a * b;
                if (compute24Helper(nums, n - 1)) {
                    return true;
                }
                if (b != 0) {
                    nums[i] = a / b;
                    if (compute24Helper(nums, n - 1)) {
                        return true;
                    }
                }
                if (a != 0) {
                    nums[i] = b / a;
                    if (compute24Helper(nums, n - 1)) {
                        return true;
                    }
                }
                nums[i] = a;
                nums[j] = b;
            }
        }
        return false;
    }
}
