package code.code;

/**
 * @author duson
 * 给你一个整数数组?nums 和一个正整数?threshold ?，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 * <p>
 * 请你找出能够使上述结果小于等于阈值?threshold?的除数中 最小 的那个。
 * <p>
 * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
 * <p>
 * 题目保证一定有解。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,5,9], threshold = 6
 * 输出：5
 * 解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
 * 如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,5,7,11], threshold = 11
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：nums = [19], threshold = 5
 * 输出：4
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 10^4
 * 1 <= nums[i] <= 10^6
 * nums.length <=?threshold <= 10^6
 * 通过次数3,456提交次数9,511
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 1_000_000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int res = cal(nums, mid);
            if (res > threshold) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int cal(int[] nums, int div) {
        int sum = 0;
        for (int n : nums) {
            sum += n / div;
            if (n % div != 0) {
                sum += 1;
            }
        }
        return sum;
    }
}
