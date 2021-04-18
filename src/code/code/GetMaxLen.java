package code.code;

/**
 * 给你一个整数数组 nums?，请你求出乘积为正数的最长子数组的长度。
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * <p>
 * 请你返回乘积为正数的最长子数组长度。
 * <p>
 * ?
 * <p>
 * 示例? 1：
 * <p>
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * 示例 4：
 * <p>
 * 输入：nums = [-1,2]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：nums = [1,2,3,5,-6,4,0,10]
 * 输出：4
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i]?<= 10^9
 * 通过次数5,383提交次数15,669
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetMaxLen {

    public int getMaxLen(int[] nums) {
        int positiveLength = 0;
        int negativeLength = 0;
        int maxPositive = 0;
        for (int num : nums) {
            if (num < 0) {
                int temp = positiveLength;
                positiveLength = negativeLength;
                negativeLength = temp;
                negativeLength++;
                if (positiveLength > 0) {
                    positiveLength++;
                }
            } else if (num == 0) {
                positiveLength = 0;
                negativeLength = 0;
            } else {
                positiveLength++;
                if (negativeLength > 0) {
                    negativeLength++;
                }
            }
            maxPositive = Math.max(maxPositive, positiveLength);
        }
        return maxPositive;
    }
}
