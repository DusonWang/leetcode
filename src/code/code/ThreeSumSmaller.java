package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 * <p>
 * 示例：
 * <p>
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 *      [-2,0,1]
 * [-2,0,3]
 * 进阶：是否能在 O(n2) 的时间复杂度内解决？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-smaller
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int cnt = 0;
        final int len = nums.length;
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target) {
                    right--;
                } else {
                    cnt = cnt + right - left;
                    left++;
                }
            }
        }
        return cnt;
    }
}
