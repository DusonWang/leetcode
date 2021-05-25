package code.code;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums??? 和一个整数 k????? 。区间 [left, right]（left <= right）的 异或结果 是对下标位于?left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
 * <p>
 * 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0,3,0], k = 1
 * 输出：3
 * 解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * 输出：3
 * 解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * 输出：3
 * 解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 2000
 * ??????0 <= nums[i] < 210
 * 通过次数1,888提交次数3,798
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinChanges {

    public static int minChanges(int[] nums, int k) {
        int N = nums.length;
        int[][] fre = new int[k][1024];
        for (int i = 0; i < N; i++) {
            fre[i % k][nums[i]]++;
        }
        int[] dp = new int[1024];
        Arrays.fill(dp, -N);
        dp[0] = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            int[] DP = new int[1024];
            Arrays.fill(DP, max);
            int MAX = 0;
            for (int xor = 0; xor < 1024; xor++) {
                for (int al = i; al < N; al += k) {
                    DP[xor] = Math.max(DP[xor], dp[xor ^ nums[al]] + fre[i][nums[al]]);
                }
                MAX = Math.max(MAX, DP[xor]);
            }
            max = MAX;
            dp = DP;
        }
        return N - dp[0];
    }
}
