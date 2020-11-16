package code.code;

/**
 * @author duson
 * <p>
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsNearbyAlmostDuplicate {

    //time exceed
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(i - j) <= k && Math.abs((long) (nums[i]) - (long) (nums[j])) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        int left = 0;
        int right = left + 1;
        while (left < nums.length - 1) {
            if (right - left <= k && Math.abs((long) nums[left] - nums[right]) <= t) {
                return true;
            } else if (right - left > k || right == nums.length - 1) {
                left++;
                if (t != 0) {
                    right = left + 1;
                }
            } else {
                right++;
            }
        }
        return false;
    }
}
