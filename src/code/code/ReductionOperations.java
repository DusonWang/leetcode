package code.code;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你的目标是令 nums 中的所有元素相等。完成一次减少操作需要遵照下面的几个步骤：
 * <p>
 * 找出 nums 中的 最大 值。记这个值为 largest 并取其下标 i （下标从 0 开始计数）。如果有多个元素都是最大值，则取最小的 i 。
 * 找出 nums 中的 下一个最大 值，这个值 严格小于 largest ，记为 nextLargest 。
 * 将 nums[i] 减少到 nextLargest 。
 * 返回使 nums 中的所有元素相等的操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,1,3]
 * 输出：3
 * 解释：需要 3 次操作使 nums 中的所有元素相等：
 * 1. largest = 5 下标为 0 。nextLargest = 3 。将 nums[0] 减少到 3 。nums = [3,1,3] 。
 * 2. largest = 3 下标为 0 。nextLargest = 1 。将 nums[0] 减少到 1 。nums = [1,1,3] 。
 * 3. largest = 3 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：0
 * 解释：nums 中的所有元素已经是相等的。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2,3]
 * 输出：4
 * 解释：需要 4 次操作使 nums 中的所有元素相等：
 * 1. largest = 3 下标为 4 。nextLargest = 2 。将 nums[4] 减少到 2 。nums = [1,1,2,2,2] 。
 * 2. largest = 2 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1,2,2] 。
 * 3. largest = 2 下标为 3 。nextLargest = 1 。将 nums[3] 减少到 1 。nums = [1,1,1,1,2] 。
 * 4. largest = 2 下标为 4 。nextLargest = 1 。将 nums[4] 减少到 1 。nums = [1,1,1,1,1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * 1 <= nums[i] <= 5 * 104
 * 通过次数4,066提交次数6,401
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reduction-operations-to-make-the-array-elements-equal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReductionOperations {

    public int reductionOperations2(int[] nums) { // Jay
        int[] cache = new int[50001];
        for (int num : nums) {
            cache[num]++;
        }
        int ans = 0;
        int count = 0;
        for (int i = cache.length - 1; i >= 0; i--) {
            if (cache[i] > 0) {
                ans += count;
                count += cache[i];
            }
        }
        return ans;
    }

    public int reductionOperations(int[] nums) {
        int res = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int j = len - 1; j > 0; --j) {
            if (nums[j - 1] != nums[j]) {
                res += len - j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReductionOperations reductionOperations = new ReductionOperations();
        System.out.println(reductionOperations.reductionOperations(new int[]{5, 1, 3}));
        System.out.println(reductionOperations.reductionOperations(new int[]{1, 2, 3}));
        System.out.println(reductionOperations.reductionOperations(new int[]{1, 1, 1}));
        System.out.println(reductionOperations.reductionOperations(new int[]{1, 1, 2, 2, 3}));
    }
}
