package code.code;

/**
 * @author duson
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *  
 * <p>
 * 注意:
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartitionKSubsets {

    private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        if (k == 0) {
            return true;
        }
        if (cur == target) {
            return backtracking(nums, k - 1, target, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur + nums[i] <= target) {
                used[i] = true;
                if (backtracking(nums, k, target, cur + nums[i], i + 1, used)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            if (maxNum < num) {
                maxNum = num;
            }
        }
        if (sum % k != 0 || maxNum > sum / k) {
            return false;
        }
        boolean[] used = new boolean[nums.length];
        return backtracking(nums, k, sum / k, 0, 0, used);
    }
}
