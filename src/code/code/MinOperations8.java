package code.code;

import java.util.stream.IntStream;

/**
 * 给你两个长度可能不等的整数数组nums1 和nums2。两个数组中的所有值都在1到6之间（包含1和6）。
 * <p>
 * 每次操作中，你可以选择 任意数组中的任意一个整数，将它变成 1到 6之间 任意的值（包含 1和 6）。
 * <p>
 * 请你返回使 nums1中所有数的和与nums2中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * 示例 3：
 * <p>
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 6
 * 通过次数3,823提交次数8,093
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/equal-sum-arrays-with-minimum-number-of-operations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinOperations8 {

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums1.length > 6 * nums2.length) {
            return -1;
        }
        int sum1 = sum(nums1);
        int sum2 = sum(nums2);
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }
        int diff = sum2 - sum1;
        int[] freq = new int[6];
        for (int num : nums1) {
            ++freq[6 - num];
        }
        for (int num : nums2) {
            ++freq[num - 1];
        }
        int ans = 0;
        for (int i = 5; i > 0 && diff > 0; --i) {
            while (freq[i] > 0 && diff > 0) {
                ++ans;
                --freq[i];
                diff -= i;
            }
        }
        return diff > 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        MinOperations8 minOperations8 = new MinOperations8();
        System.out.println(minOperations8.minOperations(new int[]{1, 1, 2, 2, 2, 2}, new int[]{1, 2, 3, 4, 5, 6}));
    }
}
