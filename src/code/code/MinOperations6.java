package code.code;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x?恰好 减到?0 ，返回 最小操作数 ；否则，返回 -1 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 * 通过次数6,684提交次数23,640
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-reduce-x-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinOperations6 {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int maxLength = -1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int cnt = sum - x;
        if (cnt < 0) {
            return -1;
        }
        int sumNumbs = 0;
        while (right < n) {
            sumNumbs += nums[right];
            while (sumNumbs > cnt) {
                sumNumbs -= nums[left];
                left++;
            }
            if (sumNumbs == cnt) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength == -1 ? -1 : n - maxLength;
    }
}
