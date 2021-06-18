package code.code;

import java.util.Arrays;

/**
 * 给你一个整数数组nums，其中nums[i]表示第i个袋子里球的数目。同时给你一个整数maxOperations。
 * <p>
 * 你可以进行如下操作至多maxOperations次：
 * <p>
 * 选择任意一个袋子，并将袋子里的球分到2 个新的袋子中，每个袋子里都有 正整数个球。
 * 比方说，一个袋子里有5个球，你可以把它们分到两个新袋子里，分别有 1个和 4个球，或者分别有 2个和 3个球。
 * 你的开销是单个袋子里球数目的 最大值，你想要 最小化开销。
 * <p>
 * 请你返回进行上述操作后的最小开销。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [9], maxOperations = 2
 * 输出：3
 * 解释：
 * - 将装有 9 个球的袋子分成装有 6 个和 3 个球的袋子。[9] -> [6,3] 。
 * - 将装有 6 个球的袋子分成装有 3 个和 3 个球的袋子。[6,3] -> [3,3,3] 。
 * 装有最多球的袋子里装有 3 个球，所以开销为 3 并返回 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,8,2], maxOperations = 4
 * 输出：2
 * 解释：
 * - 将装有 8 个球的袋子分成装有 4 个和 4 个球的袋子。[2,4,8,2] -> [2,4,4,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,4,4,4,2] -> [2,2,2,4,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,4,4,2] -> [2,2,2,2,2,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2] 。
 * 装有最多球的袋子里装有 2 个球，所以开销为 2 并返回 2 。
 * 示例 3：
 * <p>
 * 输入：nums = [7,17], maxOperations = 2
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= maxOperations, nums[i] <= 109
 * 通过次数3,485提交次数6,570
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-limit-of-balls-in-a-bag
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumSize22 {

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ops = 0;
            for (int num : nums) {
                ops += (num - 1) / mid;
            }
            if (ops > maxOperations) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}
