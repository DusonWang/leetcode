package code.code;

/**
 * 我们称一个分割整数数组的方案是 好的?，当它满足：
 * <p>
 * 数组被分成三个 非空?连续子数组，从左至右分别命名为?left?，?mid?，?right?。
 * left?中元素和小于等于?mid?中元素和，mid?中元素和小于等于?right?中元素和。
 * 给你一个 非负 整数数组?nums?，请你返回?好的 分割 nums?方案数目。由于答案可能会很大，请你将结果对 109?+ 7?取余后返回。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：1
 * 解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,2,2,5,0]
 * 输出：3
 * 解释：nums 总共有 3 种好的分割方案：
 * [1] [2] [2,2,5,0]
 * [1] [2,2] [2,5,0]
 * [1,2] [2,2] [5,0]
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：0
 * 解释：没有好的分割方案。
 * ?
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 0 <= nums[i] <= 104
 * 通过次数4,767提交次数17,836
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ways-to-split-array-into-three-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WaysToSplit {

    public int waysToSplit(int[] nums) {
        int sz = nums.length;
        int res = 0;
        for (int i = 1; i < sz; ++i) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0, j = 0, k = 0; i < sz - 2; ++i) {
            while (j <= i || j < sz - 1 && nums[j] < nums[i] * 2) {
                ++j;
            }
            while (k < j || k < sz - 1 && nums[k] - nums[i] <= nums[sz - 1] - nums[k]) {
                ++k;
            }
            res = (res + k - j) % 1000000007;
        }
        return res;
    }
}
