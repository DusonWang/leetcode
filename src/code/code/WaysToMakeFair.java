package code.code;

/**
 * 给你一个整数数组nums。你需要选择 恰好一个下标（下标从 0开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 * <p>
 * 比方说，如果nums = [6,1,7,4,1]，那么：
 * <p>
 * 选择删除下标 1 ，剩下的数组为nums = [6,7,4,1]。
 * 选择删除下标2，剩下的数组为nums = [6,1,4,1]。
 * 选择删除下标4，剩下的数组为nums = [6,1,7,4]。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * <p>
 * 请你返回删除操作后，剩下的数组nums是平衡数组 的方案数。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 通过次数4,980提交次数9,186
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ways-to-make-a-fair-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WaysToMakeFair {

    public int waysToMakeFair(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] left = new int[2];
        int[] right = new int[2];
        for (int i = 0; i < n; i++) {
            right[i & 1] += nums[i];
        }
        for (int i = 0; i < n; i++) {
            right[i & 1] -= nums[i];
            if (left[0] + right[1] == left[1] + right[0]) {
                res++;
            }
            left[i & 1] += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        WaysToMakeFair waysToMakeFair = new WaysToMakeFair();
        System.out.println(waysToMakeFair.waysToMakeFair(new int[]{2,1,6,4}));
    }
}
