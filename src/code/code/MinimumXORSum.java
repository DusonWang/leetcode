package code.code;

/**
 * 给你两个整数数组nums1 和nums2，它们长度都为n。
 * <p>
 * 两个数组的 异或值之和为(nums1[0] XOR nums2[0]) + (nums1[1] XOR nums2[1]) + ... + (nums1[n - 1] XOR nums2[n - 1])（下标从 0 开始）。
 * <p>
 * 比方说，[1,2,3] 和[3,2,1]的 异或值之和等于(1 XOR 3) + (2 XOR 2) + (3 XOR 1) = 2 + 0 + 2 = 4。
 * 请你将nums2中的元素重新排列，使得 异或值之和最小。
 * <p>
 * 请你返回重新排列之后的 异或值之和。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [2,3]
 * 输出：2
 * 解释：将 nums2 重新排列得到 [3,2] 。
 * 异或值之和为 (1 XOR 3) + (2 XOR 2) = 2 + 0 = 2 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,0,3], nums2 = [5,3,4]
 * 输出：8
 * 解释：将 nums2 重新排列得到 [5,4,3] 。
 * 异或值之和为 (1 XOR 5) + (0 XOR 4) + (3 XOR 3) = 4 + 4 + 0 = 8 。
 *
 * <p>
 * 提示：
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 14
 * 0 <= nums1[i], nums2[i] <= 107
 * 通过次数1,481提交次数3,827
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-xor-sum-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumXORSum {

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] f = new int[1 << n];
        for (int mask = 1; mask < (1 << n); mask++) {
            f[mask] = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    f[mask] = Math.min(f[mask], f[mask ^ (1 << i)] + (nums1[Integer.bitCount(mask) - 1] ^ nums2[i]));
                }
            }
        }
        return f[(1 << n) - 1];
    }

}
