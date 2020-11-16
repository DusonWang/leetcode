package code.code;

/**
 * @author duson
 * 给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。
 * <p>
 * 返回给定数组完成分隔后的最大和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：A = [1,15,7,9,2,5,10], K = 3
 * 输出：84
 * 解释：A 变为 [15,15,15,9,10,10,10]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= A.length <= 500
 * 0 <= A[i] <= 10^6
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-for-maximum-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumAfterPartitioning {

    public int maxSumAfterPartitioning(int[] a, int k) {
        int len = a.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int domainMax = a[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                domainMax = Math.max(domainMax, a[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + j * domainMax);
                } else {
                    dp[i] = Math.max(dp[i], j * domainMax);
                }
            }
        }
        return dp[len - 1];
    }

}
