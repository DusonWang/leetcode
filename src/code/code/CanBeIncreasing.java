package code.code;

/**
 * 给你一个下标从 0开始的整数数组nums，如果恰好删除一个元素后，数组严格递增，那么请你返回true，否则返回false。如果数组本身已经是严格递增的，请你也返回true。
 * <p>
 * 数组nums是 严格递增的定义为：对于任意下标的1 <= i < nums.length都满足nums[i - 1] < nums[i]。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,10,5,7]
 * 输出：true
 * 解释：从 nums 中删除下标 2 处的 10 ，得到 [1,2,5,7] 。
 * [1,2,5,7] 是严格递增的，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,2]
 * 输出：false
 * 解释：
 * [3,1,2] 是删除下标 0 处元素后得到的结果。
 * [2,1,2] 是删除下标 1 处元素后得到的结果。
 * [2,3,2] 是删除下标 2 处元素后得到的结果。
 * [2,3,1] 是删除下标 3 处元素后得到的结果。
 * 没有任何结果数组是严格递增的，所以返回 false 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：false
 * 解释：删除任意元素后的结果都是 [1,1] 。
 * [1,1] 不是严格递增的，所以返回 false 。
 * 示例 4：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：true
 * 解释：[1,2,3] 已经是严格递增的，所以返回 true 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * 通过次数3,412提交次数10,204
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-one-element-to-make-the-array-strictly-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanBeIncreasing {

    public boolean canBeIncreasing(int[] nums) {
        int mismatch = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                if (i > 0) {
                    if (nums[i + 1] > nums[i - 1]) {
                        //
                    } else {
                        nums[i + 1] = nums[i];
                    }
                }
                mismatch++;
            }
        }
        return mismatch <= 1;
    }

    public static void main(String[] args) {
        CanBeIncreasing canBeIncreasing = new CanBeIncreasing();
        System.out.println(canBeIncreasing.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(canBeIncreasing.canBeIncreasing(new int[]{2, 3, 1, 2}));
    }
}
