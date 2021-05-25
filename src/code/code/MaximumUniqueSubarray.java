package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * <p>
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * <p>
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是?a 的一个子数组。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 通过次数4,828提交次数10,951
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-erasure-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumUniqueSubarray {

    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int ans = 0;
        int j = 0;
        int i = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums.length && j < nums.length) {
            if (!set.contains(nums[j])) {
                sum += nums[j];
                ans = Math.max(sum, ans);
                set.add(nums[j++]);
            } else {
                sum -= nums[i];
                set.remove(nums[i++]);
            }
        }
        return ans;
    }

//    public int maximumUniqueSubarray(int[] nums) {
//        int score = 0;
//        int max = 0;
//        int l = 0;
//        boolean[] visited = new boolean[10001];
//        for (int num : nums) {
//            if (!visited[num]) {
//                visited[num] = true;
//                score += num;
//            } else {
//                max = Math.max(max, score);
//                while (nums[l] != num) {
//                    score -= nums[l];
//                    visited[nums[l]] = false;
//                    l++;
//                }
//                l++;
//            }
//        }
//        return Math.max(max, score);
//    }

    public static void main(String[] args) {
        MaximumUniqueSubarray maximumUniqueSubarray = new MaximumUniqueSubarray();
        System.out.println(maximumUniqueSubarray.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println(maximumUniqueSubarray.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));

    }
}
