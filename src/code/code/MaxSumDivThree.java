package code.code;

/**
 * @author duson
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 * 在真实的面试中遇到过这道题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-sum-divisible-by-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumDivThree {

    public int maxSumDivThree(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans += x;
        }
        int r = ans % 3;
        if (r == 0) {
            return ans;
        }
        int one, oneone, two, twotwo;
        one = oneone = two = twotwo = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x % 3 == 1) {
                if (one != Integer.MAX_VALUE) {
                    oneone = Math.min(oneone, one + x);
                }
                one = Math.min(one, x);
            }
            if (x % 3 == 2) {
                if (two != Integer.MAX_VALUE) {
                    twotwo = Math.min(twotwo, two + x);
                }
                two = Math.min(two, x);
            }
        }
        if (r == 1) {
            ans -= Math.min(one, twotwo);
        } else if (r == 2) {
            ans -= Math.min(two, oneone);
        }
        return ans;
    }
}
