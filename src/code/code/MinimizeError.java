package code.code;

import java.util.Arrays;

/**
 * @author duson
 * <p>
 * 给定一系列价格 [p1,p2...,pn] 和一个目标 target，将每个价格 pi 舍入为 Roundi(pi) 以使得舍入数组 [Round1(p1),Round2(p2)...,Roundn(pn)] 之和达到给定的目标值 target。每次舍入操作 Roundi(pi) 可以是向下舍 Floor(pi) 也可以是向上入 Ceil(pi)。
 * <p>
 * 如果舍入数组之和无论如何都无法达到目标值 target，就返回 -1。否则，以保留到小数点后三位的字符串格式返回最小的舍入误差，其定义为 Σ |Roundi(pi) - (pi)|（ i 从 1 到 n ）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = ["0.700","2.800","4.900"], target = 8
 * 输出："1.000"
 * 解释：
 * 使用 Floor，Ceil 和 Ceil 操作得到 (0.7 - 0) + (3 - 2.8) + (5 - 4.9) = 0.7 + 0.2 + 0.1 = 1.0 。
 * 示例 2：
 * <p>
 * 输入：prices = ["1.500","2.500","3.500"], target = 10
 * 输出："-1"
 * 解释：
 * 达到目标是不可能的。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 500
 * 表示价格的每个字符串 prices[i] 都代表一个介于 0 和 1000 之间的实数，并且正好有 3 个小数位。
 * target 介于 0 和 1000000 之间。
 * 在真实的面试中遇到过这道题？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimize-rounding-error-to-meet-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimizeError {

    public String minimizeError(String[] prices, int target) {
        int n = prices.length;
        int[] nums = new int[n];
        int size = 0;
        int sum = 0;
        for (String price : prices) {
            int pos = price.indexOf('.');
            int a = Integer.parseInt(price.substring(0, pos));
            int b = Integer.parseInt(price.substring(pos + 1));
            if (b == 0) {
                target -= a;
            } else {
                nums[size++] = 1000 - b;
                sum += a;
            }
        }

        if (target < sum || target > sum + size) {
            return "-1";
        }

        Arrays.sort(nums, 0, size);
        int ans = 0;
        for (int i = 0; i < target - sum; i++) {
            ans += nums[i];
        }
        for (int i = target - sum; i < size; i++) {
            ans += (1000 - nums[i]);
        }
        return String.format("%d.%03d", ans / 1000, ans % 1000);
    }
}
