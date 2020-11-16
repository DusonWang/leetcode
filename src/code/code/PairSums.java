package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 * <p>
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 * 提示：
 * <p>
 * nums.length <= 100000
 * 通过次数1,777提交次数3,785
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PairSums {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                ++left;
            } else if (sum > target) {
                --right;
            } else {
                ans.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
            }
        }
        return ans;
    }
}
