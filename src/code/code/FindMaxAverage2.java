package code.code;

/**
 * @author duson
 * 给定一个包含 n 个整数的数组，找到最大平均值的连续子序列，且长度大于等于 k。并输出这个最大平均值。
 * <p>
 * 样例 1:
 * <p>
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释:
 * 当长度为 5 的时候，最大平均值是 10.8，
 * 当长度为 6 的时候，最大平均值是 9.16667。
 * 所以返回值是 12.75。
 *  
 * <p>
 * 注释 :
 * <p>
 * 1 <= k <= n <= 10,000。
 * 数组中的元素范围是 [-10,000, 10,000]。
 * 答案的计算误差小于 10-5 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxAverage2 {

    public double findMaxAverage(int[] nums, int k) {
        double min = 10000;
        double max = -10000;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        double ans = min;
        while (max - min > 0.00001) {
            ans = (max + min) / 2;
            if (check(nums, k, ans)) {
                min = ans;
            } else {
                max = ans;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int k, double m) {
        double[] sum = new double[nums.length + 1];
        for (int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1] - m;
        }
        double min = 0;
        for (int i = k; i < sum.length; ++i) {
            if (sum[i] - min >= 0) {
                return true;
            }
            min = Math.min(min, sum[i - k + 1]);
        }
        return false;
    }
}
