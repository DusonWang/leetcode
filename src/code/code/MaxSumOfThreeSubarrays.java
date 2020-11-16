package code.code;

/**
 * @author duson
 * 给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。
 * <p>
 * 每个子数组的长度为k，我们要使这3*k个项的和最大化。
 * <p>
 * 返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,1,2,6,7,5,1], 2
 * 输出: [0, 3, 5]
 * 解释: 子数组 [1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。
 * 我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * 注意:
 * <p>
 * nums.length的范围在[1, 20000]之间。
 * nums[i]的范围在[1, 65535]之间。
 * k的范围在[1, floor(nums.length / 3)]之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumOfThreeSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxsum = 0;
        int[] sum = new int[n + 1];
        int[] posLeft = new int[n];
        int[] posRight = new int[n];
        int[] ans = new int[3];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                posLeft[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }

        posRight[n - k] = n - k;
        for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i + k] - sum[i];
            } else {
                posRight[i] = posRight[i + 1];
            }
        }

        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i - 1], r = posRight[i + k];
            int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (tot > maxsum) {
                maxsum = tot;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
}
