package code.code;

/**
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 * <p>
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 * <p>
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, index = 2,  maxSum = 6
 * 输出：2
 * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
 * 示例 2：
 * <p>
 * 输入：n = 6, index = 1,  maxSum = 10
 * 输出：3
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= maxSum <= 109
 * 0 <= index < n
 * 通过次数3,693提交次数14,358
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-value-at-a-given-index-in-a-bounded-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxValue2 {

    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0, right = maxSum, mid;
        while (left < right) {
            mid = (left + right + 1) / 2;
            if (test(n, index, mid) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }

    private long test(int n, int index, int a) {
        int b = Math.max(a - index, 0);
        long res = (long) (a + b) * (a - b + 1) / 2;
        b = Math.max(a - ((n - 1) - index), 0);
        res += (long) (a + b) * (a - b + 1) / 2;
        return res - a;
    }
}
